package com.example.gourmetapps;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://qiita.com/s-yoshiki/items/508870dfccfb237d72fd");


        Button back = this.findViewById(R.id.backResult);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(search.this, result.class);
                startActivity(intent);
            }
        });
    }
}
