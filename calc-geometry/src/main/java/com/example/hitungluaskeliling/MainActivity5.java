package com.example.hitungluaskeliling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    private EditText n1;
    private TextView hasil;
    private float nil1,nil2,hsl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        n1 = findViewById(R.id.nilai1);
        hasil = findViewById(R.id.hasil);
    }

    public void luasKubus(View view) {
        try {
            nil1 = Float.parseFloat(n1.getText().toString());
            hsl = nil1 * nil1 * nil1;
            hasil.setText(Float.toString(hsl));
        } catch (NumberFormatException e){
            Log.d("error", "error format ... " + e);
        }
    }

    public void kelilingKubus(View view) {
        try {
            nil1 = Float.parseFloat(n1.getText().toString());
            hsl = 12 * nil1;
            hasil.setText(Float.toString(hsl));
        } catch (NumberFormatException e){
            Log.d("error", "error format ... " + e);
        }
    }
}