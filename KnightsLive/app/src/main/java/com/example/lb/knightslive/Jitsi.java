package com.example.lb.knightslive;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Jitsi extends Activity {
    WebView web;
    String url = "http://www.google.com";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fullscreen);
        web = (WebView) findViewById( R.id.webview );
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setJavaScriptEnabled(true); //Enable Js execution!
        web.setWebChromeClient(new WebChromeClient());
        web.loadUrl("https://meet.jit.si/");
        String url = "https://meet.jit.si/";

        web.getSettings().setLoadsImagesAutomatically(true);
        web.setScrollBarStyle( View.SCROLLBARS_INSIDE_OVERLAY);
        web.loadDataWithBaseURL( null, "<script src=\"https://meet.jit.si/external_api.js\"></script>", "text/html", "utf-8", null );
        web.loadUrl(url);

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
/*
        web=(WebView)findViewById(R.id.webView);
        web.setWebViewClient(new MyBrowser());


        String url = "https://meet.jit.si/";

        web.getSettings().setLoadsImagesAutomatically(true);
        web.getSettings().setJavaScriptEnabled(true);
        web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web.loadDataWithBaseURL( null, "<script src=\"https://meet.jit.si/external_api.js\"></script>", "text/html", "utf-8", null );
        web.loadUrl(url);*/

    }

