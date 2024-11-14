package com.example.assignment1_s3863973;

import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton button1 = findViewById(R.id.button_1);
        MaterialButton button2 = findViewById(R.id.button_2);
        MaterialButton button3 = findViewById(R.id.button_3);
        MaterialButton button4 = findViewById(R.id.button_4);
        MaterialButton button5 = findViewById(R.id.button_5);
        MaterialButton button6 = findViewById(R.id.button_6);

        // Set click listeners for each button
        button1.setOnClickListener(v -> navigateToDetail("surviving_hydroplaning"));
        button2.setOnClickListener(v -> navigateToDetail("surviving_knife_stab"));
        button3.setOnClickListener(v -> navigateToDetail("surviving_high_fall"));
        button4.setOnClickListener(v -> navigateToDetail("surviving_choking_alone"));
        button5.setOnClickListener(v -> navigateToDetail("escaping_fire"));
        button6.setOnClickListener(v -> navigateToDetail("surviving_fire"));

    }

    private void navigateToDetail(String key) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("button_key", key);
        startActivity(intent);
    }
}