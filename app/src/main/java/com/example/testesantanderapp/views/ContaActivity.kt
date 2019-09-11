package com.example.testesantanderapp.views

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testesantanderapp.R
import com.example.testesantanderapp.api.Endpoint
import com.example.testesantanderapp.util.NetworkUtils

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


