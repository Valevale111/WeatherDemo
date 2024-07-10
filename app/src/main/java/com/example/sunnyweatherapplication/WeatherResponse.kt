package com.example.sunnyweatherapplication

import android.opengl.Visibility
import com.google.gson.annotations.SerializedName

//data class WeatherResponse(val status:String, val places:List<Place>)
//
//data class Place(val name:String,val location:Location,
//    @SerializedName("formatted_address") val address:String)
//
//data class Location (val lng:String,val lat:String)

data class WeatherResponse(
    val status:String,
    val api_version:String,
    val api_status:String,
    val lang:String,
    val unit:String,
    val tzshift:Int,
    val timezone:String,
    val server_time:Int,
    val location:List<Float>,
    val result:Result
)

data class Result(
    val realtime:Realtime?,
    val primary:Int
)

data class Realtime(
    val status:String,
    val temperature:Float,
    val humidity:Float,
    val cloudrate:Float,
    val skycon:String,
    val visibility: Float,
    val dswrf:Float,
    val wind:Wind?,
    val pressure:Float,
    val apparent_temperature:Float,
    val precipitation:Precipitation?,
    val air_quality:Air_quality?,
    val life_index:Life_index?
)
data class Wind(val speed:Float,val direction:Float)
data class Precipitation(val local:Local,val nearest:Nearest)
data class Local(val status:String,val datasource:String,val intensity:Float)
data class Nearest(val status:String,val distance:Float,val intensity:Float)
data class Air_quality(val pm25:Float,val pm10:Float,val o3:Float,val so2:Float,val no2:Float,
    val co:Float,val aqi:Aqi?,val discription:Discription?)
data class Aqi(val chn:Int,val usa:Int)
data class Discription(val usa:String,val chn:String)
data class Life_index(val ultraviolet:Ultraviolet?,val confort:Comfort?)
data class Ultraviolet(val index:Int,val desc:String)
data class Comfort(val index:String,val desc:String)
