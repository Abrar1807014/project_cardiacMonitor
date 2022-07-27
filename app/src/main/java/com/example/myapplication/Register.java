package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView entername =(TextView) findViewById(R.id.entername);
        TextView email =(TextView) findViewById(R.id.email);
        TextView password =(TextView) findViewById(R.id.password);
        TextView confirmpassword =(TextView) findViewById(R.id.confirmpassword);
        Button button = (Button) findViewById(R.id.button);

//        public class registracijaLastnika extends AppCompatActivity {
//
//            EditText etName;
//            EditText etSurname;
//            EditText etPasswordL;
//            EditText etUsernameL;
//            EditText etEmailL;
//            EditText etRepeatPasswordL;
//            Button bRegisterL;
//
//            @Override
//            protected void onCreate(Bundle savedInstanceState) {
//                super.onCreate(savedInstanceState);
//                setContentView(R.layout.activity_registracija_lastnika);
//
//                etName = (EditText) findViewById(R.id.etIme);
//                etSurname = (EditText) findViewById(R.id.etPriimek);
//                etPasswordL = (EditText) findViewById(R.id.etPasswordL);
//                etUsernameL = (EditText) findViewById(R.id.etUsernameL);
//                etEmailL = (EditText) findViewById(R.id.etEmailL);
//                etRepeatPasswordL = (EditText) findViewById(R.id.etRepeatPasswordL);
//                bRegisterL = (Button) findViewById(R.id.bRegisterL);
//            }
//
//            public void regLas(View view){
//                String type = "regLas";
//                String ime = etName.getText().toString();
//                String priimek = etSurname.getText().toString();
//                String uporabnisko_ime = etUsernameL.getText().toString();
//                String geslo = etPasswordL.getText().toString();
//                String gesloR = etRepeatPasswordL.getText().toString();
//                String email = etEmailL.getText().toString();
//                validate();
//                if(!validate()) {
//                    Toast.makeText(this,"Signup has Failed",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    BackgroundWorker backgroundWorker = new BackgroundWorker(this);
//                    backgroundWorker.execute(type, ime, priimek, uporabnisko_ime, geslo,        email);
//                    Intent registerIntent = new Intent(registracijaLastnika.this, registracijaKavarne.class);
//                    registracijaLastnika.this.startActivity(registerIntent);
//                }
//            }
//            public boolean validate(){
//                boolean valid = true;
//                if(etName.length()<1 || etName.length()>32){
//                    etName.setError("Please enter valid name");
//                    valid = false;
//                }
//                if(etSurname.length()<1 || etSurname.length()>32){
//                    etSurname.setError("Please enter valid name");
//                    valid = false;
//                }
//                if(etEmailL.length()<1 || !Patterns.EMAIL_ADDRESS.matcher((CharSequence) etEmailL).matches()){
//                    etEmailL.setError("Please enter valid email address");
//                    valid = false;
//                }
//                if(etPasswordL.length()<1){
//                    etPasswordL.setError("Please enter valid password");
//                    valid = false;
//                }
//                if(etRepeatPasswordL.length()<1){
//                    etRepeatPasswordL.setError("Please enter valid password");
//                    valid = false;
//                }
//                if(!etRepeatPasswordL.equals(etPasswordL)){
//                    etPasswordL.setError("Passwords don't match!");
//                    valid = false;
//                }
//                if(etUsernameL.length()<1 || etUsernameL.length()>32){
//                    etUsernameL.setError("Please enter valid name");
//                    valid = false;
//                }
//                return valid;
//            }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Register.this,DataPage.class);
                startActivity(intent);
            }
        });
    }
}