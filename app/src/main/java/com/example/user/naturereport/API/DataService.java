package com.example.user.naturereport.API;

import com.example.user.naturereport.Data;
import com.example.user.naturereport.ResposData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by CARLOS_ on 13/11/2016.
 */


public interface DataService {

    @Headers({"authorization ",
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmb28iOiJiYXIiLCJpYXQiOjE0NzkwMzM2NzV9.k3X5MrimWz2CF1m4bFHihOq9gDUPl2Dmj546HVE6HE4",
            "Content-Type: application/json",
            "application-type: REST"})
    @POST("send")
    Call<ResposData> createData(@Body Data data);

}
