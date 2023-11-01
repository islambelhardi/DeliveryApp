package com.example.deliveryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.deliveryapplication.data.UserInfo;

import java.io.Serializable;

public class SignupActivity extends AppCompatActivity {

    Button signupButton, loginButton;
    EditText prenom, nom, email, password, phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        loginButton = findViewById(R.id.login_button);
        signupButton = findViewById(R.id.signup_button);
        prenom = findViewById(R.id.signup_last_name);
        nom = findViewById(R.id.signup_name);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        phoneNumber = findViewById(R.id.signup_phone);

        // start LoginActivity when loginButton is clicked
        Intent loginIntent = new Intent(this, LoginActivity.class);
        loginButton.setOnClickListener(v -> startActivity(loginIntent));
        // start ProfileActivity when signupButton is clicked
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        signupButton.setOnClickListener(v -> {
            // create a new UserInfo object
            UserInfo userInfo = new UserInfo(prenom.getText().toString(), nom.getText().toString(),
                    email.getText().toString(), password.getText().toString(), phoneNumber.getText().toString());
            // add the UserInfo object to the intent
            profileIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            profileIntent.putExtra("userInfo", (Serializable) userInfo);
            // start ProfileActivity
            startActivity(profileIntent);
        });
    }
}
