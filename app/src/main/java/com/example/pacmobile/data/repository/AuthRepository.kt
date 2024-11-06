package com.example.pacmobile.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class AuthRepository {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Função de login
    suspend fun loginUser(email: String, password: String): FirebaseUser? {
        return try {
            val authResult = auth.signInWithEmailAndPassword(email, password).await()
            authResult.user
        } catch (e: Exception) {
            null
        }
    }

    // Função de cadastro
    suspend fun registerUser(email: String, password: String): FirebaseUser? {
        return try {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            authResult.user
        } catch (e: Exception) {
            null
        }
    }

    // Função para obter o usuário atual
    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }
}
