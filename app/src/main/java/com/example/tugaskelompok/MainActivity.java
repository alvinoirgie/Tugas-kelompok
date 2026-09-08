package com.example.tugaskelompok;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBurger, btnAyam, btnMie, btnPizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBurger = findViewById(R.id.btnBurger);
        btnAyam = findViewById(R.id.btnAyam);
        btnMie = findViewById(R.id.btnMie);
        btnPizza = findViewById(R.id.btnPizza);

        btnBurger.setOnClickListener(v -> {
            Toast.makeText(this,
                    "Burger Spesial dipilih!",
                    Toast.LENGTH_SHORT).show();
        });

        btnAyam.setOnClickListener(v -> {
            Toast.makeText(this,
                    "Ayam Geprek dipilih!",
                    Toast.LENGTH_SHORT).show();
        });

        btnMie.setOnClickListener(v -> {
            Toast.makeText(this,
                    "Mie Goreng dipilih!",
                    Toast.LENGTH_SHORT).show();
        });

        btnPizza.setOnClickListener(v -> {
            Toast.makeText(this,
                    "Pizza dipilih!",
                    Toast.LENGTH_SHORT).show();
        });
    }
}