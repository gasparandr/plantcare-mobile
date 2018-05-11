package com.ildiesign.plantcare.screen.auth

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ildiesign.plantcare.R


class AuthActivity : AppCompatActivity() {

    private val TAG = this::class.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_auth )
    }


}