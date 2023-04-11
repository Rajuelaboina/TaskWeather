package com.raju.weathertask.apirequest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRequest {

    companion object{
        val base_url = "https://api.openweathermap.org/data/2.5/"
        fun getRetroInstance(): Retrofit {
            return  Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}