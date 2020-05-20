package com.example.resultadosposicionesparcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadosInfoActivity extends AppCompatActivity {

    private TextView equipo1,equipo2,goles1,goles2,faltas1,faltas2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_info);
        equipo1 = findViewById(R.id.txtEquipo1);
        equipo2 = findViewById(R.id.txtEquipo2);
        goles1 = findViewById(R.id.txtGoles1);
        goles2 = findViewById(R.id.txtGoles2);
        faltas1 = findViewById(R.id.txtFaltas1);
        faltas2 = findViewById(R.id.txtFaltas2);
        equipo1.setText(getIntent().getStringExtra("equipo1"));
        equipo2.setText(getIntent().getStringExtra("equipo2"));
        goles1.setText(getIntent().getStringExtra("goles1"));
        goles2.setText(getIntent().getStringExtra("goles2"));
        faltas1.setText(getIntent().getStringExtra("faltas1"));
        faltas2.setText(getIntent().getStringExtra("faltas2"));
    }
}
