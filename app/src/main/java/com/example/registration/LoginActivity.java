package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user,pass;
    Button login;
    String correct_username = "student1";
    String correct_password = "123456";
    public static String studentName="";
   // public static String name="Sai";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.userName);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.loginBtn);
        login.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        String verify = verifyLogin(user.getText().toString(), pass.getText().toString());
        if (verify.isEmpty())
            Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
        else if (user.getText().toString().equals(correct_username)) {
            if (pass.getText().toString().equals(correct_password)) {
                //Toast.makeText(getApplicationContext(), "successfully loggedin", Toast.LENGTH_LONG).show();

                studentName = verify;
                //navigate to the MainActivity
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            }
        }


    }

    public String verifyLogin(String toString, String toString1) {
        return toString;
    }

}
