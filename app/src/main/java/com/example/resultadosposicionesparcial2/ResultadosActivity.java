package com.example.resultadosposicionesparcial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public class ResultadosActivity extends AppCompatActivity implements  Handler.Callback,  View.OnClickListener{
    private Handler dataHandler;
    private RecyclerView recyclerView;
    private ArrayList<Resultado> resultados;

    //Para seleccionar la fecha
    private Calendar mCurrentDate;
    private TextView fecha, menos, mas;
    int day, month, year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        fecha=findViewById(R.id.txtDate);
        menos = findViewById(R.id.txtMenos);
        mas = findViewById(R.id.txtMas);
        mCurrentDate =Calendar.getInstance();
        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);

        month =  month+1;
        setFecha();

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ResultadosActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;
                        fecha.setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                },year, month, day);
                datePickerDialog.show();
            }
        });
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate.add(Calendar.DATE,1);
                day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
                setFecha();
            }
        });
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate.add(Calendar.DATE,-1);
                day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
                setFecha();
            }
        });

        dataHandler = new Handler(Looper.getMainLooper(), this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        resultados =  new ArrayList<>();
        Request r = new Request("https://manuel19299.github.io/SportsApp/data/resultados.json", dataHandler);
        r.start();
    }

    private void setFecha(){
        fecha.setText(day+"/"+month+"/"+year);
    }


    @Override
    public boolean handleMessage(@NonNull Message msg) {
        JSONArray datos = (JSONArray) msg.obj;
        try {
            for(int i = 0; i < datos.length(); i++){
                JSONObject actual = datos.getJSONObject(i);
                resultados.add(new Resultado(actual.getString("equipoLocal"),actual.getString("equipoVisitante"),actual.getString("golesLocal"),actual.getString("golesVisitante"),"0","0"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        ResultadoAdapter adapter = new ResultadoAdapter(resultados,this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        return true;
    }

    @Override
    public void onClick(View v) {

        int pos = recyclerView.getChildLayoutPosition(v);
        Toast.makeText(this, "Funciona"+pos, Toast.LENGTH_SHORT).show();
        Intent intento= new Intent(this,ResultadosInfoActivity.class);
        intento.putExtra("equipo1", resultados.get(pos).getEquipoL());
        intento.putExtra("equipo2", resultados.get(pos).getEquipoV());
        intento.putExtra("goles1", resultados.get(pos).getGolesL());
        intento.putExtra("goles2", resultados.get(pos).getGolesV());
        intento.putExtra("faltas1", resultados.get(pos).getFaltasL());
        intento.putExtra("faltas2", resultados.get(pos).getFaltasV());
        startActivity(intento);
    }
}
