package com.example.gourmetapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// これでWebViewはおk
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//WebView myWebView = (WebView) findViewById(R.id.webview);
//        myWebView.loadUrl("https://qiita.com/s-yoshiki/items/508870dfccfb237d72fd");

import android.content.Intent;

import api.GurunaviAPIModel;
import ViewModel.RandomlyChooseViewModel;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api.GurunaviAPIModel api = new api.GurunaviAPIModel();
        ViewModel.RandomlyChooseViewModel random = new RandomlyChooseViewModel();


        // TextViewを取得
        TextView nameTV = (TextView) findViewById(R.id.name);
        TextView urlTV = (TextView) findViewById(R.id.url);
        TextView addresTV = (TextView) findViewById(R.id.addres);
        TextView telTV = (TextView) findViewById(R.id.tel);
        TextView opentimeTV = (TextView) findViewById(R.id.opentime);


        // TextViewの初期値を設定します
        nameTV.setText("店舗名");
        urlTV.setText("URL");
        addresTV.setText("アドレス");
        telTV.setText("電話番号");
        opentimeTV.setText("開店時間");




        Button button = this.findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Thread t = new GurunaviAPIModel();
                t.start();
                System.out.println("joinを始めます");
                try {
                    t.join(); // スレッドでの処理が終わるまで、ここでブロックされる
                } catch (InterruptedException e) {
                }

                System.out.println("joinが終わりました");

                String[] suggest = random.Introduction();

                // TextViewの値を更新
                nameTV.setText(suggest[1]);
                urlTV.setText(suggest[4]);
                addresTV.setText(suggest[5]);
                telTV.setText(suggest[6]);
                opentimeTV.setText(suggest[7]);

            }
        });

        Button segue = this.findViewById(R.id.segue);
        segue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // 「<activity android:name=".result"></activity>>」をAndroidManifest.xmlに書く
                Intent intent = new Intent(MainActivity.this, result.class);
                startActivity(intent);
            }
        });
    }
}