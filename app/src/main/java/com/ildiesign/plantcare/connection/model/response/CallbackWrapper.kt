package com.ildiesign.plantcare.connection.model.response

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CallbackWrapper<T>(
    private val successCallback: ( ( res: T ) -> Unit )? = null )

    : Callback<T> {


    private val TAG = this::class.simpleName


    override fun onResponse( call: Call<T>?, response: Response<T>? ) {

        response?.let {

            val code    = it.code()
            val result  = it.body()

            if ( code == 200 && result != null ) {

                successCallback?.invoke( result )

            } else Log.d(TAG, "code not 200 or empty body")

        }

    }



    override fun onFailure(call: Call<T>?, t: Throwable?) {
        Log.d(TAG, t?.message.toString())
    }




}