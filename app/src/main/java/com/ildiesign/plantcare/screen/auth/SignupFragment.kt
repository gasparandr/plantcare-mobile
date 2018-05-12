package com.ildiesign.plantcare.screen.auth

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ildiesign.plantcare.R
import kotlinx.android.synthetic.main.fragment_signup.*


class SignupFragment : Fragment() {

    private val TAG = this::class.simpleName


    private val inactiveBorder = R.drawable.input_bg
    private val activeBorder   = R.drawable.input_active_bg



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate( R.layout.fragment_signup, container, false )



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        v_email.setOnFocusChangeListener( ::focusChange )
        v_username.setOnFocusChangeListener( ::focusChange )
        v_password.setOnFocusChangeListener( ::focusChange )
    }



    private fun focusChange( v: View, hasFocus: Boolean ) {

        ( v.parent as? View )?.background =
                context?.getDrawable( if ( hasFocus ) activeBorder else inactiveBorder )

    }


}