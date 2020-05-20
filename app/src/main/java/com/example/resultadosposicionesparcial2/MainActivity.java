package com.example.resultadosposicionesparcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goPosiciones(View v) {
        Intent intento = new Intent(this, PosicionesActivity.class);
        startActivity(intento);
    }

    public void goResultados(View v) {
        Intent intento = new Intent(this, ResultadosActivity.class);
        startActivity(intento);
    }
}
