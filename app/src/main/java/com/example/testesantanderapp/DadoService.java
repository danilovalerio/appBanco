package com.example.testesantanderapp;

import com.example.testesantanderapp.model.DadosModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DadoService {
    public static final String BASE_URL = "https://bank-app-test.herokuapp.com/api/statements/";

    @GET("1")
    Call<DadosModel> listDados();
}
