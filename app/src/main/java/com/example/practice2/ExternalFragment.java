package com.example.practice2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import com.example.practice2.databinding.ExternalFragmentBinding;
import com.example.practice2.databinding.Fragment2Binding;

public class ExternalFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ExternalFragmentBinding binding = ExternalFragmentBinding.inflate(getLayoutInflater());

        Fragment internalFragment = new InternalFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.internalFragment, internalFragment).commit();

        getChildFragmentManager().setFragmentResultListener("dataFromFragment2", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                binding.textFromF2.setText(result.getString("Fragment2"));
            }
        });

        binding.buttonToFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("Fragment1", binding.editText1.getText().toString());
                getChildFragmentManager().setFragmentResult("dataFromFragment1", result);
            }
        });
        return binding.getRoot();
    }
}
