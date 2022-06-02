package com.svenss.retrofitexample.ui

import androidx.lifecycle.ViewModel
import com.svenss.retrofitexample.api.ResultResponse
import com.svenss.retrofitexample.model.Country
import com.svenss.retrofitexample.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by miguelleon on 01,junio,2022
 */
class MainActivityViewModel(private val repository: MainRepository): ViewModel() {

    private val _onCallCountriesService = MutableSharedFlow<MutableList<Country>>()
    val onCallCountriesService = _onCallCountriesService.asSharedFlow()

    init {
        getCountriesService()
    }

    private fun getCountriesService() = CoroutineScope(Dispatchers.IO).launch {
        val response = repository.getCountries()

        withContext(Dispatchers.Main){
            when(response){
                is ResultResponse.Success -> {
                    response.data?.country_list?.let {
                        _onCallCountriesService.emit(it)
                    }
                }
                is ResultResponse.Error -> { }
            }
        }
    }
}