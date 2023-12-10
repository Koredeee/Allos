package com.example.allos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.allos.database.Connect;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText usernameEditText;
    EditText passwordEditText;
    EditText emailEditText;

    Button registerButton;

    Connect db = Connect.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = usernameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (v == registerButton){
//            if (username == null || username.isEmpty() || password == null || password.isEmpty()){
//                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Register successful", Toast.LENGTH_SHORT).show();
//
//            }

            String query = String.format("INSERT INTO `user`(`Username`, `Password`, `Email`)"
                    + "VALUES ('%s','%s','%s')", username, password, email);
            db.execute(query);
            Toast.makeText(this, "Register successful", Toast.LENGTH_SHORT).show();
        }
    }
}