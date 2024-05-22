package com.example.model


import com.google.gson.annotations.SerializedName

data class LayoutParams(
    @SerializedName("padding")
    val padding: Padding?
)