package com.example.wetewterwetr.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wetewterwetr.databinding.FragmentFruitBinding;

public class FruitFragment extends Fragment {

    private FragmentFruitBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFruitBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String genus = getArguments().getString("genus");
        binding.tvGenus.setText(genus);
        String calories = getArguments().getString("calories");
        binding.tvCalories.setText(calories);
        String fat = getArguments().getString("fat");
        binding.tvFat.setText(fat);
        String sugar = getArguments().getString("sugar");
        binding.tvSugar.setText(sugar);
        String carbohydrates = getArguments().getString("carbohydrates");
        binding.tvCarbohydrates.setText(carbohydrates);
        String protein = getArguments().getString("protein");
        binding.tvProtein.setText(protein);
    }

}
