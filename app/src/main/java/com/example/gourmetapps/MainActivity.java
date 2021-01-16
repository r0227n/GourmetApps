package com.example.gourmetapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import api.GurunaviAPIModel;

import api.RestaurantInfo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api.GurunaviAPIModel api = new api.GurunaviAPIModel();



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
                System.out.println(RestaurantInfo.id);
                System.out.println(RestaurantInfo.name);
                System.out.println(RestaurantInfo.latitude);
                System.out.println(RestaurantInfo.longitude);
                System.out.println(RestaurantInfo.url);
                System.out.println(RestaurantInfo.addres);
                System.out.println(RestaurantInfo.tel);
                System.out.println(RestaurantInfo.opentime);
            }
        });
    }
}