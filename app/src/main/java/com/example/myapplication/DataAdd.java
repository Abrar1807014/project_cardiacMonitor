package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class DataAdd extends AppCompatActivity {
    TextView date, ctime;
    EditText systolic, diastolic, bpm;
    Button back, submit;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference().child("Data");
    DatabaseReference dref;
    String id;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_add);

        date=findViewById(R.id.date);
        ctime=findViewById(R.id.time);
        systolic=findViewById(R.id.etFirstName);
        diastolic=findViewById(R.id.etLastName);
        bpm=findViewById(R.id.etFavFood);
        //back=findViewById(R.id.back);
        submit=findViewById(R.id.submit);


        Calendar calendar=Calendar.getInstance();
        String currentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        date.setText(currentDate);

        Calendar calendar1=Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("hh:mm:ss");
        String time=currentTime.format(calendar.getTime());
        ctime.setText(time);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                //dref=firebaseDatabase.getReference().child("Data").child(id);
                String s=systolic.getText().toString();
                String d=diastolic.getText().toString();
                String b=bpm.getText().toString();
                String com;

                if(s.length()!=0 && d.length()!=0 && b.length()!=0)
                {
                    HashMap<String, String> usermap = new HashMap<>();
                    usermap.put("Date", currentDate);
                    usermap.put("Time", time);
                    usermap.put("systolic", s);
                    usermap.put("diastolic", d);
                    usermap.put("bpm", b);
                    //usermap.put("ID", id);



                    Integer ints = Integer.parseInt(s);
                    Integer intd = Integer.parseInt(d);
                    Integer intb = Integer.parseInt(b);

                    if(ints<120 && intd<80)
                    {
                        com = "Normal";
                        usermap.put("comment", com);
                    }
                    else if ((ints<=129 && ints>=120) && intd <80)
                    {
                        com = "Elevated";
                        usermap.put("comment", com);
                    }
                    else if ((ints<=139 && ints>=130) || (intd >=80 && intd<=89))
                    {
                        com = "High Blood Pressure_Stage 1";
                        usermap.put("comment", com);
                    }
                    else if (ints>=140 || intd>=90)
                    {
                        com = "High Blood Pressure_Stage 2";
                        usermap.put("comment", com);
                    }
                    String key=currentDate+time;
                    String key1 = key.replaceAll("\\s", "");
                    databaseReference.child(key1).setValue(usermap);


                    Toast.makeText(DataAdd.this,  "Data added", Toast.LENGTH_SHORT).show();
                      systolic.setText("");
                      diastolic.setText("");
                      bpm.setText("");


                }
                else
                {
                    Toast.makeText(DataAdd.this, "Value not inserted correctly", Toast.LENGTH_SHORT).show();
                }
                Intent it = new Intent(DataAdd.this, DataPage.class);
                startActivity(it);
            }


        });


    }
}