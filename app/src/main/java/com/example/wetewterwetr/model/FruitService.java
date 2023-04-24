package com.example.wetewterwetr.model;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface FruitService {


    @GET("fruit/all")
    Single<List<Fruit>> getAllFruit();
}
