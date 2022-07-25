package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Logs an user in the app
 */
public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        Button button= (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            /**
             * checks the user name and password for security reasons
             * @param v
             */
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                    //correct
                    Toast.makeText(login.this, "LOGIN SUCESSFULL", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(login.this,DataPage.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(login.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            /**
             * if the user doesn't have an account
             * takes the user to register page
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,Register.class);
                startActivity(intent);
            }
        });
    }
}
