package com.example.assignment1_s3863973;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    private TextView titleTextView, descriptionTextView;
    private ImageView imageView;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        titleTextView = findViewById(R.id.detail_title);
        descriptionTextView = findViewById(R.id.detail_description);
        imageView = findViewById(R.id.detail_image);

        db = FirebaseFirestore.getInstance();

        // Get the key from Intent
        String key = getIntent().getStringExtra("button_key");
        if (key != null) {
            fetchDetailFromFirebase(key);
        }
    }

    private void fetchDetailFromFirebase(String key) {
        db.collection("survival_tips").document(key).get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        String title = documentSnapshot.getString("title");
                        String description = documentSnapshot.getString("description");
                        String imageUrl = documentSnapshot.getString("imageUrl");

                        titleTextView.setText(title);
                        descriptionTextView.setText(description);
                        if (imageUrl != null) {
                            Picasso.get().load(imageUrl).into(imageView);
                        }
                    }
                })
                .addOnFailureListener(e -> descriptionTextView.setText("Failed to load data"));
    }
}