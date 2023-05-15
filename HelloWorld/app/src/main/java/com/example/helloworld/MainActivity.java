package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText numberText1, numberText2;
    private Button addition, subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        numberText1 = (EditText) findViewById(R.id.num1);
        numberText2 = (EditText) findViewById(R.id.num2);
        addition = (Button) findViewById(R.id.sum);
        subtraction = (Button) findViewById(R.id.sub);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(numberText1.getText().toString());
                int num2 = Integer.parseInt(numberText2.getText().toString());
                result.setText(String.valueOf(num1 + num2));
            }
            });

    }
}