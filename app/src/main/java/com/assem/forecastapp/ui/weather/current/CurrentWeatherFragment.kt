package com.assem.forecastapp.ui.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.assem.forecastapp.R
import com.assem.forecastapp.data.network.ApixuWeatherApiService
import com.assem.forecastapp.data.network.ServiceBuilder
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() =
            CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel

        val destinationServices = ServiceBuilder.buildService(
            ApixuWeatherApiService::class.java
        )


        GlobalScope.launch(Dispatchers.Main) {
            val requestCall = destinationServices.getCurrentWeather("New York").await()
            text_view_res.text = requestCall.location.country
            text_view_res.text = requestCall.location.country
        }
    }

}
