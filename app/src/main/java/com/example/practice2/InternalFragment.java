package com.example.practice2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import com.example.practice2.databinding.Fragment2Binding;
import com.example.practice2.databinding.InternalFragmentBinding;

public class InternalFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        InternalFragmentBinding binding = InternalFragmentBinding.inflate(getLayoutInflater());
        getParentFragmentManager().setFragmentResultListener("dataFromFragment1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                binding.textFromF1.setText(result.getString("Fragment1"));
            }
        });

        binding.buttonToFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("Fragment2", binding.editText2.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFromFragment2", result);
            }
        });
        return binding.getRoot();
    }
}
