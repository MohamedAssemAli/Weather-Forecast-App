package com.assem.forecastapp.data.network.response


import com.assem.forecastapp.data.db.entity.CurrentWeatherEntry
import com.assem.forecastapp.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    @SerializedName("location")
    val location: Location
)