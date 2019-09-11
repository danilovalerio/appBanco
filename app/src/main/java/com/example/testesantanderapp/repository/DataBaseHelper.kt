package com.example.testesantanderapp.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.testesantanderapp.constants.DataBaseConstants

//Assistente de Base de Dados do App que estende de SQLiteOpenHelper
class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val DATABASE_VERSION: Int = 1
        private val DATABASE_NAME: String = "appbanco.db"
    }


    //SQLite (Tipos: INTEGER, REAL, TEXT, BLOB
    private  val createTableUser = """CREATE TABLE ${DataBaseConstants.USER.TABLE_NAME}(
        ${DataBaseConstants.USER.COLUMNS.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${DataBaseConstants.USER.COLUMNS.CPF} TEXT,
        ${DataBaseConstants.USER.COLUMNS.EMAIL} TEXT,
        ${DataBaseConstants.USER.COLUMNS.NAME} TEXT,
        ${DataBaseConstants.USER.COLUMNS.PASSWORD} TEXT
        );"""//ponto e vírgula para finalizar a instrução SQL

    private val deleteTableUser = "DROP TABLE IF EXISTS ${DataBaseConstants.USER.TABLE_NAME}"

    //primeira vez que acessou o banco roda o oncreate
    override fun onCreate(sqlLite: SQLiteDatabase) {
        sqlLite.execSQL(createTableUser)
    }

    override fun onUpgrade(sqlLite: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        sqlLite.execSQL(deleteTableUser) //deleta a tabela existente
        sqlLite.execSQL(createTableUser) //cria a tabela novamente

    }
}