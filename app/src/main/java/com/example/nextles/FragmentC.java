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
        //Kelvin to Fahrenheit output
        void onInputCFSent(String input);
        //Kelvin to Celsius output
        void onInputCCSent(String input);
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
        v.findViewById(R.id.button_to_fahrenheit_celsius).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View bv) {
                //Kelvin input catch
                String input = etKelvin.getText().toString();
                int kelvin = Integer.parseInt(input);
                //Kelvin to Fahrenheit
                int fahrenheit = (int) (((kelvin - 273.15) * 9/5) +32);//(K − 273.15) × 9/5 + 32
                String outputF = String.valueOf(fahrenheit);
                listener.onInputCFSent(outputF);
                //Kelvin to Celsius
                int celsius = (int) (kelvin-273.15);
                String outputC = String.valueOf(celsius);
                listener.onInputCCSent(outputC);
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