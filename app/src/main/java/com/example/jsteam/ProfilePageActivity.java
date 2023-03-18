package com.example.jsteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jsteam.model.DatabaseConfiguration;
import com.example.jsteam.model.User;

public class ProfilePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        init();
    }

    private void init() {
        TextView usernameProfilePage = findViewById(R.id.tv_username_output_profile);
        TextView emailProfilePage = findViewById(R.id.tv_email_output_profile);
        TextView regionProfilePage = findViewById(R.id.tv_region_output_profile);
        TextView phoneProfilePage = findViewById(R.id.tv_phone_output_profile);
        Button logoutButton = findViewById(R.id.button_logout_profile_page);

        User userLoggedIn = DatabaseConfiguration.users.get(DatabaseConfiguration.findIndexUser(getIntent().getStringExtra("username")));

        String usernameText = userLoggedIn.getUsername();
        String emailText = userLoggedIn.getEmail();
        String regionText = userLoggedIn.getRegion();
        String phoneText = userLoggedIn.getPhoneNumber();

        usernameProfilePage.setText(usernameText);
        emailProfilePage.setText(emailText);
        regionProfilePage.setText(regionText);
        phoneProfilePage.setText(phoneText);

        logoutButton.setOnClickListener(view -> {
            Intent intent = new Intent(ProfilePageActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}