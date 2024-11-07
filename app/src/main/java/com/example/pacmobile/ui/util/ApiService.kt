package com.example.pacmobile.ui.util

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("generateQrCode/{id}")
    suspend fun generateQrCode(@Path("id") id: String): Response<ResponseBody>
}