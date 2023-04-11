package com.raju.weathertask

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable

class WeatherField(private var cityName: String) : BaseObservable() {
    fun isDataValid(): Int{
        if (TextUtils.isEmpty(getCityName()))
            return 0  // field is empty
         else
            return -1 // success
    }
    fun getCityName(): String {
        return cityName
    }
    fun setCityNmae(cityName: String){
        this.cityName=cityName
    }
}