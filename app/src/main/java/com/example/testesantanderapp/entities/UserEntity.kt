package com.example.testesantanderapp.entities

//Entidade User, classe usada para transitar dados entre camadas, daí vem a necessidade do data
data class UserEntity (val id: Int, var cpf:String, var name:String, var email: String, var password:String = "")
