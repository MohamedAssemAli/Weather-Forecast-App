package com.assem.forecastapp.data.network

import com.assem.forecastapp.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


// http://api.weatherstack.com/current?access_key=f8b568cac05d3eb8f64cf47d68f2de21&query=New%20York

interface ApixuWeatherApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") country: String
    ): Deferred<CurrentWeatherResponse>

}