package com.ildiesign.plantcare.screen.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.ildiesign.plantcare.R
import com.ildiesign.plantcare.model.FullPlantGroupModel
import com.yarolegovich.discretescrollview.DSVOrientation
import com.yarolegovich.discretescrollview.DiscreteScrollView
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {


    private val TAG = this::class.simpleName



    private lateinit var cardList: ArrayList<FullPlantGroupModel>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_home )

        //TODO generate list

        with ( v_card_list ) {

            setOrientation( DSVOrientation.HORIZONTAL )

            addOnItemChangedListener( CardChangeListener() )

            adapter = CardAdapter( listOf(), ::cardOptionClick )

        }

    }



    private fun message( text: String? ) {
        Toast.makeText( this, text, Toast.LENGTH_SHORT ).show()
    }



    private inner class CardChangeListener
        : DiscreteScrollView.OnItemChangedListener<CardAdapter.ViewHolder> {

        override fun onCurrentItemChanged( viewHolder: CardAdapter.ViewHolder?, adapterPosition: Int) {
            Log.d(TAG, adapterPosition.toString())
        }

    }




    private fun cardOptionClick( position: Int, view: View ) {



    }


}