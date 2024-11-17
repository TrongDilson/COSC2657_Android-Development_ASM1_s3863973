package com.example.assignment1_s3863973;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView descriptionTextView;
    private ImageView detailImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Initialize views
        titleTextView = findViewById(R.id.detail_title);
        descriptionTextView = findViewById(R.id.detail_description);
        detailImageView = findViewById(R.id.detail_image);

        // Get data from intent
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String imageResName = getIntent().getStringExtra("imageResName");

        // Set data to views
        titleTextView.setText(title);
        descriptionTextView.setText(description);

        // Load GIF image using Glide
        int imageResId = getResources().getIdentifier(imageResName, "drawable", getPackageName());
        Glide.with(this)
                .asGif()
                .load(imageResId)
                .into(detailImageView);
    }
}
