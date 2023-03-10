package com.example.drcpracttask2.model

import com.google.gson.annotations.SerializedName


data class PreviewWebp(

    @SerializedName("height") var height: String? = null,
    @SerializedName("width") var width: String? = null,
    @SerializedName("size") var size: String? = null,
    @SerializedName("url") var url: String? = null

)