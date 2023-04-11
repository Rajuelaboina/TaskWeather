package com.raju.weathertask

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raju.weathertask.apirequest.ApiRequest
import com.raju.weathertask.apirequest.RetrofitRequest
import com.raju.weathertask.model.Weather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatheViewModel(private var listsener: WeatherResultCallBack) : ViewModel() {
     val weatherField: WeatherField
    // var weatherList = MutableLiveData<UserWeather?>()
    var weatherList = MutableLiveData<Weather?>()
     init {
         weatherField = WeatherField("")
     }
    val fieldTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().length > 0){
                   /* weatherField.setCityNmae(s.toString().trim())
                    listsener.onSuccess(weatherField.getCityName()+",US")*/
                }else{
                    listsener.onError("field not be null")
                }

            }
            override fun afterTextChanged(s: Editable?) {
                weatherField.setCityNmae(s.toString().trim())

            }
        }
    fun onLoginClicked(view: View){
        var loginCode:Int =weatherField.isDataValid()
        if (loginCode == 0){
            listsener.onError("field not be null")
        }
        else
            listsener.onSuccess(weatherField.getCityName()+",US")
    }
    fun getWeatherReport( cityName: String,apiKey: String){

        CoroutineScope(IO).launch {
            val retrofitInstsnce= RetrofitRequest.getRetroInstance().create(ApiRequest::class.java)
            var call= retrofitInstsnce.getDataFromApi(cityName,apiKey)
            call.enqueue(object : Callback<Weather> {
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    Log.e("ViewModel","viewmodel: ${response.body()}")
                    if (response.isSuccessful && response.body()!=null) {


                        weatherList.postValue(response.body())
                    }


                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                    Log.e("viewmodel","Error: ${t.message}")
                    listsener.onError("Not found City")
                    weatherList.postValue(null)
                }

            })
        }

    }

    fun getUserWeather(): MutableLiveData<Weather?> {
        return weatherList
    }

}