package com.example.practice2;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import com.example.practice2.databinding.MainFragmentLayoutBinding;

public class MainFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Toast.makeText(getActivity(), "onAttach", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(getActivity(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Toast.makeText(getActivity(), "onCreateView", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onCreateView");
        MainFragmentLayoutBinding binding = MainFragmentLayoutBinding.inflate(getLayoutInflater());

        getParentFragmentManager().setFragmentResultListener("dataFromSecondFragment", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("secondFragment");
                if (!data.equals(""))
                    binding.lastRecipient.setText("Вы отправляли валентинку с текстом:\n" + data);
                else binding.lastRecipient.setText("Вы отправили пустую валентинку");
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("mainFragment", binding.editText.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFromMainFragment", result);

                Fragment fragment = new SecondFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.main_container, fragment);
                transaction.commit();
            }
        });
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Toast.makeText(getActivity(), "onViewCreated", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onViewCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //Toast.makeText(getActivity(), "onViewStateRestored", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        //Toast.makeText(getActivity(), "onStart", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        //Toast.makeText(getActivity(), "onResume", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onResume");
    }
    @Override
    public void onPause() {
        super.onPause();
        //Toast.makeText(getActivity(), "onPause", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        //Toast.makeText(getActivity(), "onStop", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onStop");
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //Toast.makeText(getActivity(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onSaveInstanceState");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Toast.makeText(getActivity(), "onDestroyView", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Toast.makeText(getActivity(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //Toast.makeText(getActivity(), "onDetach", Toast.LENGTH_SHORT).show();
        Log.i("KimMyApp", "onDetach");
    }
}
