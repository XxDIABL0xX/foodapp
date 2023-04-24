package com.example.wetewterwetr.model.repository;

import com.example.wetewterwetr.model.Fruit;
import com.example.wetewterwetr.model.RetrofitInstance;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FruitRepository {

    public Single<List<Fruit>> getAllFruit(){
        return RetrofitInstance.getFruitService().getAllFruit()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
