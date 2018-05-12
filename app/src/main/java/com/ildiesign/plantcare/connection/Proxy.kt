package com.ildiesign.plantcare.connection

import com.ildiesign.plantcare.connection.model.response.CallbackWrapper
import com.ildiesign.plantcare.connection.model.service.AuthModel
import com.ildiesign.plantcare.connection.model.service.LoginResponseModel
import com.ildiesign.plantcare.connection.service.Service

object Proxy {

    private val TAG = this::class.simpleName

    private val service by lazy { Service.getInstance() }




    fun login( data: AuthModel, successCB: ( result: LoginResponseModel ) -> Unit ) {
        service.login( data ).enqueue( CallbackWrapper( successCB ) )
    }


}