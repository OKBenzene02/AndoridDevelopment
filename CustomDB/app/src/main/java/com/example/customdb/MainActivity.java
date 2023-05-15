package com.example.customdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email, user;
    private Button submit;
    private SQLHelper dbOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.nameText);
        email = (EditText) findViewById(R.id.emailText);
        submit = (Button) findViewById(R.id.submit);
        dbOperations = new SQLHelper(MainActivity.this);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String userName = user.getText().toString();
                String emailText = user.getText().toString();
                if (userName.isEmpty() && emailText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your details...", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbOperations.addNewUser(userName, emailText);
                Toast.makeText(MainActivity.this, "User is added successfully", Toast.LENGTH_SHORT).show();
                user.setText(""); email.setText("");
            }
        });


    }
}