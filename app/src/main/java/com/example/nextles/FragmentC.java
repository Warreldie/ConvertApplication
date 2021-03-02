package com.example.nextles;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentC extends Fragment {

    public interface FragmentCListener {
        void onInputCSent(String input);
    }

    private EditText etKelvin;
    private FragmentCListener listener;

    public FragmentC() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_c, container, false);

        etKelvin = v.findViewById(R.id.et_kelvin);
        v.findViewById(R.id.button_to_fahrenheit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View bv) {
                String input = etKelvin.getText().toString();
                //stuur naar fragment b
                int kelvin = Integer.parseInt(input);
                int farhenheit = (kelvin);//*9/5)+32;
                String output = String.valueOf(farhenheit);
                listener.onInputCSent(output);
            }
        });


        return v;
    }

    public void updateKelvin(String input){
        etKelvin.setText(input);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentCListener){
            listener = (FragmentCListener)context;
        }
        else {
            throw new RuntimeException(
                    String.format("%s must implement FragmentCListener", context.toString())
            );
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }

}