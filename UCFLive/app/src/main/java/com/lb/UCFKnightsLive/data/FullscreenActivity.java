package com.lb.UCFKnightsLive.data;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends WebViewClient
{
    private WebView web;


    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
// TODO Auto-generated method stub
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
// TODO Auto-generated method stub

        view.loadUrl(url);
        return true;
    }

    public boolean canGoBack() {
        return this.web != null && this.web.canGoBack();
    }

    public void goBack() {
        if(this.web != null) {
            this.web.goBack();
        }
    }
}

