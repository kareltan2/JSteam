package com.example.jsteam;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.jsteam.Adapter.GamePageAdapter;
import com.example.jsteam.databinding.ActivityHomePageBinding;
import com.example.jsteam.model.DatabaseConfiguration;
import com.example.jsteam.model.Game;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;


public class HomePageActivity extends AppCompatActivity {

    private ActivityHomePageBinding binding;
    private RecyclerView recyclerViewGamesPageList;
    private Vector<Game> gamesListVector = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_game_page, R.id.navigation_review_section, R.id.navigation_profile_section)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_home_page);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        init();
    }

    private void init(){
        recyclerViewGamesPageList = findViewById(R.id.rv_game_page_list);

        recyclerViewGamesPageList.setAdapter(new GamePageAdapter(this, DatabaseConfiguration.games));
        recyclerViewGamesPageList.setLayoutManager(new LinearLayoutManager(this));
        BottomNavigationItemView gamePageButton = findViewById(R.id.navigation_game_page);
        BottomNavigationItemView reviewSectionButton = findViewById(R.id.navigation_review_section);
        BottomNavigationItemView profileSection = findViewById(R.id.navigation_profile_section);

        gamePageButton.setOnClickListener(view -> {
            Intent intent = new Intent(HomePageActivity.this, HomePageActivity.class);
            startActivity(intent);
        });

        //TODO: create review activity
//        reviewSectionButton.setOnClickListener(view -> {
//            Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
//            startActivity(intent);
//        });

    }

}