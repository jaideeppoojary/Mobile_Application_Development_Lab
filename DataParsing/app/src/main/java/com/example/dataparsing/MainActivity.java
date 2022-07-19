package com.example.dataparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button xmlParseBtn;
    Button jsonParseBtn;

    public void myInit(){
        xmlParseBtn = (Button) findViewById(R.id.buttonXml);
        jsonParseBtn = (Button) findViewById(R.id.buttonJson);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myInit();

        xmlParseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                intent.putExtra("mode", 1);
                startActivity(intent);
            }
        });

        jsonParseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                intent.putExtra("mode", 2);
                startActivity(intent);
            }
        });
    }
}