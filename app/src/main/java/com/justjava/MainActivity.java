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

    int numberOfCoffees = 0;    //Global Variable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    This method will call when the increment button clicked
    */
    public void incrementValue(View view) {
        numberOfCoffees = numberOfCoffees + 1;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
    }

    /*
    This method call when the decement button clicked
     */
    public void decrementValue(View view) {
        numberOfCoffees = numberOfCoffees - 1;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
    }

    /*
    This method will call when oder button clicked
    */
    public void submitOrder(View view) {
        display(numberOfCoffees);
        displayorderSubmit();
        displayPrice(numberOfCoffees * 5);
    }

    /*
    This method will reset every thing Quantity, Price
    */
    public void resetButton(View view) {
        numberOfCoffees = numberOfCoffees * 0;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees);
        displayclearOrderSubmittedView();
    }

    /*
    This function changes the value of quantity when clicked on order button
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_number);
        quantityTextView.setText("" + number);
    }

    /*
    This function shows "Order Submitted" at the bottom of the screen when clicked on order button
     */
    private void displayorderSubmit() {
        TextView orderSubmittedTextView = (TextView) findViewById(R.id.order_submitted);
        orderSubmittedTextView.setText("Order Submitted");
    }

    /*
    This function changes the value of Price when clicked on order button with the local currency format
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_number);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /*
    This function changes the value to reset
     */
    private void displayclearOrderSubmittedView() {
        TextView clearOrderSubmittedView = (TextView) findViewById(R.id.order_submitted);
        clearOrderSubmittedView.setText("");
    }

}

