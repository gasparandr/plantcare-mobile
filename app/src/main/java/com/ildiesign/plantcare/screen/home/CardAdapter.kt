package com.ildiesign.plantcare.screen.home

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ildiesign.plantcare.R
import com.ildiesign.plantcare.model.FullPlantGroupModel
import kotlinx.android.synthetic.main.card_plantgroup.view.*


class CardAdapter(
        private val context: Context,
        private val itemList: List<FullPlantGroupModel>,
        private val itemClickCb: ( position: Int, view: View ) -> Unit )

    : RecyclerView.Adapter<CardAdapter.ViewHolder>() {



    private val loaderBgOne     = ContextCompat.getDrawable( this.context, R.drawable.watering_percent_bg )
    private val loaderBgTwo     = ContextCompat.getDrawable( this.context, R.drawable.watering_percent_two_bg )
    private val loaderBgThree   = ContextCompat.getDrawable( this.context, R.drawable.watering_percent_three_bg )



    inner class ViewHolder( v: View ) : RecyclerView.ViewHolder( v )



    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): ViewHolder =
        ViewHolder( LayoutInflater.from( parent.context ).inflate(
                    R.layout.card_plantgroup, parent, false
        ))



    override fun getItemCount() = itemList.size



    override fun onBindViewHolder( holder: ViewHolder, position: Int ) {

        with ( holder.itemView ) {

            val item = itemList[ position ]
            val percent = item.percent.toDouble()

            v_card_species.text = "${item.species} species | ${item.plants} plants"
            v_card_name.text = item.name
            v_card_last_watered.text = item.lastWatered
            v_card_next_watering.text = item.nextWatering
            v_card_percent.text = "${item.percent}%"

            with ( v_card_loader ) {

                background = when ( percent ) {

                    in 0..33    -> loaderBgOne
                    in 34..66   -> loaderBgTwo
                    else        -> loaderBgThree

                }

                width = ( parent as View ).let {

                    it.measure( View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED )

                    ( it.measuredWidth * percent / 100 ).toInt()

                }

            }

            v_card_options.setOnClickListener { itemClickCb( position, it ) }

        }

    }



}