package com.example.pacmobile.data.repository

import com.example.pacmobile.ui.util.ApiService
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.coroutines.tasks.await

class NutritionistRepository(
    private val apiService: ApiService, // Serviço para chamadas HTTP
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance() // Instância do Firestore
) {

    /**
     * Busca dados do nutricionista pela API.
     */
    suspend fun getNutritionistById(id: String): DocumentSnapshot? {
        return try {
            val document = firestore.collection("nutritionists").document(id).get().await()
            document
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Cria um novo nutricionista no Firebase Firestore.
     */
    suspend fun createNutritionist(id: String, data: Map<String, Any>): Boolean {
        return try {
            firestore.collection("nutritionists").document(id).set(data).await()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}