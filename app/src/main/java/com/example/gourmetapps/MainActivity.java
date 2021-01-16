package com.example.gourmetapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import api.GurunaviAPIModel;
import api.RestaurantInfo;
import ViewModel.RandomlyChooseViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api.GurunaviAPIModel api = new api.GurunaviAPIModel();
        ViewModel.RandomlyChooseViewModel random = new RandomlyChooseViewModel();


        TextView nameView = (TextView) findViewById(R.id.name);

        // テキストビューのテキストを設定します
        nameView.setText("テキスト1");

        Button button = this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                nameView.setText("change");


                Thread t = new GurunaviAPIModel();
                t.start();
                System.out.println("joinを始めます");
                try {
                    t.join(); // スレッドでの処理が終わるまで、ここでブロックされる
                } catch (InterruptedException e) {
                }

                System.out.println("joinが終わりました");

                String[] suggest = random.Introduction();
                for(int output = 0; output < suggest.length; output++){
                    System.out.println(suggest[output]);
                }
            }
        });
    }
}