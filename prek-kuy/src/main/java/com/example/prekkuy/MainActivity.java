package com.example.prekkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView hargaBayar, reset;
    private int hMatah, hBalado, hKeju, hSpesial, hPedas, hBensu;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hargaBayar = findViewById(R.id.hargaBayar);
        reset = findViewById(R.id.reset);
    }

    public void bayar(View view) {
    }

    public void reset(View view) {
        total = 0;
        hargaBayar.setText(Integer.toString(total));
    }


    public void matah(View view) {
        hMatah = 12000;
        total += hMatah;
        hargaBayar.setText(Integer.toString(total));
    }

    public void balado(View view) {
        hBalado = 14000;
        total += hBalado;
        hargaBayar.setText(Integer.toString(total));
    }

    public void keju(View view) {
        hKeju = 15000;
        total += hKeju;
        hargaBayar.setText(Integer.toString(total));
    }

    public void spesial(View view) {
        hSpesial = 20000;
        total += hSpesial;
        hargaBayar.setText(Integer.toString(total));
    }

    public void pedas(View view) {
        hPedas = 13000;
        total += hPedas;
        hargaBayar.setText(Integer.toString(total));
    }

    public void bensu(View view) {
        hBensu = 13000;
        total += hBensu;
        hargaBayar.setText(Integer.toString(total));
    }
}