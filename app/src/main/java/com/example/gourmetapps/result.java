package com.example.gourmetapps;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ViewModel.RandomlyChooseViewModel;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        ViewModel.RandomlyChooseViewModel random = new RandomlyChooseViewModel();

        // TextViewを取得
        TextView nameTV = (TextView) findViewById(R.id.name);
        TextView urlTV = (TextView) findViewById(R.id.url);
        TextView addresTV = (TextView) findViewById(R.id.addres);
        TextView telTV = (TextView) findViewById(R.id.tel);
        TextView opentimeTV = (TextView) findViewById(R.id.opentime);


        String[] suggest = random.Introduction();

        // TextViewの値を更新
        nameTV.setText(suggest[1]);
        urlTV.setText(suggest[4]);
        addresTV.setText(suggest[5]);
        telTV.setText(suggest[6]);
        opentimeTV.setText(suggest[7]);

        nameTV.setText(suggest[1]);
        urlTV.setText(suggest[4]);
        addresTV.setText(suggest[5]);
        telTV.setText(suggest[6]);
        opentimeTV.setText(suggest[7]);


        Button search = this.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(result.this, search.class);
                startActivity(intent);
            }
        });

        Button back = this.findViewById(R.id.backHome);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(result.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}