package com.example.gourmetapps;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);




        // TextViewを取得
        TextView nameTV = (TextView) findViewById(R.id.name);
        TextView addresTV = (TextView) findViewById(R.id.addres);
        TextView telTV = (TextView) findViewById(R.id.tel);
        TextView opentimeTV = (TextView) findViewById(R.id.opentime);



        // TextViewの値を更新
        nameTV.setText(ViewInfo.name);
        addresTV.setText(ViewInfo.addres);
        telTV.setText(ViewInfo.tel);
        opentimeTV.setText(ViewInfo.opentime);



        Button search = this.findViewById(R.id.search);
        search.setText("Webサイトへ");
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(result.this, search.class);
                startActivity(intent);
            }
        });

        Button back = this.findViewById(R.id.backHome);
        back.setText("ホーム画面に戻る");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(result.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}