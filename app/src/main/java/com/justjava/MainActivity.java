package com.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/*
This app display an order form of order coffee
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        int numberOfCoffees;
        numberOfCoffees = 3;
        display(numberOfCoffees);
        displayorderSubmit();
        displayPrice(numberOfCoffees * 5);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_number);
        quantityTextView.setText("" + number);
    }

    private void displayorderSubmit(){
        TextView orderSubmittedTextView = (TextView) findViewById(R.id.order_submitted);
        orderSubmittedTextView.setText("Order Submitted");
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_number);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}

