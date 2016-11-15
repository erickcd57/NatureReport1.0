package com.example.user.naturereport.API;

import com.example.user.naturereport.Constante;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CARLOS_ on 13/11/2016.
 */

public class DataCliente {
    private Retrofit mRetrofit;

    public DataCliente() {
        this.mRetrofit=new Retrofit.Builder().baseUrl(Constante.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
}
