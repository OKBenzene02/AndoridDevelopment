package com.example.exampleprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView textAttribute;
    private android.os.Handler Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textAttribute = findViewById(R.id.textAttribute);
        Handler handler = new Handler();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    String result = performOperation();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textAttribute.setText(result);
                        }
                    });

                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();

    }
    private String performOperation(){
        try{
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Operation complete at " + new Date().toString();
    }
}