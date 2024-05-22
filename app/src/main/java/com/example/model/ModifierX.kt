package com.example.model


import com.google.gson.annotations.SerializedName

data class ModifierX(
    @SerializedName("backgroundColor")
    val backgroundColor: String?,
    @SerializedName("borderColor")
    val borderColor: Any?,
    @SerializedName("borderWidth")
    val borderWidth: Int?,
    @SerializedName("clipShape")
    val clipShape: Any?,
    @SerializedName("cornerRadius")
    val cornerRadius: Any?,
    @SerializedName("horizontalAlignment")
    val horizontalAlignment: String?,
    @SerializedName("layoutParams")
    val layoutParams: Any?,
    @SerializedName("size")
    val size: Any?,
    @SerializedName("textAlignment")
    val textAlignment: Any?,
    @SerializedName("textStyle")
    val textStyle: Any?,
    @SerializedName("verticalAlignment")
    val verticalAlignment: String?
)