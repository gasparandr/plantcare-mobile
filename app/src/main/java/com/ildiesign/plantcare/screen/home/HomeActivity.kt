package com.ildiesign.plantcare.screen.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.ContextThemeWrapper
import android.support.v7.widget.PopupMenu
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.ildiesign.plantcare.R
import com.ildiesign.plantcare.User
import com.ildiesign.plantcare.model.FullPlantGroupModel
import com.ildiesign.plantcare.screen.manage_moderators.ManageModeratorsActivity
import com.yarolegovich.discretescrollview.DSVOrientation
import com.yarolegovich.discretescrollview.DiscreteScrollView
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {


    private val TAG = this::class.simpleName



    private lateinit var cardList: ArrayList<FullPlantGroupModel>

    private lateinit var cardAdapter: CardAdapter



    private var listPosition = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_home )

        cardList = PlantGroupGenerator.getFullCardlist( User.plantGroups!! )

        cardAdapter =  CardAdapter( this@HomeActivity, cardList, ::cardOptionClick )

        updateListPositionUI()

        updateWaterButton()

        with ( v_card_list ) {

            setOrientation( DSVOrientation.HORIZONTAL )

            addScrollStateChangeListener( CardChangeListener() )

            setItemTransformer( ElevationTransformer() )

            adapter = cardAdapter

        }


        v_button_water.setOnClickListener { waterPlantGroup() }

    }



    private fun message( text: String? ) {
        Toast.makeText( this, text, Toast.LENGTH_SHORT ).show()
    }



    private inner class CardChangeListener
        : DiscreteScrollView.ScrollStateChangeListener<CardAdapter.ViewHolder> {

        override fun onScrollStart(currentItemHolder: CardAdapter.ViewHolder, adapterPosition: Int) {}

        override fun onScroll(scrollPosition: Float, currentPosition: Int, newPosition: Int, currentHolder: CardAdapter.ViewHolder?, newCurrent: CardAdapter.ViewHolder?) {}

        override fun onScrollEnd(currentItemHolder: CardAdapter.ViewHolder, adapterPosition: Int) {

            listPosition = adapterPosition

            updateListPositionUI()

            updateWaterButton()

        }



    }



    private fun updateListPositionUI() {

        v_card_position.text = "${listPosition + 1}/${cardList.size}"

    }



    private fun updateWaterButton() {

        val currentItem = cardList[ listPosition ]

        with ( v_button_water ) {

            isEnabled = currentItem.percent < 100

            text = "Water ${currentItem.name}"

        }

    }



    private fun waterPlantGroup() {

        with ( cardList[ listPosition ] ) {

            percent = 100
            lastWatered = "today"
            nextWatering = ( nextWatering.substring( 0..1 ).toInt() + 5 ).toString() +
                             nextWatering.substring( 2 )

        }


        cardAdapter.notifyItemChanged( listPosition )

        updateWaterButton()

    }



    private fun cardOptionClick( position: Int, view: View ) {

        val image = view as ImageView
        val bg = image.drawable
        val bgActive = getDrawable( R.drawable.ic_options_active )

        image.setImageDrawable( bgActive )


        PopupMenu( ContextThemeWrapper( this, R.style.PopupMenu ), view ).apply {

            gravity = Gravity.END
            menuInflater.inflate( R.menu.menu_plant_group, menu )

            setOnDismissListener { image.setImageDrawable( bg ) }

            setOnMenuItemClickListener { item ->

                when ( item.itemId ) {

                    R.id.manage_moderators -> {

                        startActivity(
                            Intent( this@HomeActivity, ManageModeratorsActivity::class.java )
                                .apply { putExtra( "PLANT_GROUP", cardList[ position ]._id ) }
                        )

                        true
                    }

                    else -> false

                }

            }

            show()

        }



    }


}