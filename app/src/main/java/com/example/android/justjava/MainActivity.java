package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {

        Toast.makeText(this, "you cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
        return;
    }

        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1){

        Toast.makeText(this, "you cannot have less than 1 coffees", Toast.LENGTH_SHORT).show();
        return;
    }

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

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage =createOrderSummary(name,price,hasWhippedCream,hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "just java orders for " + name );
        intent.putExtra(Intent.EXTRA_TEXT,   priceMessage );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }









    }
/**
 * Calculates the price of the order.
 * @return total price
 *
 */
        private int calculatePrice(boolean addWhippedCream,boolean addChocolate) {
            int basePrice = 5;
            if (addWhippedCream){
                basePrice = basePrice+1;
            }
            if (addChocolate){
                basePrice =basePrice +3;
            }


            return   quantity * basePrice ;

        }

        private String createOrderSummary(String name ,int price,boolean addwhippedCream,boolean hasChocolate ){
            String priceMessage = "Name : " + name ;
            priceMessage = priceMessage +"\nQuantity : " + quantity ;
            priceMessage = priceMessage + "\nAdd Whipped Cream " +addwhippedCream;
            priceMessage = priceMessage + "\nAdd Chocolate " +hasChocolate;
            priceMessage = priceMessage +  "\nTotal: $ " + price ;
            priceMessage = priceMessage +  "\n SUKRIA THOSSNY K LIYE ";
            priceMessage = priceMessage + " \n Zabi-developer@gmail.com " ;
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







    }