package com.example.robert.projectchat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 03/11/2017.
 */

public class ChatSetter {
    List <Itemchat> item = new ArrayList<>();

    public List<Itemchat> getItem() {
        return item;
    }

    public void setItem(List<Itemchat> item){
        this.item = item;
    }
}

class Itemchat{
    String nama_pengirim;
    String isi_pesan;
    String tanggal;
    int gambar;

    public Itemchat(String nama,String pesan, String tgl, int gmbr){
        this.nama_pengirim = nama;
        this.isi_pesan = pesan;
        this.tanggal = tgl;
        this.gambar = gmbr;
    }
    public String getNama_pengirim(){
        return nama_pengirim;
    }
    public String getIsi_pesan(){
        return isi_pesan;
    }
    public String getTanggal(){
        return tanggal;
    }
    public int getGambar(){
        return gambar;
    }
    public void setNama_pengirim(String nama){
        this.nama_pengirim = nama;
    }
    public void setIsi_pesanString (String pesan){
        this.isi_pesan = pesan;
    }
    public void setTanggal(String tgl){
        this.tanggal = tgl;
    }
    public void setGambar(int gmbr) {
        this.gambar = gmbr;
    }
}
