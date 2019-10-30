package com.example.vtlplus.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Informs Dagger that this class should be constructed only once.

class Repository  {
    fun getUser(): LiveData<User> {

        val data = MutableLiveData<User>()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://mobiletest.free.beeceptor.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Webservice::class.java)
        val call = service.getUser()

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                data.value = response.body()

            }

            // Error case is left out for brevity.
            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO()
            }
        })


        return data
    }
}