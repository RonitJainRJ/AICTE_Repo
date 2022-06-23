package com.example.otpverification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Objects;

public class webscheme extends AppCompatActivity {
    WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.skyblue));

        setContentView(R.layout.activity_webscheme);

        webView1 = findViewById(R.id.webscheme);
        webView1.setWebViewClient(new WebViewClient());
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.loadUrl("https://www.aicte-india.org/schemes");
    }

    @Override
    public void onBackPressed() {
        if (webView1.canGoBack()){
            webView1.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}