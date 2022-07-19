package com.example.signuploginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public EditText signupUserName;
    public EditText signupUserPassword;
    public Button signupButton;
    public String regularExpression;
    public void myInit(){
        signupUserName = (EditText) findViewById(R.id.signupUserName);
        signupUserPassword = (EditText) findViewById(R.id.signupUserPassword);
        signupButton = (Button) findViewById(R.id.signupButton);

        regularExpression = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,19}$";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myInit();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = signupUserName.getText().toString();
                String userPassword = signupUserPassword.getText().toString();

                if(validatePassword(userPassword)){
                    //like wrapping values
                    Bundle bundle = new Bundle();
                    bundle.putString("username", userName);
                    bundle.putString("password", userPassword);

                    Intent intent = new Intent(MainActivity.this, Signin.class);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public  Boolean validatePassword(String pass){
        Pattern pattern = Pattern.compile(regularExpression);

        if(pattern.matcher(pass).matches())
            return true;
        else
            return  false;
    }
}