package com.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/*
This app display an order form of order coffee
*/

public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 0;    //Global Variable;
    String orderSubmitView;     //Global Variable;
    String totalPriceView;      //Global Variable;
    String thankYouView;        //Global Variable;

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
        orderSubmitView = "Order Submitted";
        totalPriceView = "Total Price : ";
        thankYouView = "Thank You!";
        display(numberOfCoffees);
        displaytotalPrice(totalPriceView);
        displaytotalPriceValue(numberOfCoffees * 5);
        displaythankYou(thankYouView);
        displayorderSubmit(orderSubmitView);
        displayPrice(numberOfCoffees * 5);
    }

    /*
    This method will reset every thing Quantity, Price
    */
    public void resetButton(View view) {
        numberOfCoffees = numberOfCoffees * 0;
        totalPriceView = "";
        thankYouView = "";
        orderSubmitView = "";
        display(numberOfCoffees);
        displayPrice(numberOfCoffees);
        displaytotalPrice(totalPriceView);
        displaytotalPriceValue();
        displaythankYou(thankYouView);
        displayorderSubmit(orderSubmitView);
    }

    /*
    This function changes the value of quantity when clicked on order button
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_number);
        quantityTextView.setText("" + number);
    }

    /*
    This function changes the value of Price when clicked on order button with the local currency format
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_number);
        priceTextView.setText(NumberFormat.getCurrencyInstance(Locale.US).format(number));
    }

    /*
    This function shows Text "Total Price"
     */
    private void displaytotalPrice(String message) {
        TextView totalPriceView = (TextView) findViewById(R.id.total_price);
        totalPriceView.setText(message);
    }

    /*
    This function shows Total Price "Value"
     */
    private void displaytotalPriceValue(int number) {
        TextView totalPriceValueView = (TextView) findViewById(R.id.total_price_value);
        totalPriceValueView.setText(NumberFormat.getCurrencyInstance(Locale.US).format(number));
    }

    private void displaytotalPriceValue() {
        TextView clearTotalPriceValue = (TextView) findViewById(R.id.total_price_value);
        clearTotalPriceValue.setText("");
    }

    /*
    This function shows Text "Thank You"
     */
    private void displaythankYou(String message) {
        TextView thankYouView = (TextView) findViewById(R.id.thank_you);
        thankYouView.setText(message);
    }

    /*
    This function shows "Order Submitted" at the bottom of the screen when clicked on order button
     */
    private void displayorderSubmit(String message) {
        TextView orderSubmittedTextView = (TextView) findViewById(R.id.order_submitted);
        orderSubmittedTextView.setText(message);
    }

}

