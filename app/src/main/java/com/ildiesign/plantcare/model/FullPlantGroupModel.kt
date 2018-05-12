package com.ildiesign.plantcare.model


data class FullPlantGroupModel(

    val _id: String,
    val name: String,
    val species: Int,
    val plants: Int,
    var lastWatered: String,
    var nextWatering: String,
    var percent: Int

)