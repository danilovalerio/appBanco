package com.example.testesantanderapp.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.testesantanderapp.constants.DataBaseConstants
import com.example.testesantanderapp.entities.UserEntity
import java.lang.Exception

//responsável por inserir usuário no banco de dados

//construtor privado para uma única instânciação,
//      possível para evitar mais de uma instância ao mesmo tempo
//      que poderá gerar dado instável em nosso banco.
class UserRepository private constructor(context: Context){
    private var mDataBaseHelper : DataBaseHelper = DataBaseHelper(context) //conexão para acessar banco

    //getInstance limita o acesso e está em comp obj por ser private
    companion object{
        fun getInstance(context: Context) : UserRepository{ //método estático
            //se a instância for nula eu estancio caso contrário retorna a atual
            if(INSTANCE == null){
                INSTANCE = UserRepository(context)
            }
            return INSTANCE as UserRepository

        }

        //armazena a instancia dessa classe
        private var INSTANCE: UserRepository? = null
    }

    //realizar o login do usuário
    fun get (user: String, password: String) : UserEntity?{
        var userEntity: UserEntity? = null

        try {
            val cursor: Cursor
            val db = mDataBaseHelper.readableDatabase

            //projeção dos dados que serão retornados
            val projection = arrayOf(DataBaseConstants.USER.COLUMNS.ID,
                DataBaseConstants.USER.COLUMNS.CPF,
                DataBaseConstants.USER.COLUMNS.NAME,
                DataBaseConstants.USER.COLUMNS.EMAIL,
                DataBaseConstants.USER.COLUMNS.PASSWORD)

            TODO("Verificar se o user é cpf ou email para tomar a decisão de busca")

            //filtro do que será retornado
            val selection = "${DataBaseConstants.USER.COLUMNS.EMAIL} = ?" +
                    "AND ${DataBaseConstants.USER.COLUMNS.PASSWORD}"
            val selectionArgs = arrayOf(user,password)

            //Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
            cursor = db.query(DataBaseConstants.USER.TABLE_NAME, projection, selection, selectionArgs, null, null, null)
            if(cursor.count > 0){
                //move o cursor para a primeira posição
                cursor.moveToFirst()

                val userId = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.USER.COLUMNS.ID))
                val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.USER.COLUMNS.NAME))
                val email = cursor.getString(cursor.getColumnIndex(DataBaseConstants.USER.COLUMNS.EMAIL))
                val cpf = cursor.getString(cursor.getColumnIndex(DataBaseConstants.USER.COLUMNS.CPF))

                //Prenchimento da entidade de usuário
                userEntity = UserEntity(userId,cpf, name, email)
            }

            cursor.close()
        } catch (e: Exception){
            return userEntity
        }

        return userEntity
    }

    fun isEmailRegistered(email: String): Boolean{
        var ret: Boolean
        try {
            val cursor: Cursor
            val db = mDataBaseHelper.readableDatabase

            //projeção dos dados que serão retornados
            val projection = arrayOf(DataBaseConstants.USER.COLUMNS.ID)

            //filtro do que será retornado
            val selection = "${DataBaseConstants.USER.COLUMNS.EMAIL} = ?"
            val selectionArgs = arrayOf(email)

            //Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
            cursor = db.query(DataBaseConstants.USER.TABLE_NAME, projection, selection, selectionArgs, null, null, null)
            ret = cursor.count > 0
            cursor.close()
        } catch (e: Exception){
            throw e
        }

        return ret

    }

    fun isCpfRegistered(cpf: String): Boolean{
        var ret: Boolean
        try {
            val cursor: Cursor
            val db = mDataBaseHelper.readableDatabase

            //projeção dos dados que serão retornados
            val projection = arrayOf(DataBaseConstants.USER.COLUMNS.ID)

            //filtro do que será retornado
            val selection = "${DataBaseConstants.USER.COLUMNS.CPF} = ?"
            val selectionArgs = arrayOf(cpf)

            //Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
            cursor = db.query(DataBaseConstants.USER.TABLE_NAME, projection, selection, selectionArgs, null, null, null)
            ret = cursor.count > 0
            cursor.close()
        } catch (e: Exception){
            throw e
        }

        return ret

    }

    fun insert(cpf: String, name: String, email: String, password: String) : Int{
        //readableDatabase(select), writableDatabase -> (update, insert, delete)
        val db = mDataBaseHelper.writableDatabase

        val insertValues = ContentValues()
        insertValues.put(DataBaseConstants.USER.COLUMNS.CPF, cpf)
        insertValues.put(DataBaseConstants.USER.COLUMNS.NAME, name)
        insertValues.put(DataBaseConstants.USER.COLUMNS.EMAIL, email)
        insertValues.put(DataBaseConstants.USER.COLUMNS.PASSWORD, password)

        return db.insert(DataBaseConstants.USER.TABLE_NAME, null, insertValues).toInt()
    }

}