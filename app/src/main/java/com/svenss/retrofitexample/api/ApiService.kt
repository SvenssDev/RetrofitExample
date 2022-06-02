package com.svenss.retrofitexample.api

import com.svenss.retrofitexample.model.Main
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by miguelleon on 01,junio,2022
 */
interface ApiService {
    @GET("/v1/countries/1")
    suspend fun getCountries(): Response<Main>
}