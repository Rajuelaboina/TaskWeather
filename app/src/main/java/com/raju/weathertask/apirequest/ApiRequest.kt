package com.raju.weathertask.apirequest

import com.raju.weathertask.model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    //weather?q=hyderabad&appid=21a68cae4a5283322eb02080681a7bd5
    @GET("weather")
     fun getDataFromApi(@Query("q") cityname : String,@Query("appid") apikey : String,): Call<Weather>

}