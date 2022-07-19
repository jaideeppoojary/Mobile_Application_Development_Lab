package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private EditText et3;

    public void InitValues(){
        et1 = (EditText) findViewById(R.id.editTextNumber);
        et2 = (EditText) findViewById(R.id.editTextNumber2);
        et3 = (EditText) findViewById(R.id.editTextNumberResult);
    }
    public void Add(View v){
        int n1 = Integer.parseInt(et1.getText().toString());
        int n2 = Integer.parseInt(et2.getText().toString());

        int result = n1 + n2;
        et3.setText("Addition result: " + result);
    }
    public void Sub(View v){
        int n1 = Integer.parseInt(et1.getText().toString());
        int n2 = Integer.parseInt(et2.getText().toString());

        int result = n1 - n2;
        et3.setText("Subtraction result: " + result);
    }
    public void Mul(View v){
        int n1 = Integer.parseInt(et1.getText().toString());
        int n2 = Integer.parseInt(et2.getText().toString());

        int result = n1 * n2;
        et3.setText("Multiplication result: " + result);
    }
    public void Div(View v){
        int n1 = Integer.parseInt(et1.getText().toString());
        int n2 = Integer.parseInt(et2.getText().toString());
        double result;
        if( n2!=0){
            result = n1/n2;
            et3.setText("Division result: " + result);
        }
        else{
            et3.setText("Zero Division Not allowed!!");
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Initializing values before calling any functions
        InitValues();
    }
}