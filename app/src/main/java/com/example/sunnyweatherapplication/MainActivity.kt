package com.example.sunnyweatherapplication

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    companion object{
        const val TOKEN = "1TPsPRRMB3UR5Efg"
        const val PLACE = "116.405285, 39.904989"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 使用协程启动网络请求
        CoroutineScope(Dispatchers.Main).launch {
            try {
                // 发起网络请求并等待结果
                val weatherResponse = SunnyWeatherNetwork.searchWeather()
                // 在主线程中处理结果
                withContext(Dispatchers.Main) {
                    Log.d("MainActivity","Status: ${weatherResponse.status}")
                    Log.d("MainActivity","天气现象：${weatherResponse.result.realtime?.skycon}")
                    val status:String = weatherResponse.status
                    val skycon:String?= weatherResponse.result.realtime?.skycon
                    findViewById<TextView>(R.id.statusText).setText(status)
                    findViewById<TextView>(R.id.skyconText).setText(skycon)
                }
            } catch (e: Exception) {
                // 处理异常
                Log.e("MainActivity", "Error fetching places", e)
            }
        }
    }
}
