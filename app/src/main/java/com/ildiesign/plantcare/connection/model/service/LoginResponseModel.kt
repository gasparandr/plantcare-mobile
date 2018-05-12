package com.ildiesign.plantcare.connection.model.service

data class LoginResponseModel(

    val success: Boolean,
    val message: String,
    val userId: String,
    val name: String,
    val plantGroup: List<*>

)