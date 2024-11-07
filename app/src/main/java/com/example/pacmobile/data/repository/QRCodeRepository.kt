package com.example.pacmobile.data.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.pacmobile.ui.util.ApiService

class QRCodeRepository(private val apiService: ApiService) {

    /**
     * Função para obter o Bitmap do QR Code através da API.
     */
    suspend fun getQrCodeBitmap(id: String): Bitmap? {
        val response = apiService.generateQrCode(id)
        return if (response.isSuccessful) {
            val inputStream = response.body()?.byteStream()
            BitmapFactory.decodeStream(inputStream)
        } else {
            null
        }
    }
}
