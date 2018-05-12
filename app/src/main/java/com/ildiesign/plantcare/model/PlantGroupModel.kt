package com.ildiesign.plantcare.model

data class PlantGroupModel (

    val _id: String,
    val name: String,
    val description: String,
    val owner: String,
    val moderators: List<*>

)