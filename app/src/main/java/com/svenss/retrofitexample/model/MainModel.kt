package com.svenss.retrofitexample.model

/**
 * Created by miguelleon on 01,junio,2022
 */
data class Main(
    val country_list: MutableList<Country>
)

data class Country(
    val country_image: String,
    val country_name: String
)