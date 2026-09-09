package com.example.tugaskelompok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private EditText etAlamat;
    private RadioGroup rgPembayaran;
    private Button btnPesanSekarang;
    private RecyclerView rvCartList;
    private CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart); // Menggunakan layout cart.xml

        etAlamat = findViewById(R.id.etAlamat);
        rgPembayaran = findViewById(R.id.rgPembayaran);
        btnPesanSekarang = findViewById(R.id.btnPesanSekarang);
        rvCartList = findViewById(R.id.rvCartList);

        // Ambil data dari CartManager
        List<Makanan> listData = CartManager.getCartList();

        // Set up RecyclerView
        if (rvCartList != null) {
            rvCartList.setLayoutManager(new LinearLayoutManager(this));
            adapter = new CartAdapter(listData);
            rvCartList.setAdapter(adapter);
        }

        if (btnPesanSekarang != null) {
            btnPesanSekarang.setOnClickListener(v -> {
                String alamat = etAlamat.getText().toString().trim();
                int selectedPaymentId = rgPembayaran.getCheckedRadioButtonId();

                if (CartManager.getCartList().isEmpty()) {
                    Toast.makeText(this, "Tidak bisa pesan sekarang! Keranjang kamu masih kosong.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (alamat.isEmpty() || selectedPaymentId == -1) {
                    Toast.makeText(this, "Tidak bisa pesan sekarang! Alamat dan metode pembayaran harus diisi.", Toast.LENGTH_SHORT).show();
                } else {
                    CartManager.resetKeranjang();
                    Intent intent = new Intent(CartActivity.this, SuccessActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}