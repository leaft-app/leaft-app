package com.example.pacmobile.ui.presentation.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pacmobile.data.repository.AuthRepository
import com.example.pacmobile.data.repository.QRCodeRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NutritionistViewModel(
    private val authRepository: AuthRepository, // Injetando o repositório de autenticação
    private val qrCodeRepository: QRCodeRepository // Injetando o repositório de QR Code
) : ViewModel() {

    // Estado do usuário autenticado
    private val _currentUser = MutableStateFlow<FirebaseUser?>(authRepository.getCurrentUser())
    val currentUser: StateFlow<FirebaseUser?> = _currentUser.asStateFlow()

    // StateFlow para armazenar o bitmap do QR Code gerado
    private val _qrCodeBitmap = MutableStateFlow<Bitmap?>(null)
    val qrCodeBitmap: StateFlow<Bitmap?> = _qrCodeBitmap.asStateFlow()

    // Estado para representar erros de autenticação
    private val _authError = MutableStateFlow<String?>(null)
    val authError: StateFlow<String?> = _authError.asStateFlow()

    // Estado para representar erros da API
    private val _apiError = MutableStateFlow<String?>(null)
    val apiError: StateFlow<String?> = _apiError.asStateFlow()

    /**
     * Função de login que utiliza o AuthRepository
     */
    fun login(email: String, password: String) {
        viewModelScope.launch {
            if (email.isBlank() || password.isBlank()) {
                _authError.value = "Email e senha não podem ser vazios."
                return@launch
            }
            val user = authRepository.loginUser(email, password)
            if (user != null) {
                _currentUser.value = user
                _authError.value = null // Limpa erro caso login seja bem-sucedido
            } else {
                _authError.value = "Erro ao fazer login. Verifique as credenciais."
            }
        }
    }

    /**
     * Função de registro que utiliza o AuthRepository
     */
    fun register(email: String, password: String) {
        viewModelScope.launch {
            if (email.isBlank() || password.isBlank()) {
                _authError.value = "Email e senha não podem ser vazios."
                return@launch
            }
            val user = authRepository.registerUser(email, password)
            if (user != null) {
                _currentUser.value = user
                _authError.value = null // Limpa erro caso registro seja bem-sucedido
            } else {
                _authError.value = "Erro ao criar conta. Tente novamente."
            }
        }
    }

    /**
     * Função para buscar o QR Code pela API usando o QRCodeRepository.
     */
    fun fetchQrCode(id: String) {
        viewModelScope.launch {
            try {
                val bitmap = qrCodeRepository.getQrCodeBitmap(id)
                if (bitmap != null) {
                    _qrCodeBitmap.value = bitmap // Atualiza o QR Code na UI
                    _apiError.value = null
                } else {
                    _apiError.value = "Falha ao gerar QR Code. Tente novamente."
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _apiError.value = "Erro de conexão. Tente novamente."
            }
        }
    }
}