package com.example.simpecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText n1,n2;
    private TextView hasil;
    private float nil1, nil2, hsl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1 = findViewById(R.id.edt_n1);
        n2 = findViewById(R.id.edt_n2);
        hasil = findViewById(R.id.result);
    }

    @SuppressLint("SetTextI18n")
    public void onAdd(View view) {
        try {
            nil1 = Float.parseFloat(n1.getText().toString());
            nil2 = Float.parseFloat(n2.getText().toString());
            hsl = nil1 + nil2;
            hasil.setText(Float.toString(hsl));
        } catch (NumberFormatException e){
            Log.d("error", "error format ... " + e);
        }
    }

    @SuppressLint("SetTextI18n")
    public void onMul(View view) {
        try {
            nil1 = Float.parseFloat(n1.getText().toString());
            nil2 = Float.parseFloat(n2.getText().toString());
            hsl = nil1 * nil2;
            hasil.setText(Float.toString(hsl));
        } catch (NumberFormatException e){
            Log.d("error", "error format ... " + e);
        }
    }

    @SuppressLint("SetTextI18n")
    public void onDiv(View view) {
        try {
            nil1 = Float.parseFloat(n1.getText().toString());
            nil2 = Float.parseFloat(n2.getText().toString());
            hsl = nil1 / nil2;
            hasil.setText(Float.toString(hsl));
        } catch (NumberFormatException e){
            Log.d("error", "error format ... " + e);
        }
    }

    @SuppressLint("SetTextI18n")
    public void onSub(View view) {
        try {
            nil1 = Float.parseFloat(n1.getText().toString());
            nil2 = Float.parseFloat(n2.getText().toString());
            hsl = nil1 - nil2;
            hasil.setText(Float.toString(hsl));
        } catch (NumberFormatException e){
            Log.d("error", "error format ... " + e);
        }
    }
}