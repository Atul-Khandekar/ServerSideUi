package com.example.model


import com.google.gson.annotations.SerializedName

data class Modifier(
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
    @SerializedName("horizontalAlignment")
    val horizontalAlignment: String?,
    @SerializedName("layoutParams")
    val layoutParams: LayoutParams?,
    @SerializedName("size")
    val size: Size?,
    @SerializedName("textAlignment")
    val textAlignment: String?,
    @SerializedName("textStyle")
    val textStyle: TextStyle?,
    @SerializedName("verticalAlignment")
    val verticalAlignment: String?
)