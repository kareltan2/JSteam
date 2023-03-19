package com.example.jsteam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;

import com.example.jsteam.Adapter.ReviewSectionAdapter;
import com.example.jsteam.databinding.ActivityReviewSectionBinding;
import com.example.jsteam.model.DatabaseConfiguration;
import com.example.jsteam.model.Review;
import com.example.jsteam.ui.review_section.ReviewSectionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
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