package com.example.hitungluaskeliling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private float nil1,nil2,hsl;
    private EditText n1,n2;
    private TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        n1 = findViewById(R.id.nilai1);
        n2 = findViewById(R.id.nilai2);
        hasil = findViewById(R.id.hasil);
    }

    public void luasPersegi(View view) {
        try {
            nil1 = Float.parseFloat(n1.getText().toString());
            nil2 = Float.parseFloat(n2.getText().toString());
            hsl = nil1 * nil2;
            hasil.setText(Float.toString(hsl));
        } catch (NumberFormatException e) {
            Log.d("error", "error format ... " + e);
        }
    }

    public void kelilingPersegi(View view) {
        try {
            nil1 = Float.parseFloat(n1.getText().toString());
            nil2 = Float.parseFloat(n2.getText().toString());
            hsl = 2 * nil1 + 2 * nil2;
            hasil.setText(Float.toString(hsl));
        } catch (NumberFormatException e) {
            Log.d("error", "error format ... " + e);
        }
    }
}