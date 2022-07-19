package com.example.wallpaperchange;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public Button changeButton;
    public int images[] ;
    public int i;
    public  void myInit(){
        images= new int[]{
                R.drawable.avatar,
                R.drawable.digitalart,
                R.drawable.farawayboy,
                R.drawable.farawaygirl,
                R.drawable.mountain,
                R.drawable.wall,
        };
        changeButton = (Button) findViewById(R.id.wallpaperButton);
        i=0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myInit();
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Timer().schedule(new ChangeWallpaper(), 0, 3000);
            }
        });


    }
    class ChangeWallpaper extends TimerTask{

        @Override
        public void run() {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());

            try{
                wallpaperManager.setBitmap( BitmapFactory.decodeResource(getResources(), images[i]) );
                i++;
                if( i>= images.length)
                    i=0;
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

}
