package com.example.testesantanderapp.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testesantanderapp.R
import com.example.testesantanderapp.business.UserBusiness
import com.example.testesantanderapp.util.ValidationException
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mUserBusiness: UserBusiness

    private var context: Context? = null
    private var editPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVars()
        initActions()
    }

    private fun initVars(){
        context = this
        mUserBusiness = UserBusiness(this)
    }

    private fun initActions() {
        btnLogin.setBackgroundResource(R.drawable.btn_arredondado_enabled)

        btnLogin.setOnClickListener() {

            if(verificaLoginTeste("test_user", "Test@1")){
                Toast.makeText(this, "Login efetuado!", Toast.LENGTH_LONG).show()
                val intent: Intent = Intent(context, DetalhesActivity::class.java)
                startActivity(intent)

//                finish()

            } else {
                Toast.makeText(this, "User ou Password incorreto, verifique e tente novamente!", Toast.LENGTH_LONG).show()
            }

           // handleSave()
        }
    }

    private fun verificaLoginTeste(user: String, pass: String) : Boolean{

        try {

            if (user == "test_user" && pass == "Test@1"){
                return true
            }

        }catch (e: java.lang.Exception){

        }

        return false
    }

    private fun handleSave(){
        try {
            val cpf = editUser.text.toString()
            val email = editEmail.text.toString()
            val password = editPassword?.text.toString()
            val name = editName.text.toString()
            //faz inserção do usuário
            mUserBusiness.insert(cpf, name, email, password)

        }catch (e: ValidationException){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        } catch (e: Exception){
            Toast.makeText(this, getString(R.string.erro_inesperado), Toast.LENGTH_SHORT
            ).show()
        }

    }

}



