package com.example.model


import com.google.gson.annotations.SerializedName

data class Margin(
    @SerializedName("bottom")
    val bottom: Int?,
    @SerializedName("left")
    val left: Int?,
    @SerializedName("right")
    val right: Int?,
    @SerializedName("top")
    val top: Int?
)