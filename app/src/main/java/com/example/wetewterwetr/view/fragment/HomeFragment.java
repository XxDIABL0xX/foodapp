package com.example.wetewterwetr.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.wetewterwetr.databinding.ActivityMainBinding;
import com.example.wetewterwetr.databinding.FragmentHomeBinding;
import com.example.wetewterwetr.model.Fruit;
import com.example.wetewterwetr.view.FruitAdapter;
import com.example.wetewterwetr.viewmodel.MainViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private MainViewModel viewModel = new MainViewModel();
    private FruitAdapter fruitAdapter = new FruitAdapter();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        setObservers();
        setListeners();
    }

    private void setListeners(){
        fruitAdapter.setOnItemClickListener(new FruitAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Fruit fruit) {
                Log.d("TAG", String.valueOf(fruit.nutritions.calories));
                Navigation.findNavController(binding.getRoot()).navigate(HomeFragmentDirections.actionHomeFragmentToFruitFragment(
                        fruit.genus,
                        String.valueOf(fruit.nutritions.calories),
                        String.valueOf(fruit.nutritions.fat),
                        String.valueOf(fruit.nutritions.sugar),
                        String.valueOf(fruit.nutritions.carbohydrates),
                        String.valueOf(fruit.nutritions.protein)
                ));
            }
        });

    }
    private void init(){
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.rvFruits.setAdapter(fruitAdapter);
        viewModel.getFruit();
    }

    private void setObservers(){
        viewModel.fruitLiveData.observe(getViewLifecycleOwner(), fruits -> {
            fruitAdapter.updateList(fruits);
        });
    }
}
