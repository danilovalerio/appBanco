package com.example.testesantanderapp.business

import android.content.Context
import com.example.testesantanderapp.R
import com.example.testesantanderapp.constants.Constants
import com.example.testesantanderapp.entities.UserEntity
import com.example.testesantanderapp.repository.UserRepository
import com.example.testesantanderapp.util.SecurityPreferences
import com.example.testesantanderapp.util.ValidationException
import java.lang.Exception

//Reponsável pela regra de negócio que faz referência ao usuário, login e registro por exemplo.
class UserBusiness (val context: Context){

    private val mUserRepository : UserRepository = UserRepository.getInstance(context)
    private val mSecurityPreferences: SecurityPreferences = SecurityPreferences(context)

    fun login (email: String, password: String){

        val user: UserEntity? = mUserRepository.get(email, password)

        if(user!=null){
            TODO("Colocar validação, caso não seja nulo")
        }

    }

    fun insert(cpf: String, name: String, email: String, password: String){
        try {
            //verifica se tem campo vazio
            if(cpf == "" || name == "" || email == "" || password == ""){
                throw ValidationException(context.getString(R.string.informe_todos_os_campos))
            }

            //verifica se o email já esta cadastrado
            if(mUserRepository.isEmailRegistered(email)){
                throw ValidationException(context.getString(R.string.email_ja_cadastrado))
            }
            
            //verifica cpf existente
            if(mUserRepository.isCpfRegistered(cpf)){
                throw ValidationException(context.getString(R.string.cpf_cadastrado))
            }

            val userId = mUserRepository.insert(cpf, name, email, password)

            //Salvar dados no shared
            mSecurityPreferences.storeString(Constants.KEY_SHARED.USER_ID, userId.toString())
            mSecurityPreferences.storeString(Constants.KEY_SHARED.USER_NAME, name)
            mSecurityPreferences.storeString(Constants.KEY_SHARED.USER_EMAIL, email)

        } catch (e: Exception){
            throw e
        }


    }
}