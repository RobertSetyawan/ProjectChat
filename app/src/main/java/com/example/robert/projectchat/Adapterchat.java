package com.example.robert.projectchat;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Robert on 03/11/2017.
 */

public class Adapterchat extends RecyclerView.Adapter<Adapterchat.ViewChatholder> {

    Context ctx;
    List<Itemchat> daftarlist;

    public Adapterchat(Context ct, List<Itemchat> daftarlist){
        this.ctx = ct;
        this.daftarlist = daftarlist;
    }
    @Override
    public ViewChatholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listchat,parent,false);
        return new ViewChatholder(v);
    }

    @Override
    public void onBindViewHolder(ViewChatholder holder, int position) {
        holder.nama.setText(daftarlist.get(position).getNama_pengirim());
        holder.pesan.setText(daftarlist.get(position).getIsi_pesan());
        holder.tanggal.setText(daftarlist.get(position).getTanggal());
        holder.gambar.setImageResource(daftarlist.get(position).getGambar());
    }

    @Override
    public int getItemCount() {
        return daftarlist.size();
    }

    public class ViewChatholder extends RecyclerView.ViewHolder {
        TextView nama;
        TextView pesan;
        TextView tanggal;
        ImageView gambar;

        public ViewChatholder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.nama_pengirim);
            pesan = (TextView) itemView.findViewById(R.id.pesan);
            tanggal = (TextView) itemView.findViewById(R.id.tanggal);
            gambar = (ImageView) itemView.findViewById(R.id.gambar);
        }
    }
}
