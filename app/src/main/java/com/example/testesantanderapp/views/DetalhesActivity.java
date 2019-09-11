package com.example.testesantanderapp.views;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testesantanderapp.DadoService;
import com.example.testesantanderapp.R;
import com.example.testesantanderapp.adapter.AdapterTransacoes;
import com.example.testesantanderapp.model.DadosModel;
import com.example.testesantanderapp.model.Transaction;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalhesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Transaction> listTransactions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        //instanciando o recyclerView
        mRecyclerView = findViewById(R.id.dados_list_recyclerview);

        //Listagem de transações
        this.criarListTransaction();

        //Configurar adapter
        AdapterTransacoes adapterTransacoes = new AdapterTransacoes(listTransactions);

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
        Call<DadosModel> requestDados = service.listDados();

        //ui Thread para retornar de forma assíncrona
        requestDados.enqueue(new Callback<DadosModel>() {
            @Override
            public void onResponse(Call<DadosModel> call, Response<DadosModel> response) {//response é o objeto de retonrno da requisição
                if (!response.isSuccessful()) {
                    Log.i("DANILO", "Erro " + response.code());
                } else {
                    //requisição retornada com sucesso
                    DadosModel dado = response.body();
                    for (Transaction tran : dado.statementList) {
                        Toast.makeText(getApplicationContext(), tran.title, Toast.LENGTH_LONG).show();
                        Log.i("Danilo", String.format("%s: %s", tran.title, tran.desc));
                    }
                }
            }

            @Override
            public void onFailure(Call<DadosModel> call, Throwable t) {
                Log.e("DANILO", "Erro: " + t.getMessage());
            }
        });

    }

    public void criarListTransaction() {
        Transaction tran = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran);
        Transaction tran2 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran2);
        Transaction tran3 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran3);
        Transaction tran4 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran4);
        Transaction tran5 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran5);
        Transaction tran6 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran6);
        Transaction tran7 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran7);
        Transaction tran8 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran8);
        Transaction tran9 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran9);
        Transaction tran10 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran10);
        Transaction tran11 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran11);
        Transaction tran12 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran12);
        Transaction tran13 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran13);
        Transaction tran14 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran14);
        Transaction tran15 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran15);
        Transaction tran16 = new Transaction("Titulo", "Cond", "12/12/2012", 333.0);
        this.listTransactions.add(tran16);
    }
}
