package com.example.robert.projectchat;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String PREF = "pref";
    public static final String PREF_CHAT = "chat";

    SharedPreferences mainpref;
    Adapterchat adapter;

    RecyclerView myRecycler;

    public static Intent mulai(Context ctx){
        Intent it = new Intent(ctx,MainActivity.class);
        return it;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecycler = (RecyclerView)findViewById(R.id.myrecycler);

        mainpref = getSharedPreferences(PREF,MODE_PRIVATE);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        myRecycler.setLayoutManager(lm);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Gson baru = new Gson();
        List<Itemchat> daftarlist = new ArrayList<>();
        if(mainpref.contains(PREF_CHAT)){
            ChatSetter chat = baru.fromJson(mainpref.getString(PREF_CHAT,""),ChatSetter.class);
            if(chat != null){
                daftarlist = chat.getItem();
                adapter = new Adapterchat(this,daftarlist);
                myRecycler.setAdapter(adapter);
            }
        }
    }

    public void tambah_action(View view) {
        startActivity(TambahPesan.Startintent(this));
    }
}
