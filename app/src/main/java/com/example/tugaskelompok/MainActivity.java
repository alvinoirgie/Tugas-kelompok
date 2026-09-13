package com.example.tugaskelompok;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Tombol PESAN
    Button btnBurger, btnAyam, btnMie, btnPizza;

    // Tombol KURANG (-)
    Button btnKurangBurger, btnKurangAyam, btnKurangMie, btnKurangPizza;

    // TextView jumlah
    TextView tvJumlahBurger, tvJumlahAyam, tvJumlahMie, tvJumlahPizza;

    // Tombol keranjang
    ImageButton btnKeranjang;

    // Jumlah masing-masing makanan
    int jumlahBurger = 0;
    int jumlahAyam = 0;
    int jumlahMie = 0;
    int jumlahPizza = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ==========================================
        // INISIALISASI TOMBOL PESAN
        // ==========================================

        btnBurger = findViewById(R.id.btnBurger);
        btnAyam = findViewById(R.id.btnAyam);
        btnMie = findViewById(R.id.btnMie);
        btnPizza = findViewById(R.id.btnPizza);


        // ==========================================
        // INISIALISASI TOMBOL KURANG
        // ==========================================

        btnKurangBurger = findViewById(R.id.btnKurangBurger);
        btnKurangAyam = findViewById(R.id.btnKurangAyam);
        btnKurangMie = findViewById(R.id.btnKurangMie);
        btnKurangPizza = findViewById(R.id.btnKurangPizza);


        // ==========================================
        // INISIALISASI JUMLAH
        // ==========================================

        tvJumlahBurger = findViewById(R.id.tvJumlahBurger);
        tvJumlahAyam = findViewById(R.id.tvJumlahAyam);
        tvJumlahMie = findViewById(R.id.tvJumlahMie);
        tvJumlahPizza = findViewById(R.id.tvJumlahPizza);


        // ==========================================
        // INISIALISASI KERANJANG
        // ==========================================

        btnKeranjang = findViewById(R.id.btnKeranjang);


        // ==========================================
        // BURGER - TAMBAH
        // ==========================================

        btnBurger.setOnClickListener(v -> {

            jumlahBurger++;

            tvJumlahBurger.setText(String.valueOf(jumlahBurger));

            CartManager.tambahKeKeranjang(
                    new Makanan("Burger Spesial", 25000)
            );

            Toast.makeText(
                    this,
                    "Burger Spesial +1",
                    Toast.LENGTH_SHORT
            ).show();
        });


        // ==========================================
        // BURGER - KURANG
        // ==========================================

        btnKurangBurger.setOnClickListener(v -> {

            if (jumlahBurger > 0) {

                jumlahBurger--;

                tvJumlahBurger.setText(String.valueOf(jumlahBurger));

                CartManager.hapusSatuMakanan("Burger Spesial");
            }
        });


        // ==========================================
        // AYAM - TAMBAH
        // ==========================================

        btnAyam.setOnClickListener(v -> {

            jumlahAyam++;

            tvJumlahAyam.setText(String.valueOf(jumlahAyam));

            CartManager.tambahKeKeranjang(
                    new Makanan("Ayam Geprek", 18000)
            );

            Toast.makeText(
                    this,
                    "Ayam Geprek +1",
                    Toast.LENGTH_SHORT
            ).show();
        });


        // ==========================================
        // AYAM - KURANG
        // ==========================================

        btnKurangAyam.setOnClickListener(v -> {

            if (jumlahAyam > 0) {

                jumlahAyam--;

                tvJumlahAyam.setText(String.valueOf(jumlahAyam));

                CartManager.hapusSatuMakanan("Ayam Geprek");
            }
        });


        // ==========================================
        // MIE - TAMBAH
        // ==========================================

        btnMie.setOnClickListener(v -> {

            jumlahMie++;

            tvJumlahMie.setText(String.valueOf(jumlahMie));

            CartManager.tambahKeKeranjang(
                    new Makanan("Mie Goreng", 15000)
            );

            Toast.makeText(
                    this,
                    "Mie Goreng +1",
                    Toast.LENGTH_SHORT
            ).show();
        });


        // ==========================================
        // MIE - KURANG
        // ==========================================

        btnKurangMie.setOnClickListener(v -> {

            if (jumlahMie > 0) {

                jumlahMie--;

                tvJumlahMie.setText(String.valueOf(jumlahMie));

                CartManager.hapusSatuMakanan("Mie Goreng");
            }
        });


        // ==========================================
        // PIZZA - TAMBAH
        // ==========================================

        btnPizza.setOnClickListener(v -> {

            jumlahPizza++;

            tvJumlahPizza.setText(String.valueOf(jumlahPizza));

            CartManager.tambahKeKeranjang(
                    new Makanan("Pizza Medium", 45000)
            );

            Toast.makeText(
                    this,
                    "Pizza Medium +1",
                    Toast.LENGTH_SHORT
            ).show();
        });


        // ==========================================
        // PIZZA - KURANG
        // ==========================================

        btnKurangPizza.setOnClickListener(v -> {

            if (jumlahPizza > 0) {

                jumlahPizza--;

                tvJumlahPizza.setText(String.valueOf(jumlahPizza));

                CartManager.hapusSatuMakanan("Pizza Medium");
            }
        });


        // ==========================================
        // BUKA KERANJANG
        // ==========================================

        btnKeranjang.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    CartActivity.class
            );

            startActivity(intent);
        });

    }
}

