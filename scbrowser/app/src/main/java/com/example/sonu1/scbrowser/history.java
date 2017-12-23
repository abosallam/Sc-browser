package com.example.sonu1.scbrowser;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class history extends AppCompatActivity {
    String urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent in=getIntent();
        urls = in.getStringExtra(urls);
        setContentView(R.layout.activity_history);
        try{
            SQLiteDatabase historydb = this.openOrCreateDatabase("history", MODE_PRIVATE, null);
            historydb.execSQL("CREATE TABLE IF NOT EXIST history (url VARCHAR)");
            historydb.execSQL("INSERT INTO history (url) VALUES (urls)");

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
