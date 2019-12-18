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

/*
This function will be called when the order button clicked.
*/
    public void submitOrder(View view) {
        int numberOfCoffees;
        numberOfCoffees = 3;
        display(numberOfCoffees);
        displayorderSubmit();
        displayPrice(numberOfCoffees * 5);
    }

/*
This function will be called for which xml id will be change.
*/
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_number);
        quantityTextView.setText("" + number);
    }

/*
This function will show the text "Order Submitted" in the bottom of screen
*/
    private void displayorderSubmit(){
        TextView orderSubmittedTextView = (TextView) findViewById(R.id.order_submitted);
        orderSubmittedTextView.setText("Order Submitted");
    }

/*
This function will show the price with the local currency format
For Example: For India it will be rupee symbol, like that for usa it will be dollar symbol.
*/
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_number);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}

