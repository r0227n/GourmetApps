package com.example.gourmetapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import android.content.Intent;

import api.GurunaviAPIModel;
import ViewModel.RandomlyChooseViewModel;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button segue = this.findViewById(R.id.segue);
        segue.setText("お店を探す");
        segue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // apiを叩く
                Thread t = new GurunaviAPIModel();
                t.start();
                System.out.println("joinを始めます");
                try {
                    t.join(); // スレッドでの処理が終わるまで、ここでブロックされる
                } catch (InterruptedException e) {
                }
                System.out.println("joinが終わりました");

                ViewModel.RandomlyChooseViewModel random = new RandomlyChooseViewModel();
                String[] suggest = random.Introduction();
                ViewInfo.name = suggest[1];
                ViewInfo.url = suggest[4];
                ViewInfo.addres = suggest[5];
                ViewInfo.tel = suggest[6];
                ViewInfo.opentime = suggest[7];

                // 「<activity android:name=".result"></activity>>」をAndroidManifest.xmlに書く
                Intent intent = new Intent(MainActivity.this, result.class);
                startActivity(intent);
            }
        });
    }
}