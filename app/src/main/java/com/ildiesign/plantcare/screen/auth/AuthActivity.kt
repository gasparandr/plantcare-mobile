package com.ildiesign.plantcare.screen.auth

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ildiesign.plantcare.R
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : AppCompatActivity() {

    private val TAG = this::class.simpleName



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_auth )

        v_tab_layout.setupWithViewPager(
            v_viewpager.apply {
                adapter = AuthAdapter( this@AuthActivity, supportFragmentManager )
            }
        )

    }


}