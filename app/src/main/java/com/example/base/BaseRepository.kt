package com.example.base

import retrofit2.Response

open class BaseRepository {

    fun <T> handleResponse(response: Response<T>): BaseResponse<T> {
        return try {
            if (response.isSuccessful) {
                BaseResponse.Success(response.body())
            } else {
                if (response.code() in 400..499) {
                    response.errorBody().let {
                        BaseResponse.Error("Something Went Wrong")
                    }
                } else if (response.code() in 500..599) {
                    BaseResponse.Error("Internal Server Error")
                } else {
                    BaseResponse.Error(response.message())
                }
            }

        } catch (e: Error) {
            BaseResponse.Error(e.message ?: "Something went wrong")
        }
    }
}