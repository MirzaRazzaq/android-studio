package com.example.hitungpredikat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtugas;
    private EditText edptugas;
    private EditText eduts;
    private EditText edputs;
    private EditText eduas;
    private EditText edpuas;
    private EditText edakhir;
    private EditText edhuruf;
    private EditText edpredikat;
    private float ntugas, nuts, nuas, nakhir, nptugas, nputs, npuas;
    private String predikat, huruf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtugas = findViewById(R.id.edtugas);
        edptugas = findViewById(R.id.edptugas);
        eduts = findViewById(R.id.eduts);
        edputs = findViewById(R.id.edputs);
        eduas = findViewById(R.id.eduas);
        edpuas = findViewById(R.id.edpuas);
        edakhir = findViewById(R.id.npakhir);
        edhuruf = findViewById(R.id.nphuruf);
        edpredikat = findViewById(R.id.nppredikat);

        edtugas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (edtugas.getText().toString().isEmpty()){
                    ntugas = 0;
                } else {
                    ntugas = Float.parseFloat(edtugas.getText().toString());
                }
                nptugas = 0.3f * ntugas;
                edptugas.setText(Float.toString(nptugas));
            }
        });

        eduts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (eduts.getText().toString().isEmpty()){
                    nuts = 0;
                } else {
                    nuts = Float.parseFloat(eduts.getText().toString());
                }
                nputs = 0.35f * nuts;
                edputs.setText(Float.toString(nputs));
            }
        });

        eduas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (eduas.getText().toString().isEmpty()){
                    nuas = 0;
                } else {
                    nuas = Float.parseFloat(eduas.getText().toString());
                }
                npuas = 0.35f * nuas;
                edpuas.setText(Float.toString(npuas));
            }
        });
    }

    public void hitungAkhir(){
        nakhir = (nptugas + nputs + npuas);
    }

    public String getHuruf(float nilai){
        if (nilai > 85){
            huruf = "A";
        } else if (nilai >= 80){
            huruf = "AB";
        } else if (nilai >= 70){
            huruf = "B";
        } else if (nilai >= 65){
            huruf = "BC";
        }  else if (nilai >= 60){
            huruf = "C";
        } else if (nilai >= 50){
            huruf = "D";
        } else {
            huruf = "C";
        }
        return huruf;
    }

    public String getPredikat(String nHuruf){
        switch (nHuruf)
        {
            case "A": predikat="Apik";break;
            case "AB": predikat="Apik Baik";break;
            case "B": predikat="Baik";break;
            case "BC": predikat="Cuku Baik";break;
            case "C": predikat="Cukup";break;
            case "D": predikat="Dablek";break;
            case "E": predikat="Elek";break;
        }
        return predikat;
    }

    public void hitung(View view) {
        hitungAkhir();
        edakhir.setText(Float.toString(nakhir));
        edhuruf.setText(getHuruf(nakhir));
        edpredikat.setText(getPredikat(huruf));
    }
}