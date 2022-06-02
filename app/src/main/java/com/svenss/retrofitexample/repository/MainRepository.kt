package com.svenss.retrofitexample.repository

import com.svenss.retrofitexample.datasource.RemoteDataSource

/**
 * Created by miguelleon on 01,junio,2022
 */
class MainRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getCountries() = remoteDataSource.getCountries()
}