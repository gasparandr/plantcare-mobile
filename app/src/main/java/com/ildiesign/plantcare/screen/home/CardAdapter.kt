package com.ildiesign.plantcare.screen.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ildiesign.plantcare.R
import com.ildiesign.plantcare.model.FullPlantGroupModel


class CardAdapter(
       private val itemList: List<FullPlantGroupModel>,
       private val itemclickCb: ( position: Int, view: View ) -> Unit
)
    : RecyclerView.Adapter<CardAdapter.ViewHolder>() {



    inner class ViewHolder( v: View ) : RecyclerView.ViewHolder( v )



    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): ViewHolder =
        ViewHolder( LayoutInflater.from( parent.context ).inflate(
                    R.layout.card_plantgroup, parent, false
        ))



    override fun getItemCount() = 5 //itemList.size



    override fun onBindViewHolder( holder: ViewHolder, position: Int ) {



    }



}