package com.example.wallpero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView w1,w2,w3,w4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        w1 = findViewById(R.id.wall1);
        w2 = findViewById(R.id.wall2);
        w3 = findViewById(R.id.wall3);
        w4 = findViewById(R.id.wall4);

        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SetWall.class);
                intent.putExtra("resId", R.drawable.wall1);
                startActivity(intent);
            }
        });

        w2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SetWall.class);
                intent.putExtra("resId", R.drawable.wall2);
                startActivity(intent);
            }
        });

        w3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SetWall.class);
                intent.putExtra("resId", R.drawable.wall3);
                startActivity(intent);
            }
        });

        w4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SetWall.class);
                intent.putExtra("resId", R.drawable.wall4);
                startActivity(intent);
            }
        });



    }
}