package com.remijonathan.carwash2;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText washAmount;
    private RadioGroup washGroup;
    private RadioButton outWash;
    private RadioButton inWash;
    private Button calculatePrice;
    private TextView totalPrice;

    private Wash wash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        washAmount = findViewById(R.id.washes_wanted);
        washGroup = findViewById(R.id.wash_group);
        outWash = findViewById(R.id.outside_wash);
        inWash = findViewById(R.id.inside_out_wash);
        calculatePrice = findViewById(R.id.calculate_price);
        totalPrice = findViewById(R.id.total_price);

        wash = new Wash();

        calculatePrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatePrice();
            }
        });

        washGroup.setOnCheckedChangeListener(washTypeListener);

    }

    private RadioGroup.OnCheckedChangeListener washTypeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.inside_out_wash:
                    wash.setPrice(wash.INWASH);
                    break;
                case R.id.outside_wash:
                    wash.setPrice(wash.OUTWASH);
                    break;
            }
        }
    };


    private void calculatePrice() {

        //Validate that a value is in amount
        if (washAmount.getText().toString().length() != 0) {

            int amount = Integer.parseInt(washAmount.getText().toString());
            wash.setAmount(amount);

            String price = NumberFormat.getCurrencyInstance().format(wash.getTotalPrice());
            totalPrice.setText(price);
        } else emptyNumberException();
    }

    private void emptyNumberException() {
        Toast.makeText(getApplicationContext(), "Amount field cannot be empty", Toast.LENGTH_LONG).show();
    }
}
