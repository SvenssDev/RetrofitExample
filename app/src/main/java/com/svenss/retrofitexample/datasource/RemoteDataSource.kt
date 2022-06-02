package com.svenss.retrofitexample.datasource

import com.svenss.retrofitexample.api.ApiService
import com.svenss.retrofitexample.api.ResultResponse
import com.svenss.retrofitexample.api.safeApiCall

/**
 * Created by miguelleon on 01,junio,2022
 */
class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getCountries() = safeApiCall(
        call = {
            val response = apiService
                .getCountries()
            if (response.isSuccessful){
                /** control response data by codes: 200, 500, etc */
                return@safeApiCall ResultResponse.Success(response.body())
            }
            /** Errors by implementations retrofit */
            return@safeApiCall ResultResponse.Error(response.code())
        },
        errorMessage = 0
    )
}