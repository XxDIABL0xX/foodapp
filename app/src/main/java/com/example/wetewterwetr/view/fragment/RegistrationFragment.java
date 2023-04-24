package com.example.wetewterwetr.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.wetewterwetr.databinding.FragmentRegistrationBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationFragment extends Fragment {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FragmentRegistrationBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
    }

    private void setListeners(){
        binding.btnRegistration.setOnClickListener(view -> {
        registration();

        });


    }
    private void registration() {
        String email = binding.etEmail.getText().toString();
        String password = binding.etPassword.getText().toString();
        String repeatPassword = binding.etRepeatPassword.getText().toString();

        if (password.equals(repeatPassword)) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Navigation.findNavController(binding.getRoot()).popBackStack();
                } else {
                    Snackbar.make(binding.getRoot(), "Can't", Snackbar.LENGTH_SHORT).show();
                }
            });
        } else {
            Snackbar.make(binding.getRoot(), "Password Don't Match", Snackbar.LENGTH_SHORT).show();
        }
    }
}
