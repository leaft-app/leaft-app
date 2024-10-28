package com.example.pacmobile.ui.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NutritionistViewModel : ViewModel() {

    // Retrofit e serviço da API
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:8080/") // Altere para o endereço do servidor
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    // StateFlow para armazenar o ID do nutricionista
    private val _nutritionistId = MutableStateFlow<String?>(null)
    val nutritionistId: StateFlow<String?> = _nutritionistId.asStateFlow()

    // StateFlow para armazenar o bitmap do QR Code gerado
    private val _qrCodeBitmap = MutableStateFlow<Bitmap?>(null)
    val qrCodeBitmap: StateFlow<Bitmap?> = _qrCodeBitmap.asStateFlow()

    /**
     * Define o ID do nutricionista.
     */
    fun setNutritionistId(id: String) {
        _nutritionistId.value = id
    }

    /**
     * Gera o QR Code localmente com base no ID do nutricionista.
     */
    fun generateQrCode() {
        val id = _nutritionistId.value
        if (!id.isNullOrEmpty()) {
            viewModelScope.launch {
                try {
                    _qrCodeBitmap.value = createQrCodeBitmap(id)
                } catch (e: Exception) {
                    e.printStackTrace()
                    _qrCodeBitmap.value = null // Limpa o bitmap em caso de erro
                }
            }
        }
    }

    /**
     * Método para criar o bitmap do QR Code a partir de uma string.
     */
    private fun createQrCodeBitmap(content: String): Bitmap {
        val qrCodeWriter = QRCodeWriter()
        val size = 512 // Definindo tamanho do QR Code
        val bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, size, size)
        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565)

        for (x in 0 until size) {
            for (y in 0 until size) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        return bitmap
    }

    /**
     * Função para buscar o QR Code pela API.
     */
    fun fetchQrCode(id: String) {
        viewModelScope.launch {
            try {
                val response = apiService.generateQrCode(id)
                if (response.isSuccessful) {
                    val inputStream = response.body()?.byteStream()
                    val bitmap = BitmapFactory.decodeStream(inputStream)
                    _qrCodeBitmap.value = bitmap // Atualiza o QR Code na UI
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
