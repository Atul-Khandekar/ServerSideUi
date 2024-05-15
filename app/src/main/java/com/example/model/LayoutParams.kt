package com.example.model


import com.google.gson.annotations.SerializedName

data class LayoutParams(
    @SerializedName("margin")
    val margin: Margin?,
    @SerializedName("padding")
    val padding: Padding?
)