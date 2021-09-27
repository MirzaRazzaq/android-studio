package com.example.hitungluaskeliling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private EditText n1,n2,n3,n4,n5;
    private TextView hasil, hasil_keliling;
    private float nil1,nil2,nil3,nil4,nil5,hsl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        n1 = findViewById(R.id.nilai1);
        n2 = findViewById(R.id.nilai2);
        n3 = findViewById(R.id.nilai3);
        n4 = findViewById(R.id.nilai4);
        n5 = findViewById(R.id.nilai5);
        hasil = findViewById(R.id.hasil);
        hasil_keliling = findViewById(R.id.hasil_keliling);
    }

    public void luasSegitiga(View view) {
        try {
            nil1 = Float.parseFloat(n1.getText().toString());
            nil2 = Float.parseFloat(n2.getText().toString());
            hsl = (float) (0.5 * nil1 * nil2);
            hasil.setText(Float.toString(hsl));
        } catch (NumberFormatException e) {
            Log.d("error", "error format ... " + e);
        }
    }

    public void kelilingSegitiga(View view) {
        try {
            nil3 = Float.parseFloat(n3.getText().toString());
            nil4 = Float.parseFloat(n4.getText().toString());
            nil5 = Float.parseFloat(n5.getText().toString());
            hsl = nil3 + nil4 + nil5;
            hasil_keliling.setText(Float.toString(hsl));
        } catch (NumberFormatException e) {
            Log.d("error", "error format ... " + e);
        }
    }
}