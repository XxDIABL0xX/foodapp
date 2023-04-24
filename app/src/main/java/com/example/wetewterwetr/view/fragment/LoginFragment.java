package com.example.wetewterwetr.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.wetewterwetr.databinding.FragmentLoginBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FragmentLoginBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
    }

    private void setListeners(){
        binding.btnLogIn.setOnClickListener(view -> {
            logIn();
        });
        binding.btnRegistration.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToRegistrationFragment());
        });
    }
    private void logIn(){
        String email = binding.etEmail.getText().toString();
        String password = binding.etPassword.getText().toString();
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Navigation.findNavController(binding.getRoot()).navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment());
            }
            else {
                Snackbar.make(binding.getRoot(), "Can't ", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

}
