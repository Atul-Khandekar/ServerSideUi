package com.example.model


import com.google.gson.annotations.SerializedName

data class CornerRadius(
    @SerializedName("bottomLeft")
    val bottomLeft: Int?,
    @SerializedName("bottomRight")
    val bottomRight: Int?,
    @SerializedName("topLeft")
    val topLeft: Int?,
    @SerializedName("topRight")
    val topRight: Int?
)