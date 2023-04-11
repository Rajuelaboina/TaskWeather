package com.raju.weathertask

interface WeatherResultCallBack {
    fun onSuccess(message: String)
    fun onError(message: String)
}