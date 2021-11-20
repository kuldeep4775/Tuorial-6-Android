package com.example.tutorial_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {

    EditText email, password;
    Button btnLogin,register_link;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.et_username);
        password=findViewById(R.id.et_password);

        btnLogin=findViewById(R.id.btn_login);
        register_link=findViewById(R.id.registerlink);
        sharedPreferences=getSharedPreferences("userinfo",0);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1=email.getText().toString();
                String password1=password.getText().toString();

                String register_email = sharedPreferences.getString("email","");
                String register_password = sharedPreferences.getString("password","");

                if(email1.equals(register_email)&& password1.equals(register_password)){
                    Intent i = new Intent(login.this,Home.class);
                    startActivity(i);
                }
            }
        });

        register_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}