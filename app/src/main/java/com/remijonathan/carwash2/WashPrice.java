package com.remijonathan.carwash2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WashPrice extends AppCompatActivity {
    private TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_price);
        totalPrice = findViewById(R.id.total_price);

        totalPrice.setText(getIntent().getStringExtra("Price"));
    }
}
