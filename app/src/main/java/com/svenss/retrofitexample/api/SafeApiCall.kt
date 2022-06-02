package com.svenss.retrofitexample.api

import java.lang.Exception

/**
 * Created by miguelleon on 01,junio,2022
 */
suspend fun <T: Any?> safeApiCall(call: suspend () -> ResultResponse<T>, errorMessage: Int): ResultResponse<T>{
    return try {
        call()
    }catch (e: Exception){
        ResultResponse.Error(errorMessage)
    }
}


sealed class ResultResponse<out T: Any?>{

    /**
     * A generic class that holds a value for Success
     */
    data class Success<out T: Any?>(val data: T): ResultResponse<T>()

    /**
     * A generic class that holds a value for error
     */
    data class Error(val exception: Int): ResultResponse<Nothing>()

    /**
     * Convert to string value
     */
    override fun toString(): String{
        return when(this){
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}