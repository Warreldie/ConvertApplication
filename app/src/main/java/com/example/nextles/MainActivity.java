package com.example.nextles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements FragmentA.FragmentAListener, FragmentB.FragmentBListener {

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_a, fragmentA)
                .replace(R.id.layout_b, fragmentB)
                .commit();
    }

    @Override
    public void onInputASent(String input) {
        fragmentB.updateFahrenheit(input);
    }

    @Override
    public void onInputBSent(String input) {
        fragmentA.updateCelsius(input);
    }
}