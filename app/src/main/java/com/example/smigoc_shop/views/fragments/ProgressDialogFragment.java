package com.example.smigoc_shop.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.smigoc_shop.databinding.FragmentProgressBinding;



public class ProgressDialogFragment extends DialogFragment {

FragmentProgressBinding binding;

    public static  ProgressDialogFragment getInstance(){
        ProgressDialogFragment fragment = new ProgressDialogFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProgressBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

}
