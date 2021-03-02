package com.example.nextles;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentA extends Fragment {

    public interface FragmentAListener{
        void onInputAFSent(String input);
        void onInputAKSent(String input);
    }

    private EditText etCelsius;
    private FragmentAListener listener;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        etCelsius = v.findViewById(R.id.et_celsius);
        v.findViewById(R.id.button_to_fahrenheit_kelvin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View bv) {
                //Incoming Celsius
                String input = etCelsius.getText().toString();
                int celsius = Integer.parseInt(input);
                //Celsius to Fahrenheit
                int fahrenheit = (celsius*9/5)+32;
                String outputF = String.valueOf(fahrenheit);
                listener.onInputAFSent(outputF);
                //Celsius to Kelvin
                int kelvin = (int) (celsius+273.15);
                String outputK = String.valueOf(kelvin);
                listener.onInputAKSent(outputK);
            }
        });


        return v;
    }

    public void updateCelsius(String input){
        etCelsius.setText(input);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentAListener){
            listener = (FragmentAListener)context;
        }
        else {
            throw new RuntimeException(
                    String.format("%s must implement FragmentAListener", context.toString())
            );
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }

}