package com.example.jsteam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class GamesDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_games_detail);

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
        TextView gameName = findViewById(R.id.tv_title_game_on_game_detail_page);
        TextView gameGenre = findViewById(R.id.tv_genre_name_game_on_game_detail_page);
        TextView gameRating = findViewById(R.id.tv_rating_value_game_on_game_detail_page);
        TextView gamePrice = findViewById(R.id.tv_price_value_game_on_game_detail_page);
        TextView gameDescription = findViewById(R.id.tv_description_game_on_game_detail_page);

        String gameNameText = getIntent().getStringExtra("gameName");
        String gameGenreText = getIntent().getStringExtra("gameGenre");
        String gameRatingText = getIntent().getStringExtra("gameRating");
        String gamePriceText = getIntent().getStringExtra("gamePrice");
        String gameDescriptionText = getIntent().getStringExtra("gameDescription");

        gameName.setText(gameNameText);
        gameGenre.setText(gameGenreText);
        gameRating.setText(gameRatingText);
        gamePrice.setText("Rp." + gamePriceText);
        gameDescription.setText(gameDescriptionText);
    }
}