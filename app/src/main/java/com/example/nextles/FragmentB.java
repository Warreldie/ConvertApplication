package com.example.nextles;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    public interface FragmentBListener {
        void onInputBSent(String input);
    }

    private EditText etFahrenheit;
    private FragmentBListener listener;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        etFahrenheit = v.findViewById(R.id.et_fahrenheit);
        v.findViewById(R.id.button_to_celsius).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View bv) {
                String input = etFahrenheit.getText().toString();
                //stuur naar fragment b
                int farhenheit = Integer.parseInt(input);
                int celsius = (farhenheit-32)* 5 / 9;
                String output = String.valueOf(celsius);
                listener.onInputBSent(output);
            }
        });


        return v;
    }

    public void updateFahrenheit(String input){
        etFahrenheit.setText(input);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentBListener){
            listener = (FragmentBListener)context;
        }
        else {
            throw new RuntimeException(
                    String.format("%s must implement FragmentBListener", context.toString())
            );
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }

}