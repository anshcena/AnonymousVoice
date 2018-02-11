package com.example.root.anonymousvoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TwitterAccount extends AppCompatActivity {
    WebView tweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_account);
        tweb=(WebView)findViewById(R.id.webtw);
        tweb.getSettings().setLoadsImagesAutomatically(true);
        tweb.getSettings().setJavaScriptEnabled(true);
        tweb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        tweb.setWebViewClient(new WebViewClient());
        tweb.loadUrl("https://twitter.com/___anonymous_0_");
    }
}
