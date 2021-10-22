package com.example.ubfuneralhouse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String Base_URL="http://ubfuneral.000webhostapp.com/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient(){
        if(retrofit == null){
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder().baseUrl(Base_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }

        return  retrofit;
    }
}
