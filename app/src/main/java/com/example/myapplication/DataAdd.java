package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataAdd extends AppCompatActivity {
    TextView date, ctime;
    EditText systolic, diastolic, bpm;
    DataSaver dataSaver;
    Button back, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_add);

        date=findViewById(R.id.date);
        ctime=findViewById(R.id.time);
        systolic=findViewById(R.id.etFirstName);
        diastolic=findViewById(R.id.etLastName);
        bpm=findViewById(R.id.etLastName);
        back=findViewById(R.id.back);
        submit=findViewById(R.id.submit);

        dataSaver = new DataSaver(this);

        Calendar calendar=Calendar.getInstance();
        String currentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        date.setText(currentDate);

        Calendar calendar1=Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("hh:mm");
        String time=currentTime.format(calendar.getTime());
        ctime.setText(time);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=systolic.getText().toString();
                String d=diastolic.getText().toString();
                String b=bpm.getText().toString();

                if(s.length()!=0 && d.length()!=0 && b.length()!=0)
                {
                    boolean insert = dataSaver.addData(s, d, b);
                    if(insert==true)
                    {
                        Toast.makeText(DataAdd.this, "Data Added", Toast.LENGTH_SHORT).show();
                        systolic.setText("");
                        diastolic.setText("");
                        bpm.setText("");
                    }
                    else {
                        Toast.makeText(DataAdd.this, "Fill in correctly", Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(DataAdd.this, "Value not inserted correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DataAdd.this, DataPage.class);
                startActivity(intent);
            }
        });
    }
}