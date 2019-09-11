package com.example.testesantanderapp.views

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.testesantanderapp.*
import com.example.testesantanderapp.api.Endpoint
import com.example.testesantanderapp.util.NetworkUtils
import com.example.testesantanderapp.DadoModel
import com.example.testesantanderapp.model.DadosModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContaActivity : AppCompatActivity() {

    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta)

        initVars()

        getData()
    }

    private fun initVars() {
        context = this
    }

    fun getData() {
        val path: String = "https://bank-app-test.herokuapp.com/api/"

        val retrofitClient = NetworkUtils
            .getRetrofitInstance(path)

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.listDados()

//        callback.enqueue(object : Callback<List<DadosModel>> {
//            override fun onFailure(call: Call<List<DadoModel>>, t: Throwable) {
//                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(
//                call: Call<List<DadoModel>>,
//                response: Response<List<DadoModel>>
//            ) {
//                response.body()?.forEach {
//                    Log.d("Testelista", it.toString())
//                    Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
//
//                }
//
//
//            }
//
//        })
    }
}


