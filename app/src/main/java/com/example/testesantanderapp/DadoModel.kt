package com.example.testesantanderapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//POJO DadoModel
data class DadoModel (

    @Expose
    @SerializedName("statementList")
    val statementList: List<Conta>,
    @Expose
    @SerializedName("error")
    val error: Error
)

class Conta (var title:String, var desc: String, var date: String, var value: String)

class Error (var erro: String)