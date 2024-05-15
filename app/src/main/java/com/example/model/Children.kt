package com.example.model


import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("children")
    val children: List<Any?>?,
    @SerializedName("modifier")
    val modifier: Modifier?,
    @SerializedName("value")
    val value: String?,
    @SerializedName("viewType")
    val viewType: String?
)