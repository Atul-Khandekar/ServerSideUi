package com.example.model


import com.google.gson.annotations.SerializedName

data class ServerResponseModel(
    @SerializedName("json")
    val json: List<UIModelItem>?
)