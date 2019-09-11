package com.example.testesantanderapp.constants

//modela valores constantes utilizados ao long do app para evitar erros

class DataBaseConstants {
    object USER {
        val TABLE_NAME = "user"

        object COLUMNS {
            val ID = "id"
            val CPF = "cpf"
            val NAME = "name"
            val EMAIL = "email"
            val PASSWORD = "password"
        }
    }


}