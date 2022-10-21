package com.example.counterapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Thread";
    Button start;
    Button stop;
    TextView counterText;
    int counter;
    boolean running = true;

    Handler mainHandler = new Handler();


    public void myInit(){
        start= (Button) findViewById(R.id.buttonToStart);
        stop= (Button) findViewById(R.id.buttonToStop);
        counterText= (TextView) findViewById(R.id.textViewCounter);
        counter = 1;
    }
    public void startThread(){
        myThread obj = new myThread();
        obj.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myInit();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter =0;
                running = true;
                startThread();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
            }
        });
    }

    class myThread extends  Thread {
        @Override
        public  void run(){
            while(running){
                counter+=1;

                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        counterText.setText(counter+"");
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}