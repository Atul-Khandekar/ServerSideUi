package com.example.model


import com.google.gson.annotations.SerializedName

data class Modifier(
    @SerializedName("alignment")
    val alignment: String?,
    @SerializedName("backgroundColor")
    val backgroundColor: String?,
    @SerializedName("borderColor")
    val borderColor: String?,
    @SerializedName("borderWidth")
    val borderWidth: Int?,
    @SerializedName("clipShape")
    val clipShape: String?,
    @SerializedName("cornerRadius")
    val cornerRadius: String?,
    @SerializedName("layoutParams")
    val layoutParams: String?,
    @SerializedName("size")
    val size: String?,
    @SerializedName("textStyle")
    val textStyle: String?
)