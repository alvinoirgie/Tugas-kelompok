package com.example.tugaskelompok;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    // List static untuk menyimpan daftar pesanan
    private static List<Makanan> cartList = new ArrayList<>();

    public static List<Makanan> getCartList() {
        if (cartList == null) {
            cartList = new ArrayList<>();
        }
        return cartList;
    }

    public static void tambahKeKeranjang(Makanan makanan) {
        getCartList().add(makanan);
    }

    public static void hapusDariKeranjang(int position) {
        if (position >= 0 && position < getCartList().size()) {
            getCartList().remove(position);
        }
    }

    public static void resetKeranjang() {
        getCartList().clear();
    }
}