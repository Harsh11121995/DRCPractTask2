package com.example.drcpracttask2.model

import com.google.gson.annotations.SerializedName


data class Meta(

    @SerializedName("status") var status: Int? = null,
    @SerializedName("msg") var msg: String? = null,
    @SerializedName("response_id") var responseId: String? = null

)