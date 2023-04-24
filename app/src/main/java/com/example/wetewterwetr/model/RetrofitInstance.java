package com.example.wetewterwetr.model;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://www.fruityvice.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public static FruitService getFruitService(){
        return getRetrofit().create(FruitService.class);
    }
}
