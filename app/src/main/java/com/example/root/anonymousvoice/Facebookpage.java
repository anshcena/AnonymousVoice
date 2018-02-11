package com.example.root.anonymousvoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Facebookpage extends AppCompatActivity {

    WebView fblink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebookpage);
        fblink=(WebView)findViewById(R.id.fbweb);
        fblink.getSettings().setLoadsImagesAutomatically(true);
        fblink.getSettings().setJavaScriptEnabled(true);
        fblink.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        fblink.setWebViewClient(new WebViewClient());
        fblink.loadUrl("https://www.facebook.com/anonymousvoicecomplaints/");


    }
}
