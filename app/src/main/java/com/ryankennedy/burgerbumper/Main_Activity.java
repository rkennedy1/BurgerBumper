package com.ryankennedy.burgerbumper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main_Activity extends AppCompatActivity {

    private TextView textView;
    private ImageButton burger;
    private ImageView image;
    private int i = 0;
    private Button store;
    private int multiplier = 1;
    private TextView burgerPerTap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        image = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.Burgers);
        burger = (ImageButton) findViewById(R.id.imageButton);
        store = (Button) findViewById(R.id.storeButton);
        burgerPerTap = (TextView) findViewById(R.id.BurgersPerTap);

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // update view when continue is pressed
                i = i + multiplier;
                textView.setText("Burgers: " + i);
                if(i >= 5000) {
                    image.setBackgroundResource(R.drawable.easteregg);
                }
            }

        });
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i - 10*multiplier >= 0) {
                    i = i - (10 * multiplier);
                    textView.setText("Burgers: " + i);
                    multiplier++;
                    store.setText("Spend " + 10 * multiplier + " burgers for +1 Burger per tap");
                    burgerPerTap.setText("Burgers per Tap: " + multiplier);
                } else {
                    Toast.makeText(getApplicationContext(), "You do not have enough burgers!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
