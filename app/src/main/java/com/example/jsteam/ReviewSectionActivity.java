package com.example.jsteam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.jsteam.databinding.ActivityReviewSectionBinding;
import com.example.jsteam.model.Review;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Vector;

public class ReviewSectionActivity extends AppCompatActivity {
    private ActivityReviewSectionBinding binding;
    private Vector<Review> reviews = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityReviewSectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view_review_section);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_game_page, R.id.navigation_review_section, R.id.navigation_profile_section)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_review_section);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navViewReviewSection, navController);
    }
}