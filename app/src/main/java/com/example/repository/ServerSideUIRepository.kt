package com.example.repository

import com.example.base.BaseRepository
import com.example.base.BaseResponse
import com.example.service.ServerSideUIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ServerSideUIRepository @Inject constructor(private val service: ServerSideUIService) : BaseRepository() {
    suspend fun getUIFromServer() = flow {
        emit(BaseResponse.Loading())
        emit(handleResponse(service.getUIFromServer()))
    }.flowOn(Dispatchers.IO)
}