package com.ildiesign.plantcare.screen.home

import com.ildiesign.plantcare.model.FullPlantGroupModel
import com.ildiesign.plantcare.model.PlantGroupModel


object PlantGroupGenerator {


    private val species = intArrayOf( 2, 5, 3, 8, 4, 3, 2 )
    private val plants = intArrayOf( 6, 13, 5, 11, 9, 5, 6 )
    private val lastWatered = Array( 7 ) { "yesterday" }
    private val nextWatering = arrayOf( "16 May 2018", "21 May 2018", "14 May 2018", "23 May 2018", "25 May 2018", "18 May 2018", "15 May 2018"  )
    private val percent = intArrayOf( 24, 75, 43, 18, 51, 81, 38 )


    fun getFullCardlist( plantGroupList: List<PlantGroupModel> ): ArrayList<FullPlantGroupModel> =

        arrayListOf<FullPlantGroupModel>().apply {

            for ( i in plantGroupList.indices ) {

                add(
                    FullPlantGroupModel(
                        plantGroupList[ i ]._id,
                        plantGroupList[ i ].name,
                        species[ i ],
                        plants[ i ],
                        lastWatered[ i ],
                        nextWatering[ i ],
                        percent[ i ]
                    )
                )
            }

        }

}