package com.example.pacmobile.ui.presentation.screens.cliente

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.OptIn
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import com.example.pacmobile.R
import com.example.pacmobile.ui.presentation.components.CustomButton
import com.example.pacmobile.ui.presentation.theme.AppTheme
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage

@Composable
fun SignUpClienteCameraStateHandler(navController: NavController = androidx.navigation.compose.rememberNavController()) {
    val showCameraPreview = remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Lançador para solicitar permissão de câmera
    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            showCameraPreview.value = true // Exibir a pré-visualização da câmera se a permissão for concedida
        } else {
            Toast.makeText(context, "Permissão de câmera é necessária.", Toast.LENGTH_SHORT).show()
        }
    }

    if (showCameraPreview.value) {
        CameraPreview { qrCodeValue ->
            navController.navigate("sign-up-cliente/$qrCodeValue") {
                popUpTo("sign-up-camera-cliente") { inclusive = true }
            }
        }
    } else {
        SignUpClienteCamera(
            onLoginClick = {
                // Verificar se a permissão já foi concedida
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    showCameraPreview.value = true // Exibir pré-visualização da câmera se a permissão já foi concedida
                } else {
                    // Solicitar permissão se ainda não concedida
                    cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                    Log.d("CameraPermission", "Solicitando permissão de câmera")
                }
            },
        )
    }
}

@Composable
fun SignUpClienteCamera(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(177.dp, 198.dp)
            )

            Text(
                text = "Faça seu Cadastro",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                fontSize = 24.sp
            )

            Text(
                text = AnnotatedString.Builder().apply {
                    append("Aceite a permissão para acessar a câmera do seu celular e aponte para o ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("QR Code")
                    }
                    append(" de seu ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("nutricionista")
                    }
                }.toAnnotatedString(),
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.undraw_people_re_8spw_1),
                contentDescription = "Pessoas",
                modifier = Modifier.size(209.dp, 180.dp)
            )

            CustomButton(
                text = "Abrir Câmera",
                onClick = { onLoginClick() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(220.dp, 48.dp)
                    .padding(top = 16.dp)
            )
        }
    }
}

@OptIn(ExperimentalGetImage::class)
@Composable
fun CameraPreview(
    onQRCodeScanned: (String) -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { ctx ->
                val previewView = PreviewView(ctx)
                val cameraExecutor = ContextCompat.getMainExecutor(ctx)

                cameraProviderFuture.addListener({
                    val cameraProvider = cameraProviderFuture.get()
                    val preview = androidx.camera.core.Preview.Builder().build().also {
                        it.setSurfaceProvider(previewView.surfaceProvider)
                    }

                    val barcodeScanner = BarcodeScanning.getClient()
                    val imageAnalysis = ImageAnalysis.Builder()
                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                        .build()

                    imageAnalysis.setAnalyzer(cameraExecutor) { imageProxy ->
                        val mediaImage = imageProxy.image
                        if (mediaImage != null) {
                            val inputImage = InputImage.fromMediaImage(
                                mediaImage,
                                imageProxy.imageInfo.rotationDegrees
                            )
                            barcodeScanner.process(inputImage)
                                .addOnSuccessListener { barcodes ->
                                    for (barcode in barcodes) {
                                        barcode.rawValue?.let { qrCodeValue ->
                                            // Certifique-se de que qrCodeValue seja o nutricionistaId
                                            Log.d("QRCodeValue", "QR Code lido: $qrCodeValue")
                                            onQRCodeScanned(qrCodeValue) // Passa o valor do QR Code para a lógica da tela de cadastro
                                        }
                                    }
                                }
                                .addOnCompleteListener {
                                    imageProxy.close()
                                }
                        }
                    }


                    val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                    try {
                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(
                            lifecycleOwner,
                            cameraSelector,
                            preview,
                            imageAnalysis
                        )
                    } catch (exc: Exception) {
                        Log.e("CameraPreview", "Error binding camera use cases", exc)
                    }
                }, cameraExecutor)

                previewView
            }
        )

        // Desenhar um quadrado na tela
        DrawSquare()
    }
}

@Composable
fun DrawSquare() {
    val squareSize = 200.dp // Tamanho do quadrado

    Box(
        modifier = Modifier
            .size(squareSize)
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCamera() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        SignUpClienteCameraStateHandler()
    }
}
