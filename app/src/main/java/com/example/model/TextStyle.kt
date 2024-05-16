package com.example.model


import com.google.gson.annotations.SerializedName

data class TextStyle(
    @SerializedName("lineHeight")
    val lineHeight: Int?,
    @SerializedName("maxLines")
    val maxLines: Int?,
    @SerializedName("textColor")
    val textColor: String?,
    @SerializedName("textSize")
    val textSize: Int?,
    @SerializedName("textStyle")
    val textStyle: String?,
    @SerializedName("alignment")
    val alignment: String?
)