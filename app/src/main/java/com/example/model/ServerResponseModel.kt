package com.example.model


import com.google.gson.annotations.SerializedName

data class ServerResponseModel(
    @SerializedName("json")
    val json: Json?
)

data class Json(
    @SerializedName("json")
    val json: List<UIModelItem>?
)