package com.ildiesign.plantcare.screen.home


import android.view.View
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer
import com.yarolegovich.discretescrollview.transform.Pivot



class ElevationTransformer : DiscreteScrollItemTransformer {

    private val TAG = this::class.simpleName


    private val pivotX = Pivot.X.CENTER.create()
    private val pivotY = Pivot.Y.CENTER.create()
    private val minScale = 0.85F
    private val maxMinDif = 0.2F

    private val maxElevation = 25F
    private val minElevation = 3F




    override fun transformItem( item: View?, position: Float ) {

        val closenessToCenter = 1F - Math.abs( position )
        val scale = minScale + maxMinDif * closenessToCenter


        item?.let {

            /** Scale transform */
            pivotX.setOn( it ); pivotY.setOn( it )
            it.scaleX = scale; it.scaleY = scale


            /** Elevation */
            it.elevation = ( maxElevation * closenessToCenter )
                            .takeIf { it >= minElevation } ?: minElevation

        }

    }

}