package com.example.service

import com.example.model.UIModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ServerSideUIService {

    @GET("android")
    suspend fun getUIFromServer(): Response<List<UIModelItem>>


    companion object {
        const val BASE_API =  "https://beautiful-chebakia-12c90f.netlify.app/api/"
    }
}