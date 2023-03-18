package com.example.jsteam;

import androidx.appcompat.app.AppCompatActivity;
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

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_game_page, R.id.navigation_review_section, R.id.navigation_profile_section)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_review_section);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        init();
    }

    private void init(){
        RecyclerView recyclerViewReviewSectionList;
        recyclerViewReviewSectionList = findViewById(R.id.rv_review_section_list);

        recyclerViewReviewSectionList.setAdapter(new ReviewSectionAdapter(this, DatabaseConfiguration.reviews));
        recyclerViewReviewSectionList.setLayoutManager(new LinearLayoutManager(this));
        BottomNavigationItemView gamePageButton = findViewById(R.id.navigation_game_page);
        BottomNavigationItemView reviewSectionButton = findViewById(R.id.navigation_review_section);
        BottomNavigationItemView profileSection = findViewById(R.id.navigation_profile_section);

        gamePageButton.setOnClickListener(view -> {
            Intent intent = new Intent(ReviewSectionActivity.this, HomePageActivity.class);
            startActivity(intent);
        });

        reviewSectionButton.setOnClickListener(view -> {
            Intent intent = new Intent(ReviewSectionActivity.this, ReviewSectionActivity.class);
            startActivity(intent);
        });

        //TODO: Profile Section Button
//        profileSection.setOnClickListener(view -> {
//            Intent intent = new Intent(ReviewSectionActivity.this, MainActivity.class);
//            startActivity(intent);
//        });

    }
}