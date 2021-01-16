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
        myWebView.loadUrl(ViewInfo.url);


        Button back = this.findViewById(R.id.backResult);
        back.setText("検索結果一覧に戻る");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(search.this, result.class);
                startActivity(intent);
            }
        });
    }
}
