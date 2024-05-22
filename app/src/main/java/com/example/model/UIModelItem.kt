package com.example.model


import com.google.gson.annotations.SerializedName

data class UIModelItem(
    @SerializedName("children")
    val children: List<UIModelItem>?,
    @SerializedName("modifier")
    val modifier: Modifier?,
    @SerializedName("value")
    val value: String?,
    @SerializedName("viewType")
    val viewType: String?
)