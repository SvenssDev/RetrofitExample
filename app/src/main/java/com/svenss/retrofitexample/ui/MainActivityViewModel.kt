package com.svenss.retrofitexample.ui

import androidx.lifecycle.ViewModel
import com.svenss.retrofitexample.api.ResultResponse
import com.svenss.retrofitexample.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by miguelleon on 01,junio,2022
 */
class MainActivityViewModel(private val repository: MainRepository): ViewModel() {

    fun getCountriesService() = CoroutineScope(Dispatchers.IO).launch {
        val response = repository.getCountries()

        withContext(Dispatchers.Main){
            when(response){
                is ResultResponse.Success -> { }
                is ResultResponse.Error -> { }
            }
        }
    }
}