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
        void onInputASent(String input);
    }

    private EditText etCelcius;
    private FragmentAListener listener;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        etCelcius = v.findViewById(R.id.et_celcius);
        v.findViewById(R.id.button_to_fahrenheit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View bv) {
                String input = etCelcius.getText().toString();
                //stuur naar fragment b
                listener.onInputASent(input);
            }
        });


        return v;
    }

    public void updateCelsius(String input){
        etCelcius.setText(input);
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