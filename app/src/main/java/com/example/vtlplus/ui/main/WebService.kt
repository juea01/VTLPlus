package com.example.vtlplus.ui.main

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice {
    /**
     * @GET declares an HTTP GET request
     */
    @GET("/my/api/path")
    fun getUser(): Call<User>
}