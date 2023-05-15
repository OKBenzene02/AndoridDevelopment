package com.example.calciwithoutbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private EditText num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.numberOne);
        num2 = (EditText) findViewById(R.id.numberTwo);
        result = (TextView) findViewById(R.id.result);

        TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!num1.getText().toString().equals("") && !num2.getText().toString().equals("")){
                        result.setText(String.valueOf(Integer.parseInt(num1.getText().toString())
                                + Integer.parseInt(num2.getText().toString())));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        num1.addTextChangedListener(textWatcher);
        num2.addTextChangedListener(textWatcher);

    }
}