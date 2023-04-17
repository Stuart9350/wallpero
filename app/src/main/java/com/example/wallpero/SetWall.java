package com.example.wallpero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class SetWall extends AppCompatActivity {

    WallpaperManager wallpaperManager;
    Bitmap bitmap1, bitmap2;
    DisplayMetrics displayMetrics;
    int width, height;
    BitmapDrawable bitmapDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_wall);

        Button set = findViewById(R.id.btn_set);
        ImageView setWall = findViewById(R.id.finalWall);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("resId");
            setWall.setImageResource(resId);
        }


        wallpaperManager =WallpaperManager.getInstance(getApplicationContext());

        bitmapDrawable = (BitmapDrawable)  setWall.getDrawable();

        bitmap1 = bitmapDrawable.getBitmap();

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetScreenWidthHeight();
                SetBitmapSize();
                wallpaperManager = WallpaperManager.getInstance(SetWall.this);
                try{
                    wallpaperManager.setBitmap(bitmap2);
                    wallpaperManager.suggestDesiredDimensions(width, height);
                    Toast.makeText(SetWall.this, "Wallpaper set to Home Screen", Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }


        });


    }

    private void SetBitmapSize() {
        bitmap2 = Bitmap.createScaledBitmap(bitmap1, width, height,false);
    }

    private void GetScreenWidthHeight() {
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
    }
}