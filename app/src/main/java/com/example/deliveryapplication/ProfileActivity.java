package com.example.deliveryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.deliveryapplication.data.UserInfo;

public class ProfileActivity extends AppCompatActivity {
    TextView prenom, nom, email, phoneNumber, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        UserInfo userInfo = (UserInfo) getIntent().getSerializableExtra("userInfo");
        // display the user's information
        prenom = findViewById(R.id.profile_last_name);
        nom = findViewById(R.id.profile_name);
        email = findViewById(R.id.profile_email);
        password = findViewById(R.id.profile_password);
        phoneNumber = findViewById(R.id.profile_phone);
        prenom.setText(userInfo.getPrenom());
        nom.setText(userInfo.getNom());
        email.setText(userInfo.getEmail());
        password.setText(userInfo.getPassword());
        phoneNumber.setText(userInfo.getPhoneNumber());

    }
}