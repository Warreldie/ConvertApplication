package com.example.nextles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements FragmentA.FragmentAListener, FragmentB.FragmentBListener, FragmentC.FragmentCListener {

    // DONE 1: Zorg ervoor dat je getallen kan ingeven en dat de app effectief de omrekening maakt
    //  van Celsius naar Fahrenheit en omgekeerd (bij een druk op de desbetreffende knop). (eenvoudig)

    // TODO 2: Voeg nog een derde fragment toe voor temperaturen in Kelvin en zorg ervoor
    //  dat alle temperaturen automatisch berekend worden met een druk op de knop. (eenvoudig)

    //TODO 2b: Als je wil, kan je eens nadenken of je code op één of andere manier kan abstraheren
    // in plaats van 3 klassen te hebben die als twee druppels water op elkaar lijken. (gevorderd)

    // TODO 3: Kan je de knoppen laten vallen door de berekening automatisch uit te voeren wanneer
    //  er een aanpassing gemaakt wordt aan het tekstveld? (dus de gebruiker typt in één veld en
    //  de andere velden veranderen automatisch mee). (zeer challenging)

    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_a, fragmentA)
                .replace(R.id.layout_b, fragmentB)
                .replace(R.id.layout_c, fragmentC)
                .commit();
    }

    @Override
    public void onInputAFSent(String input) {

        fragmentB.updateFahrenheit(input);
    }

    @Override
    public void onInputAKSent(String input){
        fragmentC.updateKelvin(input);
    }

    @Override
    public void onInputBCSent(String input) {

        fragmentA.updateCelsius(input);
    }
    @Override
    public void onInputBKSent(String input){
        fragmentC.updateKelvin(input);
    }

    @Override
    public void onInputCFSent(String input) {
        fragmentB.updateFahrenheit(input);
    }
    @Override
    public void onInputCCSent(String input) {
        fragmentA.updateCelsius(input);
    }
}