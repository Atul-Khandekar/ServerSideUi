package com.example.service

import com.example.model.ServerResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ServerSideUIService {

    @GET("android")
    suspend fun getUIFromServer(): Response<ServerResponseModel>

}