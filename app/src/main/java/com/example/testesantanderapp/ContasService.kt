package com.example.testesantanderapp

import retrofit2.Call
import retrofit2.http.GET

interface ContasService {
    @GET("contas")
    fun list() {
    }
}