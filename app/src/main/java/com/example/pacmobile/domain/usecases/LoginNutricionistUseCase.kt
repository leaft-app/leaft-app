package com.example.pacmobile.domain

import com.example.pacmobile.data.model.Nutritionist
import com.example.pacmobile.data.repository.NutritionistRepository

class NutritionistUseCase(private val nutritionistRepository: NutritionistRepository) {

    suspend fun getNutritionistById(id: String): Nutritionist? {
        val document = nutritionistRepository.getNutritionistById(id)
        return document?.toObject(Nutritionist::class.java)
    }

    suspend fun createNutritionist(nutritionist: Nutritionist): Boolean {
        val data = mapOf(
            "id" to nutritionist.id,
            "name" to nutritionist.name,
            "email" to nutritionist.email,

        )
        return nutritionistRepository.createNutritionist(nutritionist.id, data)
    }
}