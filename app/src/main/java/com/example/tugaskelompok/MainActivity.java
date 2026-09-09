package com.example.tugaskelompok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBurger, btnAyam, btnMie, btnPizza;
    ImageButton btnKeranjang; // Deklarasi di LUAR onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi ID Tombol
        btnBurger = findViewById(R.id.btnBurger);
        btnAyam = findViewById(R.id.btnAyam);
        btnMie = findViewById(R.id.btnMie);
        btnPizza = findViewById(R.id.btnPizza);
        btnKeranjang = findViewById(R.id.btnKeranjang); // Inisialisasi di DALAM onCreate

        // 1. Tombol Burger
        btnBurger.setOnClickListener(v -> {
            CartManager.tambahKeKeranjang(new Makanan("Burger Spesial", 25000));
            Toast.makeText(this, "Burger Spesial dimasukkan ke keranjang!", Toast.LENGTH_SHORT).show();
        });

        // 2. Tombol Ayam
        btnAyam.setOnClickListener(v -> {
            CartManager.tambahKeKeranjang(new Makanan("Ayam Geprek", 18000));
            Toast.makeText(this, "Ayam Geprek dimasukkan ke keranjang!", Toast.LENGTH_SHORT).show();
        });

        // 3. Tombol Mie
        btnMie.setOnClickListener(v -> {
            CartManager.tambahKeKeranjang(new Makanan("Mie Goreng", 15000));
            Toast.makeText(this, "Mie Goreng dimasukkan ke keranjang!", Toast.LENGTH_SHORT).show();
        });

        // 4. Tombol Pizza
        btnPizza.setOnClickListener(v -> {
            CartManager.tambahKeKeranjang(new Makanan("Pizza Medium", 45000));
            Toast.makeText(this, "Pizza Medium dimasukkan ke keranjang!", Toast.LENGTH_SHORT).show();
        });

        // 5. Tombol Keranjang (Pindah ke CartActivity)
        btnKeranjang.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}