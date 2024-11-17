package com.example.assignment1_s3863973;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SurvivalTip> survivalTipsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load JSON data
        loadJsonData();

        // Set up button click listeners
        setButtonListener(findViewById(R.id.button_1), 0);
        setButtonListener(findViewById(R.id.button_2), 1);
        setButtonListener(findViewById(R.id.button_3), 2);
        setButtonListener(findViewById(R.id.button_4), 3);
        setButtonListener(findViewById(R.id.button_5), 4);
        setButtonListener(findViewById(R.id.button_6), 5);
    }

    private void loadJsonData() {
        survivalTipsList = new ArrayList<>();
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.survival_topics);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray survivalTipsArray = new JSONArray(json);

            // Populate the list with SurvivalTip objects
            for (int i = 0; i < survivalTipsArray.length(); i++) {
                JSONObject item = survivalTipsArray.getJSONObject(i);
                String title = item.getString("title");
                String description = item.getString("description");
                String imageResName = item.getString("imageResName");

                SurvivalTip survivalTip = new SurvivalTip(title, description, imageResName);
                survivalTipsList.add(survivalTip);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error loading JSON", Toast.LENGTH_SHORT).show();
        }
    }

    private void setButtonListener(Button button, int index) {
        button.setOnClickListener(v -> {
            if (index < survivalTipsList.size()) {
                SurvivalTip selectedTip = survivalTipsList.get(index);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("title", selectedTip.getTitle());
                intent.putExtra("description", selectedTip.getDescription());
                intent.putExtra("imageResName", selectedTip.getImageResName());
                startActivity(intent);
            }
        });
    }
}
