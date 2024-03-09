package com.example.practice2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import com.example.practice2.databinding.MainFragmentLayoutBinding;
import com.example.practice2.databinding.SecondFragmentLayoutBinding;

public class SecondFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SecondFragmentLayoutBinding binding = SecondFragmentLayoutBinding.inflate(getLayoutInflater());

        getParentFragmentManager().setFragmentResultListener("dataFromMainFragment", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("mainFragment");
                if (!data.equals(""))
                    binding.name.setText("Адресат: " + data);
                else binding.name.setText("Адресат: отсутствует");
            }
        });

        binding.buttonComeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MainFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();

                Bundle result = new Bundle();
                result.putString("secondFragment", binding.textOfCard.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFromSecondFragment", result);


                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.main_container, fragment);
                transaction.commit();
            }
        });
        return binding.getRoot();
    }
}
