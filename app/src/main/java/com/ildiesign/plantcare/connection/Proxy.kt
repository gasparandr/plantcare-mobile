package com.ildiesign.plantcare.connection

import com.ildiesign.plantcare.connection.model.response.CallbackWrapper
import com.ildiesign.plantcare.connection.model.service.AuthModel
import com.ildiesign.plantcare.connection.model.service.BaseResponseModel
import com.ildiesign.plantcare.connection.model.service.InviteModel
import com.ildiesign.plantcare.connection.model.service.LoginResponseModel
import com.ildiesign.plantcare.connection.service.Service
import okhttp3.ResponseBody

object Proxy {

    private val TAG = this::class.simpleName

    private val service by lazy { Service.getInstance() }


    fun login( data: AuthModel, successCB: ( result: LoginResponseModel ) -> Unit ) {
        service.login( data ).enqueue( CallbackWrapper( successCB ) )
    }



    fun invite( data: InviteModel, successCB: ( result: BaseResponseModel ) -> Unit ) {
        service.invite( data ).enqueue( CallbackWrapper( successCB ) )
    }


}