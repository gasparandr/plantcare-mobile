package com.ildiesign.plantcare.connection.service

import com.ildiesign.plantcare.connection.model.service.AuthModel
import com.ildiesign.plantcare.connection.model.service.LoginResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface IService {


    @POST
    fun login(
        @Url url: String,
        @Body data: AuthModel
    ) : Call<LoginResponseModel>


}