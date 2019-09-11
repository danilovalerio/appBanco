package com.example.testesantanderapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.testesantanderapp.DadoModel;
import com.example.testesantanderapp.DadoService;
import com.example.testesantanderapp.R;
import com.example.testesantanderapp.adapter.AdapterTransacoes;
import com.example.testesantanderapp.model.DadosModel;
import com.example.testesantanderapp.model.Transaction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalhesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        //instanciando o recyclerView
        mRecyclerView = findViewById(R.id.dados_list_recyclerview);

        //Configurar adapter
        AdapterTransacoes adapterTransacoes = new AdapterTransacoes();

        //Configurar RecyclerView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapterTransacoes);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DadoService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Retorna uma classe com interface implementada
        DadoService service = retrofit.create(DadoService.class);
        Call<DadosModel>requestDados = service.listDados();

        //ui Thread para retornar de forma assíncrona
        requestDados.enqueue(new Callback<DadosModel>() {
            @Override
            public void onResponse(Call<DadosModel> call, Response<DadosModel> response) {//response é o objeto de retonrno da requisição
                if(!response.isSuccessful()) {
                    Log.i("DANILO","Erro "+ response.code());
                } else {
                    //requisição retornada com sucesso
                    DadosModel dado = response.body();
                    for (Transaction tran : dado.statementList){
                        Toast.makeText(getApplicationContext(),tran.title,Toast.LENGTH_LONG).show();
                        Log.i("Danilo", String.format("%s: %s",tran.title,tran.desc));
                    }
                }
            }

            @Override
            public void onFailure(Call<DadosModel> call, Throwable t) {
                Log.e("DANILO","Erro: " +t.getMessage());
            }
        });

    }
}
