package com.example.tutorial_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    EditText name,email,password;
    Button LoginLink,btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginLink=findViewById(R.id.loginlink);
        name=findViewById(R.id.edtname);
        email=findViewById(R.id.edtEmail);
        password=findViewById(R.id.edtPassword);

        btnRegister=findViewById(R.id.btnRegister);
        LoginLink=findViewById(R.id.loginlink);
        sharedPreferences=getSharedPreferences("userinfo",0);


        LoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,login.class);
                startActivity(i);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String email1=email.getText().toString();
                String password1=password.getText().toString();

                if(name1.length()>1) {


                    editor = sharedPreferences.edit();
                    editor.putString("name", name1);
                    editor.putString("email", email1);
                    editor.putString("password", password1);
                    editor.apply();

                    Toast.makeText(MainActivity.this,"Register successfully",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,login.class);
                }
                else{
                    Toast.makeText(MainActivity.this,"please Enter value",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}