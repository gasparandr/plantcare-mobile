package com.ildiesign.plantcare.screen.auth

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ildiesign.plantcare.R
import com.ildiesign.plantcare.connection.Proxy
import com.ildiesign.plantcare.connection.model.service.AuthModel
import com.ildiesign.plantcare.connection.model.service.LoginResponseModel
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private val TAG = this::class.simpleName


    private val inactiveBorder = R.drawable.input_bg
    private val activeBorder   = R.drawable.input_active_bg



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate( R.layout.fragment_login, container, false )



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** input focus change */
        v_email.setOnFocusChangeListener( ::focusChange )
        v_password.setOnFocusChangeListener( ::focusChange )

        /** login */
        v_button_login.setOnClickListener { login() }
    }



    private fun message( text: String ) {

        Toast.makeText( context, text, Toast.LENGTH_SHORT ).show()

    }



    private fun focusChange( v: View, hasFocus: Boolean ) {

        ( v.parent as? View )?.background =
                context?.getDrawable( if ( hasFocus ) activeBorder else inactiveBorder )

    }



    private fun login() {

        val email = v_email.text
        val password = v_password.text

        if ( email.isNullOrBlank() || password.isNullOrBlank() )
            message( "Please fill both fields" )

        else {

            Proxy.login(
                AuthModel( email.toString(), password.toString() ),
                ::loginResponse
            )

        }

    }



    private fun loginResponse( result: LoginResponseModel ) {

        if ( ! result.success ) message( result.message )

        else {



        }

    }





}