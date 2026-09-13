package com.example.tugaskelompok;

import java.util.ArrayList;
import java.util.List;

public class CartManager {

    // ==========================================
    // DAFTAR MAKANAN DI KERANJANG
    // ==========================================

    private static List<Makanan> cartList = new ArrayList<>();


    // ==========================================
    // MENGAMBIL DATA KERANJANG
    // ==========================================

    public static List<Makanan> getCartList() {

        if (cartList == null) {
            cartList = new ArrayList<>();
        }

        return cartList;
    }


    // ==========================================
    // MENAMBAHKAN MAKANAN
    // ==========================================

    public static void tambahKeKeranjang(Makanan makanan) {

        getCartList().add(makanan);
    }


    // ==========================================
    // MENGHAPUS BERDASARKAN POSISI
    // Dipakai oleh tombol Hapus di CartAdapter
    // ==========================================

    public static void hapusDariKeranjang(int position) {

        if (position >= 0 && position < getCartList().size()) {

            getCartList().remove(position);
        }
    }


    // ==========================================
    // MENGHAPUS SATU MAKANAN BERDASARKAN NAMA
    // Dipakai oleh tombol (-) di MainActivity
    // ==========================================

    public static void hapusSatuMakanan(String namaMakanan) {

        for (int i = 0; i < getCartList().size(); i++) {

            if (getCartList().get(i).getNama().equals(namaMakanan)) {

                getCartList().remove(i);

                break;
            }
        }
    }


    // ==========================================
    // MENGOSONGKAN KERANJANG
    // ==========================================

    public static void resetKeranjang() {

        getCartList().clear();
    }
}

