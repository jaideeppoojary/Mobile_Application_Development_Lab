package com.example.signuploginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends AppCompatActivity {

    public EditText loginUserName;
    public EditText loginUserPass;
    public Button loginButton;
    int count=0;

    public void myInit(){
        loginUserName = (EditText) findViewById(R.id.loginUserName);
        loginUserPass = (EditText) findViewById(R.id.loginUserPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        myInit();

//        Intent intent = getIntent();
//        String id = intent.getStringExtra("username");
//        String pass = intent.getStringExtra("password");
        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("username");
        String pass = bundle.getString("password");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = loginUserName.getText().toString();
                String password = loginUserPass.getText().toString();

                if( id.equals(user) && pass.equals(password)){
                    Toast.makeText(Signin.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    count++;

                    if( count>=3){
                        loginButton.setEnabled(false);
                        Toast.makeText(Signin.this, "Failed Login in Attempts", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(Signin.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}