package com.ildiesign.plantcare.connection.model.service

import com.ildiesign.plantcare.model.PlantGroupModel

data class LoginResponseModel(

    val success: Boolean,
    val message: String,
    val userId: String,
    val name: String,
    val plantGroups: List<PlantGroupModel>

)