package com.example.sonu1.scbrowser;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class newtab extends MainActivity implements View.OnClickListener{

    WebView webview;
    String url;
    Button search1,home1;
    EditText edittext1;
    ProgressBar bar;
    SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtab);

        Intent intent= getIntent();
        url=intent.getStringExtra("url");

        webview =(WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new myWebclient());
        webview.loadUrl(url);

        webview.invokeZoomPicker();
        WebSettings webset =  webview.getSettings();
        webset.setBuiltInZoomControls(true);
        webset.setUseWideViewPort(true);
        webset.setLoadWithOverviewMode(true);

        bar=(ProgressBar) findViewById(R.id.progressBar);
        refresh= (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        home1 = (Button)findViewById(R.id.home1);
        search1 = (Button)findViewById(R.id.search1);
        edittext1 = (EditText)findViewById(R.id.edittext1);

        home1.setOnClickListener(this);
        search1.setOnClickListener(this);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webview.reload();
            }
        });
    }

    public class myWebclient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            bar.setVisibility(view.VISIBLE);
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            bar.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id1=item.getItemId();
        switch(id1)
        {
            case R.id.back:
                if (webview.canGoBack()) {
                    webview.goBack();
                } else {
                    super.onBackPressed();
                }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View n) {
        switch (n.getId())
        {
            case R.id.search1:
                String url1= edittext1.getText().toString();
                String a = "http://" + url1;
                String b = "http://www." + url1;
                if(url1 != null) {
                    if (Patterns.WEB_URL.matcher(url1.toLowerCase()).matches() == false) {
                        String query = "https://www.google.com/search?q=" + url1;
                        webview.loadUrl(query);
                    }
                    else if (Patterns.WEB_URL.matcher(a.toLowerCase()).matches() == true) {
                        webview.loadUrl(a);
                    }
                    else {
                        webview.loadUrl(b);
                    }
                    break;
                }
                else
                {
                    break;
                }
            case R.id.home1:
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}

