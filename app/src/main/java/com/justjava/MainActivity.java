package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffee = 0;
    String totalPriceText;
    String thankYouString;
    String totalQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method call is order submit button.
     * since it is void no return statement.
     *
     * @param view
     */
    public void submitOrder(View view) {

        // Find the EditText name view.
        EditText userName = (EditText) findViewById(R.id.enter_user_name);
        // Set the Value after getting from the user to String assigned in getUserName.
        String getUserName = userName.getText().toString();

        // Check weather the User checked the whipped cream checkBox.
        CheckBox checkWhippedCream = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = checkWhippedCream.isChecked();

        // Check weather the User checked the chocolate cream checkbox.
        CheckBox checkChocolateCream = (CheckBox) findViewById(R.id.chocolate_cream);
        boolean hasChocolateCream = checkChocolateCream.isChecked();

        // It calculate the total price in its assigned class calculatePrice.
        int price = calculatePrice(numberOfCoffee, 5, hasWhippedCream, hasChocolateCream);

        totalQuantity = "Total Quantity : " + numberOfCoffee;
        totalPriceText = "Total Price ";
        thankYouString = "Thank You!";

        //This will call the Order Summary method which is createOrderSummary.
        String createOrderSummary = createOrderSummary(getUserName,
                totalQuantity,
                hasWhippedCream,
                hasChocolateCream,
                totalPriceText,
                price,
                thankYouString);

        display(numberOfCoffee);
        displayOrderSummary(createOrderSummary);
    }

    /**
     * This method is for Order Summary.
     * <p>
     * This method shows order summary for example: User Name, Quantity picked by User,
     * Whipped Cream weather User wants to add it or not, Chocolate Cream weather User wants to add
     * it or not, Or weather user wants both, Price according to the User selected the amount of
     * quantity and toppings and "Thank You!" note.
     *
     * @param name         this param shows customer name.
     * @param quantity     this param shows the total quantity of order summary.
     * @param whipTopping  this param checks weather user has checked the Whipped Cream or not.
     * @param chocoTopping this param checks weather user has checked the Chocolate Cream or not.
     * @param priceText    this param shows the total price of order summary.
     * @param thankYouNote this param shows the thank you note in order summary.
     * @return it returns the value of orderSummary.
     */
    public String createOrderSummary(String name,
                                     String quantity,
                                     boolean whipTopping,
                                     boolean chocoTopping,
                                     String priceText,
                                     int price,
                                     String thankYouNote) {
        String orderSummary = "Name: " + name +
                "\n" + quantity +
                "\n" + "WhippedCream? " + whipTopping +
                "\n" + "ChocolateCream? " + chocoTopping +
                "\n" + priceText + ": $" + price +
                "\n" + thankYouNote;

        return orderSummary;
    }

    /**
     * (+) button that will increase the quantity value.
     * <p>
     * since it is void no return statement.
     *
     * @param view
     */
    public void increaseQuantity(View view) {

        numberOfCoffee = numberOfCoffee + 1;

        displayIncrementDecrement(numberOfCoffee);
        displayPriceLiveCount(numberOfCoffee * 5);
    }

    /**
     * (-) button that will decrease the quantity value.
     * <p>
     * since it is void no return statement.
     *
     * @param view
     */
    public void decreaseQuantity(View view) {

        numberOfCoffee = numberOfCoffee - 1;

        displayIncrementDecrement(numberOfCoffee);
        displayPriceLiveCount(numberOfCoffee * 5);
    }

    /**
     * This method decides weather user has selected the Toppings or not!
     *
     * @param view This is view.
     */
    /*
    public void toppings(View view) {
        // Get the value of weather the CheckBox is clicked or not!
        boolean checked = ((CheckBox) view).isChecked();
        String whippedCream;
        String chocolateCream;

        // Check which one or all of them is checked!!
        switch (view.getId()) {
            case R.id.whipped_cream:
                if (checked)
                    // Whipped cream add;
                    whippedCream = "Whipped Cream? Yes!";
                else
                    // Whipped cream don't add;
                    whippedCream = "Whipped Cream? No!";

                break;

            case R.id.chocolate_cream:
                if (checked)
                    // Add chocolate cream;
                    chocolateCream = "Chocolate Cream? Yes!";
                else
                    // Don't add Chocolate Cream.
                    chocolateCream = "Chocolate Cream? No!";

                break;
            // TODO: Simple Coffee
        }
    }
    */

    /**
     * Creating a method call here calculatePrice.
     * <p>
     * This method calculates the total price.
     *
     * @param addWhippedCream is whether the user wants the whipped cream topping.
     * @param addChocolateCream is whether the user wants the chocolate topping.
     * @param calculateThePrice is the quantity.
     * @param pricePerCup       is the price of per cup of coffee.
     * @return price            It returns the total price value as calculatePrice.
     */
    private int calculatePrice(int calculateThePrice,
                               int pricePerCup,
                               boolean addWhippedCream,
                               boolean addChocolateCream) {


        // If checked Whipped Topping price will be added to the Price.
        if (addWhippedCream) {
            int whippedCreamPrice = 1;
            pricePerCup = pricePerCup + whippedCreamPrice;
        }

        // If checked Chocolate Topping price will be added to the Price.
        if (addChocolateCream) {
            int chocolateCreamPrice = 2;
            pricePerCup = pricePerCup + chocolateCreamPrice;
        }

        return calculateThePrice * pricePerCup;
    }

    /**
     * This method call resets the all the value of the app.
     * since it is void no return statement.
     *
     * @param view
     */
    public void resetOrder(View view) {

        numberOfCoffee = numberOfCoffee * 0; // Reset the number of coffee value to 0

        //  Get the view ID if EditText.
        EditText clearEditText = (EditText) findViewById(R.id.enter_user_name);
        // Clear the Text on EditText.
        clearEditText.setText("");

        // Resets the Whipped Cream CheckBox
        CheckBox checkWhippedCream = (CheckBox) findViewById(R.id.whipped_cream);
        checkWhippedCream.setChecked(false); //Set the value to false to uncheck the CheckBox

        // Resets the Chocolate Cream CheckBox
        CheckBox checkChocolateCream = (CheckBox) findViewById(R.id.chocolate_cream);
        checkChocolateCream.setChecked(false); //Set the value to false to uncheck the CheckBox

        // Reset the Number of Coffee
        display(numberOfCoffee);

        // Resets the Price as Quantity goes to 0
        displayPriceLiveCount(numberOfCoffee * 5);

        // Resets the Order Summary
        displayOrderSummary("");
    }

    /**
     * This function called by submitOrder, resetOrder methods.
     * <p>
     * It updates the quantity value on screen.
     *
     * @param order
     */
    private void display(int order) {
        TextView quantity = (TextView) findViewById(R.id.quantity_number);
        quantity.setText("" + order);
    }

    /**
     * This function called by submitOrder, resetOrder method.
     * <p>
     * It displays the order summary on the screen after order button is clicked.
     *
     * @param orderSummaryView displays the order details when clicked Order Button.
     */
    private void displayOrderSummary(String orderSummaryView) {
        TextView orderSummary = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummary.setText("" + orderSummaryView);
    }

    /**
     * This function called by increaseQuantity(), decreaseQuantity() method.
     * <p>
     * It increases/decreases the quantity number after clicked on plus/minus button.
     *
     * @param incrementDecrement increases/decreases the quantity value.
     */
    private void displayIncrementDecrement(int incrementDecrement) {
        TextView quantityIncrement = (TextView) findViewById(R.id.quantity_number);
        quantityIncrement.setText("" + incrementDecrement);
    }

    /**
     * This function called by increaseQuantity(), decreaseQuantity() and resetOrder() method.
     * <p>
     * It shows the live value of price at the same time of quantity increases or decreases or gets
     * reset.
     *
     * @param priceLiveCount shows the live price as number of coffee increases or decreases or gets
     *                       reset.
     */
    private void displayPriceLiveCount(int priceLiveCount) {
        TextView priceDecrease = (TextView) findViewById(R.id.price);
        priceDecrease.setText(NumberFormat.getCurrencyInstance().format(priceLiveCount));
    }
}
