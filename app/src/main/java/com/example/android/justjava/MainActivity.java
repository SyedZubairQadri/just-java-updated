package com.example.android.justjava;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

int quantity = 2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);


    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        displayMessage(createOrderSummary(calculatePrice()));

    }
/**
 * Calculates the price of the order.
 * @return total price
 *
 */
        private int calculatePrice( ) {
           return   quantity * 5 ;


        }
        private String createOrderSummary(int price ){
            String priceMessage = "Name :Syed Zubair Qadri" ;
            priceMessage = priceMessage +"\nQuantity : " + quantity ;
            priceMessage = priceMessage +  "\nTotal: $ " + calculatePrice() ;
            priceMessage = priceMessage +  "\n SUKRIA PINY K LIYE ";
            priceMessage = priceMessage + " \nTHANK YOU FOR OUR DHANDA :D :D " ;
            return priceMessage;
        }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void display (int number ) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView order_summary_text_view = (TextView) findViewById(R.id.order_summary_text_view);
        order_summary_text_view.setText(message);
    }






    }