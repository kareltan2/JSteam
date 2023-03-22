package com.example.jsteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jsteam.model.DatabaseConfiguration;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kareltan
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        testingConfiguration();
        AtomicInteger index = new AtomicInteger();
        Button loginButton = findViewById(R.id.button_login_login_page);
        TextView notHaveAccountText = findViewById(R.id.tv_didnt_have_account);
        EditText usernameLoginPage = findViewById(R.id.pt_username_login);
        EditText passwordLoginPage = findViewById(R.id.pt_password_login);

        loginButton.setOnClickListener(view -> {
            String username = String.valueOf(usernameLoginPage.getText());
            String password = String.valueOf(passwordLoginPage.getText());

            if(validationNotEmpty(username, password)){
                index.set(DatabaseConfiguration.findIndexUser(username));
                validationAccount(index, password);
            }

        });

        notHaveAccountText.setOnClickListener(view -> {
            Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        });

    }

    private void testingConfiguration() {
        //testing purpose
        DatabaseConfiguration.DatabaseUser(0, "kareltan", "dongo", "karel.tan@gmail.com", "INDO", "085211999998");
        DatabaseConfiguration.DatabaseGame("Mobile Legend", "War Games Explorer", 4.9F, 90000, "A war games with free superior hero skin");
        DatabaseConfiguration.DatabaseGame("League of Legend", "War Games Explorer", 4.9F, 90000, "A war games with free superior hero skin");
        DatabaseConfiguration.DatabaseGame("Clash of Clans", "War Games Explorer", 4.9F, 90000, "A war games with free superior hero skin");
        DatabaseConfiguration.DatabaseGame("Among Us", "Tactical Games", 4.9F, 1000000, "A tactical games and multiplayer game");
        DatabaseConfiguration.DatabaseReview("Mobile Legend", "a very good game with extraordinary experience and UI", "kareltan");
        DatabaseConfiguration.DatabaseReview("League of Legend", "a very good game with extraordinary experience and UI", "kareltan");
        DatabaseConfiguration.DatabaseReview("Mobile Legend", "a very good game with extraordinary experience and UI", "kareltan3");
    }

    private boolean validationNotEmpty(String username, String password) {
        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(MainActivity.this, "Email or password cannot be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validationAccount(AtomicInteger index, String password) {
        if(index.get() != -1){
            if(!DatabaseConfiguration.users.get(index.get()).getPassword().equals(password)){
                Toast.makeText(MainActivity.this, "Wrong Password!", Toast.LENGTH_SHORT).show();
                return false;
            }
            else {
                Toast.makeText(MainActivity.this, "Successfully Login!", Toast.LENGTH_SHORT).show();
                Intent intentHome = new Intent(MainActivity.this, HomePageActivity.class);
                intentHome.putExtra("username", DatabaseConfiguration.users.get(index.intValue()).getUsername());
                startActivity(intentHome);
                return true;
            }
        }

        Toast.makeText(MainActivity.this, "Unregistered User! Please register first!", Toast.LENGTH_SHORT).show();
        return false;
    }

}