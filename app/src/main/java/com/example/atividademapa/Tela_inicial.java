package com.example.atividademapa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;

public class Tela_inicial extends AppCompatActivity {

    public static EditText mtxtlatitude, mtxtlongitude;


    Button pesquisa;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);
        Button pesquisa = (Button) findViewById(R.id.pesquisa);
        mtxtlatitude = findViewById(R.id.mtxtlatitude);
        mtxtlongitude = findViewById(R.id.mtxtlongitude);


        pesquisa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Tela_inicial.this, MapsActivity.class);
                startActivity(it);
            }

        });

    }
}