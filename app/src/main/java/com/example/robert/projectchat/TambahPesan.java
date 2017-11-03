package com.example.robert.projectchat;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class TambahPesan extends AppCompatActivity {

    ChatSetter chat;
    SharedPreferences pesanpref;

    EditText inputnama;
    EditText inputpesan;

    public static Intent Startintent(Context ctx){
        Intent it = new Intent(ctx,TambahPesan.class);
        return it;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pesan);

        pesanpref = getSharedPreferences(MainActivity.PREF,MODE_PRIVATE);

        inputnama = (EditText)findViewById(R.id.inputnama);
        inputpesan = (EditText)findViewById(R.id.inputpesan);
    }

    public void kirimpesan(View view) {
        Gson baru = new Gson();
        List<Itemchat> daftarlist = new ArrayList<>();

        String nama = inputnama.getText().toString();
        String pesan = inputpesan.getText().toString();

        if(!nama.isEmpty() || !pesan.isEmpty()){
            if(pesanpref.contains(MainActivity.PREF_CHAT)){
                chat = baru.fromJson(pesanpref.getString(MainActivity.PREF,""),ChatSetter.class);
                if(chat != null){
                    daftarlist = chat.getItem();
                }
            }
            daftarlist.add(new Itemchat(nama,pesan,new SimpleDateFormat("MM dd yyyy", Locale.US).format(new Date()),R.drawable.robert));
            chat = new ChatSetter();
            chat.setItem(daftarlist);
            String json = baru.toJson(chat);

            SharedPreferences.Editor edit = pesanpref.edit();
            edit.putString(MainActivity.PREF_CHAT,json);
            edit.apply();

            startActivity(MainActivity.mulai(this));
        }
    }
}
