package com.example.android.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_WORD = "com.example.android.newsapp.KEY_WORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView worldNewsSection = (ImageView) findViewById(R.id.worldNewsSection);

        worldNewsSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StoryActivity.class);
                intent.putExtra(EXTRA_KEY_WORD, getString(R.string.world_news_value));
                startActivity(intent);
            }
        });

        LinearLayout fashionSection = (LinearLayout) findViewById(R.id.fashionSection);
        fashionSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StoryActivity.class);
                intent.putExtra(EXTRA_KEY_WORD, getString(R.string.fashion_value));
                startActivity(intent);
            }
        });

        LinearLayout sportSection = (LinearLayout) findViewById(R.id.sportSection);
        sportSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StoryActivity.class);
                intent.putExtra(EXTRA_KEY_WORD, getString(R.string.sport_value));
                startActivity(intent);
            }
        });
    }
}
