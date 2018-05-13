package com.ildiesign.plantcare.screen.manage_moderators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.ildiesign.plantcare.R
import com.ildiesign.plantcare.User
import com.ildiesign.plantcare.connection.Proxy
import com.ildiesign.plantcare.connection.model.service.BaseResponseModel
import com.ildiesign.plantcare.connection.model.service.InviteModel
import kotlinx.android.synthetic.main.activity_manage_moderators.*


class ManageModeratorsActivity : AppCompatActivity() {

    private val TAG = this::class.simpleName


    private lateinit var plantGroup: String


    private var validEmail = false


    private val inactiveBorder = R.drawable.input_bg
    private val activeBorder   = R.drawable.input_active_bg



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_manage_moderators )

        plantGroup = intent.extras.getString( "PLANT_GROUP" )


        v_email.setOnFocusChangeListener( ::focusChange )

        v_remove_user.setOnClickListener { v_user_list.removeView( it.parent as View ) }

        v_close_screen.setOnClickListener { finish() }

        v_action_button.setOnClickListener {

            if ( validEmail ) sendInvite()
            else finish()

        }


        v_email.addTextChangedListener( object : TextWatcher {

            override fun onTextChanged( s: CharSequence?, start: Int, before: Int, count: Int ) {

                validEmail = isValidEmail( s )

                v_action_button.text = if ( validEmail ) "Add 1 moderator" else "Close"

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })


    }




    private fun focusChange(v: View, hasFocus: Boolean ) {

        ( v.parent as? View)?.background =
                getDrawable( if ( hasFocus ) activeBorder else inactiveBorder )

    }



    private fun isValidEmail( email: CharSequence? ): Boolean =
        ! email.isNullOrBlank() && Patterns.EMAIL_ADDRESS.matcher( email ).matches()




    private fun sendInvite() {

        Proxy.invite(
            InviteModel(
                v_email.text.toString(),
                plantGroup,
                User.name!!
            ),

            ::inviteResult
        )


    }



    private fun inviteResult( result: BaseResponseModel ) {

        if ( result.success ) v_email.text.clear()

        Toast.makeText(this, result.message, Toast.LENGTH_LONG).show()

    }



}