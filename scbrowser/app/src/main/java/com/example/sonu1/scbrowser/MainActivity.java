package com.example.sonu1.scbrowser;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button youtube,twitter,google,search,facebook,msn,amazon,exit,home;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = (Button)findViewById(R.id.search);
        youtube = (Button)findViewById(R.id.youtube);
        google = (Button)findViewById(R.id.google);
        facebook = (Button)findViewById(R.id.facebook);
        twitter = (Button) findViewById(R.id.twitter);
        edittext = (EditText)findViewById(R.id.edittext);
        msn = (Button) findViewById(R.id.msn);
        amazon = (Button) findViewById(R.id.amazon);
        exit = (Button) findViewById(R.id.exit);
        home = (Button) findViewById(R.id.home);


        search.setOnClickListener(this);
        youtube.setOnClickListener(this);
        google.setOnClickListener(this);
        facebook.setOnClickListener(this);
        twitter.setOnClickListener(this);
        search.setOnClickListener(this);
        msn.setOnClickListener(this);
        amazon.setOnClickListener(this);
        exit.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.home:
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.exit:
                Intent homeIntent1 = new Intent(Intent.ACTION_MAIN);
                homeIntent1.addCategory( Intent.CATEGORY_HOME );
                homeIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent1);
                break;
            case R.id.about:
                Intent ab=new Intent(getApplicationContext(),Aboutus.class);
                startActivity(ab);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.facebook:
                String url1="http://www.facebook.com";
                Intent i=new Intent(getApplicationContext(),newtab.class);
                i.putExtra("url",url1);
                startActivity(i);
                break;
            case R.id.youtube:
                String url2="http://www.youtube.com";
                Intent j=new Intent(getApplicationContext(),newtab.class);
                j.putExtra("url",url2);
                startActivity(j);
                break;
            case R.id.google:
                String url3="http://www.google.com";
                Intent k=new Intent(getApplicationContext(),newtab.class);
                k.putExtra("url",url3);
                startActivity(k);
                break;
            case R.id.twitter:
                String url4="http://www.twitter.com";
                Intent l=new Intent(getApplicationContext(),newtab.class);
                l.putExtra("url",url4);
                startActivity(l);
                break;
            case R.id.msn:
                String url5="http://www.msn.com";
                Intent m=new Intent(getApplicationContext(),newtab.class);
                m.putExtra("url",url5);
                startActivity(m);
                break;
            case R.id.amazon:
                String url6="http://www.amazon.in";
                Intent n=new Intent(getApplicationContext(),newtab.class);
                n.putExtra("url",url6);
                startActivity(n);
                break;
            case R.id.search:
                String url7= edittext.getText().toString();
                String a = "http://" + url7;
                String b = "http://www." + url7;
                if(url7 != null) {
                    Intent o = new Intent(getApplicationContext(), newtab.class);
                    if (Patterns.WEB_URL.matcher(url7.toLowerCase()).matches() == false) {
                        String query = "https://www.google.com/search?q=" + url7;
                        o.putExtra("url", query);
                        startActivity(o);
                    } else if (Patterns.WEB_URL.matcher(a.toLowerCase()).matches() == true) {
                        o.putExtra("url", a);
                        startActivity(o);
                    } else {
                        o.putExtra("url", b);
                        startActivity(o);
                    }
                    break;
                }
                else
                {
                    break;
                }
            case R.id.exit:
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                break;
        }

    }
}
