package com.ildiesign.plantcare.connection.service


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object Service {

    private val TAG = this::class.simpleName

    private const val SERVICE_URL = "http://10.10.0.42:1337"

    private lateinit var instance: IService

    private val httpClient by lazy {

        OkHttpClient.Builder()
                    .connectTimeout( 15, TimeUnit.SECONDS )
                    .readTimeout( 15, TimeUnit.SECONDS )
                    .addInterceptor(
                        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
                    ).build()

    }


    fun getInstance(): IService {

        if ( ! this::instance.isInitialized ) {

            instance = Retrofit.Builder()
                               .baseUrl( SERVICE_URL )
                               .addConverterFactory( GsonConverterFactory.create() )
                               .client( httpClient )
                               .build()
                               .create( IService::class.java )

        }

        return instance
    }

}