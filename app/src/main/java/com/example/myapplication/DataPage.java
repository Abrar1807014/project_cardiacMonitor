package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Home Page
 * Holds two buttons which shows
 * the records and adds data
 */
public class DataPage extends AppCompatActivity {
    public Button button;
    public Button button2;
    public ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_page);


        actionBar = getSupportActionBar();


        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#1F4690"));


        actionBar.setBackgroundDrawable(colorDrawable);

        button=findViewById(R.id.records);
        button2=findViewById(R.id.add);

        button.setOnClickListener(new View.OnClickListener() {
            /**
             * takes the user to Record Page
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataPage.this, Records.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            /**
             * takes the user to Data Add Page
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DataPage.this, DataAdd.class);
                startActivity(intent);
            }
        });
    }
}