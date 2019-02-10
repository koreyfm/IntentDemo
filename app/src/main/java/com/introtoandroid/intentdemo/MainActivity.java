package com.introtoandroid.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    public static final int BACKGROUND_VAL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Intent Has Been Called", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                // This is to launch another Activity without expecting to return
                //startActivity(intent);

                // This is to launch another Activity with expectation that it will return
                startActivityForResult(intent, BACKGROUND_VAL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestVal, int resultVal, Intent data){

        if (requestVal == BACKGROUND_VAL && resultVal == Activity.RESULT_OK) {

            Bundle extras = data.getExtras();

            if (extras != null) {

                int imageID = extras.getInt("imageID");

                ConstraintLayout currentLayout = findViewById(R.id.mainLayout);

                currentLayout.setBackground(getDrawable(imageID));

            }
        }
    }

}
