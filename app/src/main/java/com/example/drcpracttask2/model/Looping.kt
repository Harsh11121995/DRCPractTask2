package com.example.drcpracttask2.model

import com.google.gson.annotations.SerializedName


data class Looping(

    @SerializedName("mp4_size") var mp4Size: String? = null,
    @SerializedName("mp4") var mp4: String? = null

)