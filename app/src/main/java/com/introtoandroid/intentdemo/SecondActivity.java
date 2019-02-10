package com.introtoandroid.intentdemo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private int imageID;

    private ImageView waterfallImg;

    private ImageView supermoonImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        waterfallImg = findViewById(R.id.waterfall);

        supermoonImg = findViewById(R.id.supermoon);



        waterfallImg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Toast.makeText(getApplicationContext(), "Waterfall Was Clicked!", Toast.LENGTH_SHORT).show();

                imageID = R.drawable.waterfall;

                finish();
            }
        });

        supermoonImg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Toast.makeText(getApplicationContext(),"Supermoon Was Clicked", Toast.LENGTH_SHORT).show();

                imageID = R.drawable.supermoon;

                finish();
            }
        });





    }


    @Override
    public void finish(){

        Intent intent = new Intent();

        intent.putExtra("imageID", imageID);

        setResult(RESULT_OK, intent);

        super.finish();


    }
}
