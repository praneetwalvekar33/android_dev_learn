
/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.coffeeapp;



         import android.content.Intent;
         import android.net.Uri;
         import android.os.Bundle;
        import androidx.appcompat.app.AppCompatActivity;
         import android.view.View;
         import android.widget.CheckBox;
         import android.widget.EditText;
         import android.widget.TextView;
         import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    static int quantity=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Creates an object for CheckBox for Whipped Cream
        CheckBox checkBoxWhippedCream = (CheckBox) findViewById(R.id.whipped_cream_toppings);

        // Creates an object for CheckBox for Whipped Cream
        CheckBox checkBoxChocolate = (CheckBox) findViewById(R.id.chocolate_toppings);

        //Object created to store the content in the EditText bar.
        EditText nameOfCustomer = (EditText) findViewById(R.id.name_customer);

        //Variable to store the price of single cup of coffee
        int priceOfSinglecup = singleCupOfCoffee(checkBoxWhippedCream.isChecked(), checkBoxChocolate.isChecked());

        //Variable to calculate price of an order.
        int price = quantity * priceOfSinglecup;

        //Variable to store the order summary
        String priceMessage = orderSummary(price, checkBoxWhippedCream.isChecked(), checkBoxChocolate.isChecked(), nameOfCustomer.getText());

        //Variable to contain the subject of mail
        String subj = "The Order Summary of " + nameOfCustomer.getText();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, subj);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    /**
     * This method is called when increment button is clicked. To increase the quantity.
     */
    public void increament(View view)
    {
        quantity++;
        display(quantity);
    }

    /**
     *This method is called when the decrement button is clicked. To decrease the quantity.
     */
    public void decreament(View view)
    {
        if(quantity!=0) {
            quantity--;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Function Calculate price of single cup of coffee
     */
    private int singleCupOfCoffee(boolean whippedCream, boolean chocolate){
        int priceWhippedCream = 1;
        int priceChocolate = 2;
        int priceForSingleCup = 0;
        if(whippedCream && chocolate){
            priceForSingleCup = 5 + priceWhippedCream + priceChocolate;
        }
        else if(whippedCream && !(chocolate)){
            priceForSingleCup = 5 + priceWhippedCream;
        }
        else if(!(whippedCream) && chocolate){
            priceForSingleCup = 5 + priceChocolate;
        }
        else{
            priceForSingleCup = 5;
        }
        return priceForSingleCup;
    }

    /**
     * This function gives summary of the order
     */
    private String orderSummary(int price, boolean checkedWhippedCream, boolean checkedChocolate, android.text.Editable nameOfCustomer){
        String priceMessage = "Name: " + nameOfCustomer;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nDo you want Whipped Cream toppings? " + checkedWhippedCream;
        priceMessage += "\nand Chocolate? " + checkedChocolate;
            priceMessage += "\n`Total Price: $`" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }


}