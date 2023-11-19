package com.example.deliveryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.deliveryapplication.data.Country;
import com.example.deliveryapplication.data.UserInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SignupActivity extends AppCompatActivity {

    Button signupButton, loginButton;
    EditText prenom, nom, email, password, phoneNumber;
    boolean isAllFieldsChecked = false;

    Spinner spinner;
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

        spinner = findViewById(R.id.country_spinner);
        List<Country> items = new ArrayList<>();
        items.add(new Country(R.drawable.flag_sweden, "Sweden"));
        items.add(new Country(R.drawable.flag_algeria, "Algeria"));
        CountryAdapter countryAdapter  = new CountryAdapter(this,items);

        spinner.setAdapter(countryAdapter);


        // start LoginActivity when loginButton is clicked
        Intent loginIntent = new Intent(this, LoginActivity.class);
        loginButton.setOnClickListener(v -> startActivity(loginIntent));
        // start ProfileActivity when signupButton is clicked
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        signupButton.setOnClickListener(v -> {
            // check if all fields are filled
            isAllFieldsChecked = validateSignupForm();
            if (isAllFieldsChecked) {
                // create a new UserInfo object
                UserInfo userInfo = new UserInfo(prenom.getText().toString(), nom.getText().toString(),
                        email.getText().toString(), password.getText().toString(), phoneNumber.getText().toString());
                // add the UserInfo object to the intent
                profileIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                profileIntent.putExtra("userInfo", (Serializable) userInfo);
                // start ProfileActivity
                startActivity(profileIntent);
            }
        });
    }

    private boolean validateSignupForm(){
        if (nom.getText().toString().length()==0){
            nom.setError("Please enter your last name");
            return false;
        }
        if (prenom.getText().toString().length()==0){
            prenom.setError("Please enter your first name");
            return false;
        }
        if (email.getText().toString().length()==0){
            email.setError("Please enter your email");
            return false;
        }
        if (password.getText().toString().length()==0|| password.getText().toString().length()<8){
            password.setError("Please enter your password");
            return false;
        }
        if (phoneNumber.getText().toString().length()==0){
            phoneNumber.setError("Please enter your phone number");
            return false;
        }
        return true;
    }
}
