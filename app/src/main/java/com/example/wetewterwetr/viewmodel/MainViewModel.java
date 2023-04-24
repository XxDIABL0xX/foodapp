package com.example.wetewterwetr.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wetewterwetr.model.Fruit;
import com.example.wetewterwetr.model.repository.FruitRepository;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainViewModel extends ViewModel {

    private CompositeDisposable disposables = new CompositeDisposable();
    public FruitRepository fruitRepository = new FruitRepository();
    public MutableLiveData<List<Fruit>> fruitLiveData = new MutableLiveData<>();


    public void getFruit(){
        disposables.add(
                fruitRepository.getAllFruit().subscribe(fruits -> {
                    fruitLiveData.setValue(fruits);
                })
        );
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
