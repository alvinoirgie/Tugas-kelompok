package com.example.tugaskelompok;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private List<Makanan> listMakanan;

    public CartAdapter(List<Makanan> listMakanan) {
        this.listMakanan = listMakanan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Makanan makanan = listMakanan.get(position);
        holder.tvNama.setText(makanan.getNama());
        holder.tvHarga.setText("Rp" + makanan.getHarga());

        holder.btnHapus.setOnClickListener(v -> {
            int currentPosition = holder.getAdapterPosition();
            if (currentPosition != RecyclerView.NO_POSITION) {
                CartManager.hapusDariKeranjang(currentPosition);
                notifyItemRemoved(currentPosition);
                notifyItemRangeChanged(currentPosition, listMakanan.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga;
        Button btnHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaMakanan);
            tvHarga = itemView.findViewById(R.id.tvHargaMakanan);
            btnHapus = itemView.findViewById(R.id.btnHapus);
        }
    }
}