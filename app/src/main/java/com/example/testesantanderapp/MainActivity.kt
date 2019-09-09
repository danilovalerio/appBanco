package com.example.testesantanderapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import android.widget.EditText
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    private var context: Context? = null
    private var editPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVars()
        checkLogin()
        initActions()
    }

    private fun initVars(){
        context = this
    }

    private fun initActions(){
        //evento do clique para tratar
        btnLogin.setOnClickListener(){
            Toast.makeText(this, "Login efetuado!", Toast.LENGTH_LONG).show()

            //referencia a MainActivity
            val intent : Intent = Intent(context, ContaActivity::class.java)
            startActivity(intent)
//            finish() //remove da pilha para nao voltar
        }


//        val editpassword = editPassword as EditText

        editPassword?.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
                Toast.makeText(context, v.editPassword.text,Toast.LENGTH_LONG).show()

    //                if (editPassword.text.length>0){
    //                    Log.d("Senha", "dsf".toString())
    //                    enableLogin()
    //                    return true
    //                }
                return true
            }
        })
    }

    private fun checkUser(user:String){
        Toast.makeText(context, user, Toast.LENGTH_SHORT).show()
    }

    private fun checkLogin(){
        if(editUser.text.length < 1) {
            btnLogin.isEnabled = false
        }
    }

    private fun enableLogin() {
        btnLogin.isEnabled = true
        btnLogin.setBackgroundResource(R.drawable.btn_arredondado_enabled)
    }

}



