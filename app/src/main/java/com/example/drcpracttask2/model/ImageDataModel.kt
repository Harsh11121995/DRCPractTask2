package com.example.drcpracttask2.model

import com.google.gson.annotations.SerializedName


data class ImageDataModel(

    @SerializedName("data") var data: ArrayList<Data> = arrayListOf(),
    @SerializedName("pagination") var pagination: Pagination? = Pagination(),
    @SerializedName("meta") var meta: Meta? = Meta()

)