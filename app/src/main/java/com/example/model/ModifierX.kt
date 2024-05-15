package com.example.model


import com.google.gson.annotations.SerializedName

data class ModifierX(
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
    val cornerRadius: CornerRadius?,
    @SerializedName("layoutParams")
    val layoutParams: LayoutParams?,
    @SerializedName("size")
    val size: Size?,
    @SerializedName("textStyle")
    val textStyle: TextStyle?
)