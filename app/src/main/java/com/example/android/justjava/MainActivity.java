package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

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
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateChecBox = (CheckBox)findViewById(R.id.Chocolate_checkBox);
        boolean hasChocolate = chocolateChecBox.isChecked();

        int price =calculatePrice();
        String priceMessage =createOrderSummary(name,price,hasWhippedCream,hasChocolate);
        displayMessage(priceMessage);



    }
/**
 * Calculates the price of the order.
 * @return total price
 *
 */
        private int calculatePrice( ) {return   quantity * 5 ;


        }
        private String createOrderSummary(String name ,int price,boolean addwhippedCream,boolean hasChocolate ){
            String priceMessage = "Name : " + name ;
            priceMessage = priceMessage +"\nQuantity : " + quantity ;
            priceMessage = priceMessage + "\nAdd Whipped Cream " +addwhippedCream;
            priceMessage = priceMessage + "\nAdd Chocolate " +hasChocolate;
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