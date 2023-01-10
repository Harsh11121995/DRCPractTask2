package com.example.drcpracttask2.api

import com.example.drcpracttask2.model.ImageDataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    // user
    @GET("search")
    fun getData(@Query("q") key: String,
                @Query("api_key") location: String,
    ): Observable<ImageDataModel>


}