package com.example.jsteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jsteam.model.DatabaseConfiguration;

/**
 * @author kareltan
 */
public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_about_us);
        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private void init() {
        Button submitReview = findViewById(R.id.button_submit_about_us);

        submitReview.setOnClickListener(view -> {
            Toast.makeText(AboutUsActivity.this, "Thanks for supporting JSteam!", Toast.LENGTH_SHORT).show();
            Intent intentHome = new Intent(AboutUsActivity.this, HomePageActivity.class);
            intentHome.putExtra("username", getIntent().getStringExtra("username"));
            startActivity(intentHome);
        });
    }
}