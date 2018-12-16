package com.example.yuripps.caloriebook;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yuripps.caloriebook.DessertActivity;
import com.example.yuripps.caloriebook.DrinkActivity;
import com.example.yuripps.caloriebook.FoodActivity;
import com.example.yuripps.caloriebook.FruitActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // กำหนดปุ่ม
        ImageView food = findViewById(R.id.food_iv);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FoodActivity.class);
                startActivity(intent);
            }
        });

        ImageView drink = findViewById(R.id.drink_iv);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DrinkActivity.class);
                startActivity(intent);
            }
        });

        ImageView fruit = findViewById(R.id.fruit_iv);
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FruitActivity.class);
                startActivity(intent);
            }
        });

        ImageView dessert = findViewById(R.id.dessert_iv);
        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DessertActivity.class);
                startActivity(intent);
            }
        });




    }


}
