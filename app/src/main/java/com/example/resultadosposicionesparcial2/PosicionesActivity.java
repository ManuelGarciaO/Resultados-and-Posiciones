package com.example.resultadosposicionesparcial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;

public class PosicionesActivity extends AppCompatActivity implements  Handler.Callback{

    private Handler dataHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posiciones);
        dataHandler = new Handler(Looper.getMainLooper(), this);
        Request r = new Request("https://api.github.com/users", dataHandler);
        r.start();
    }
    public void request(View v){

        Request r = new Request("https://api.github.com/users", dataHandler);
        r.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        JSONArray datos = (JSONArray) msg.obj;
        Toast.makeText(this, datos.toString(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
