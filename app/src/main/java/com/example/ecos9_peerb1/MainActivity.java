package com.example.ecos9_peerb1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.example.ecos9_peerb1.model.Food;

public class MainActivity extends AppCompatActivity implements IObserver {

    ImageButton burgerBtn, friesBtn, hotdogBtn, shakeBtn;
    UDPConnection udp;
    int num = 1, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        burgerBtn = findViewById(R.id.burgerBtn);
        friesBtn = findViewById(R.id.friesBtn);
        hotdogBtn = findViewById(R.id.dogBtn);
        shakeBtn = findViewById(R.id.shakeBtn);


        //conexion
        udp = new UDPConnection();
        udp.start();

        //botones
        burgerBtn.setOnClickListener((v)->{
            Date date = new Date();
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("HH:mm:ss");
            String time= sdf.format(date);

            //gson
            Gson gson1 = new Gson();
            Food food1 = new Food(70, num, time, "Burger");
            String json1 = gson1.toJson(food1);

            num += 1;
            y += 100;

            udp.sendMsg(json1);
        });


        friesBtn.setOnClickListener((v)->{

            //tiempo
            Date date2 = new Date();
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("HH:mm:ss");
            String time2= sdf.format(date2);

            //gson
            Gson gson2 = new Gson();
            Food food2 = new Food(70, num, time2, "Fries");
            String json2 = gson2.toJson(food2);

            num += 1;
            y += 100;

            udp.sendMsg(json2);
        });

        hotdogBtn.setOnClickListener((v)->{

            //tiempo
            Date date3 = new Date();
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("HH:mm:ss");
            String time3 = sdf.format(date3);

            //gson
            Gson gson3 = new Gson();
            Food food3 = new Food(70, num, time3, "Hot Dog");
            String json3 = gson3.toJson(food3);

            num += 1;
            y += 100;

            udp.sendMsg(json3);
        });

        shakeBtn.setOnClickListener((v)->{
            //tiempo
            Date date4 = new Date();
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("HH:mm:ss");
            String time4 = sdf.format(date4);

            //gson
            Gson gson4 = new Gson();
            Food food4 = new Food(70, num, time4, "Milk Shake");
            String json4 = gson4.toJson(food4);

            num += 1;
            y += 100;

            udp.sendMsg(json4);
        });

    }

    @Override
    public void notifyMsg(String msg) {

        runOnUiThread(()-> {

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        });
    }

}