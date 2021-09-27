package com.example.hitungluaskeliling;

import static java.lang.Math.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    private EditText n1;
    private TextView hasil;
    private double r,hsl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        n1 = findViewById(R.id.nilai1);
        hasil = findViewById(R.id.hasil);
    }

    public void luasLingkaran(View view) {
        try {
            r = Double.parseDouble(n1.getText().toString());
            hsl = 3.14 * sqrt(r);
            hasil.setText(Double.toString(hsl));
        } catch (NumberFormatException e) {
            Log.d("error", "error format ... " + e);
        }
    }

    public void kelilingLingkarang(View view) {
        try {
            r = Double.parseDouble(n1.getText().toString());
            hsl = 2 * 3.14 * r;
            hasil.setText(Double.toString(hsl));
        } catch (NumberFormatException e) {
            Log.d("error", "error format ... " + e);
        }
    }

}