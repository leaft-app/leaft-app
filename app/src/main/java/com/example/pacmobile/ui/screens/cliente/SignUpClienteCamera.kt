package com.example.pacmobile.ui.screens.cliente

import androidx.annotation.OptIn
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.pacmobile.ui.components.CustomButton
import com.example.pacmobile.ui.theme.AppTheme
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage

@Composable
fun ForgotPasswordStateHandler(navController: NavController = androidx.navigation.compose.rememberNavController()) {
    val emailState = remember { mutableStateOf("") }
    val showCameraPreview = remember { mutableStateOf(false) }

    if (showCameraPreview.value) {
        CameraPreview { qrCodeValue ->
            // Lógica após escanear o QR code
            // Por exemplo, você pode navegar para uma nova tela ou lidar com o valor QR code
            navController.navigate("codigo-recuperação-nutricionista") {
                popUpTo("forgot-password") { inclusive = true }
            }
        }
    } else {
        ForgotPassword(
            email = emailState.value,
            onEmailChange = { emailState.value = it },
            onLoginClick = {
                showCameraPreview.value = true // Ativa a visualização da câmera ao clicar no botão
            },
        )
    }
}

@Composable
fun ForgotPassword(
    email: String,
    onEmailChange: (String) -> Unit,
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
                onClick = { onLoginClick() }, // Atualiza para chamar a função de clique
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
                                        onQRCodeScanned(qrCodeValue)
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
                    exc.printStackTrace()
                }
            }, cameraExecutor)

            previewView
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewForgotPassword() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        ForgotPasswordStateHandler()
    }
}
