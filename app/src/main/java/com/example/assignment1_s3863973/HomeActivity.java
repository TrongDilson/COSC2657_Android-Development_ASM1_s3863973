package com.example.assignment1_s3863973;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import androidx.appcompat.app.AlertDialog;
import android.content.Intent;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MaterialButton infoButton = findViewById(R.id.infoButton);
        Button nextButton = findViewById(R.id.nextButton);

        infoButton.setOnClickListener(v -> {
            new AlertDialog.Builder(HomeActivity.this)
                    .setTitle("About")
                    .setMessage("Name: Tran Vinh Trong\nSid: s3863973\nCourse: COSC2657 | Android Development\n\nDescription:\nThis app is meant to spread awareness on how to survive extreme hazards if this ever happen to an individual.")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        // Navigate to MainActivity
        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
