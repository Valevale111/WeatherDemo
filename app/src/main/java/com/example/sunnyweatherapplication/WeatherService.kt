package com.example.sunnyweatherapplication

import retrofit2.Call
import retrofit2.http.GET

interface WeatherService {
    @GET("v2.6/1TPsPRRMB3UR5Efg/101.6656,39.2072/realtime")
//    @GET("v2.6/${MainActivity.TOKEN}/${MainActivity.PLACE}/realtime")
//    @GET("v2/place?token=${MainActivity.TOKEN}&lang=zh_CN")
    fun searchWeather(): Call<WeatherResponse>
}