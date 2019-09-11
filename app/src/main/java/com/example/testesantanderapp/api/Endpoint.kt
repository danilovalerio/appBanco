package com.example.testesantanderapp.api

import com.example.testesantanderapp.model.DadosModel
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
//    val BASE_URL = "https://bank-app-test.herokuapp.com/api/statements/"

    @GET("1")
    fun listDados(): Call<DadosModel>

//    @GET("statements/1")
//    fun getContas() : Call<List<DadoModel>>

}