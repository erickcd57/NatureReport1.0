package com.example.user.naturereport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.naturereport.API.DataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Formulario extends AppCompatActivity {
    Button Ubicacionbtn;
    Button Cargarbtn;


    Button btnGuardar;
    EditText etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Ubicacionbtn = (Button) findViewById(R.id.Ubicacionbtn);
        Cargarbtn = (Button) findViewById(R.id.Cargarbtn);
        Ubicacionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(Formulario.this, GoogleMaps.class);
                startActivity(siguiente);
            }
        });
        Cargarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent carpeta = new Intent(Intent.ACTION_GET_CONTENT);
                carpeta.setType("FotosEvidencia");
                startActivity(carpeta);


        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Data dataRetrofit =new Data(etDescripcion.toString());


                Retrofit mretrofitData = new Retrofit.Builder().baseUrl(Constante.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                DataService mDataService= mretrofitData.create(DataService.class);

                final Call <ResposData> ResponseData= mDataService.createData(dataRetrofit);
                ResponseData.enqueue(new Callback<ResposData>() {
                    @Override
                    public void onResponse(Call<ResposData> call, Response<ResposData> response) {
                        ResposData mresponseData=response.body();

                        Toast.makeText(Formulario.this, "Cuenta Creada!", Toast.LENGTH_SHORT).show();

                    }
                    @Override
                    public void onFailure(Call<ResposData> call, Throwable t) {

                    }
                });
            }
        });
    }

}
    }