package edu.orangecoastcollege.cs273.kdo94.inandout;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    private EditText doubleEditText;
    private EditText cheeseEditText;
    private EditText friesEditText;
    private EditText shakesEditText;
    private EditText sodaSmallEditText;
    private EditText sodaMediumEditText;
    private EditText sodaLargeEditText;

    private TextView doubleCostTextView;
    private TextView cheeseCostTextView;
    private TextView friesCostTextView;
    private TextView shakesCostTextView;
    private TextView sodaSmallCostTextView;
    private TextView sodaMediumCostTextView;
    private TextView sodaLargeCostTextView;

    private Order currentOrder;

    private String totalText;
    private String totalSummary;

    private double cheeseCost;
    private double doubleCost;
    private double friesCost;
    private double shakesCost;
    private double smallCost;
    private double mediumCost;
    private double largeCost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        doubleEditText = (EditText) findViewById(R.id.doubleEditText);
        cheeseEditText = (EditText) findViewById(R.id.cheeseEditText);
        friesEditText = (EditText) findViewById(R.id.friesEditText);
        shakesEditText = (EditText) findViewById(R.id.shakesEditText);
        sodaSmallEditText = (EditText) findViewById(R.id.sodaSmallEditText);
        sodaMediumEditText = (EditText) findViewById(R.id.sodaMediumEditText);
        sodaLargeEditText = (EditText) findViewById(R.id.sodaLargeEditText);

        doubleCostTextView = (TextView) findViewById(R.id.doubleCostTextView);
        cheeseCostTextView = (TextView) findViewById(R.id.cheeseCostTextView);
        friesCostTextView = (TextView) findViewById(R.id.friesCostTextView);
        shakesCostTextView = (TextView) findViewById(R.id.shakesCostTextView);
        sodaSmallCostTextView = (TextView) findViewById(R.id.sodaSmallCostTextView);
        sodaMediumCostTextView = (TextView) findViewById(R.id.sodaMediumCostTextView);
        sodaLargeCostTextView = (TextView) findViewById(R.id.sodaLargeCostTextView);

        currentOrder = new Order();

        doubleCostTextView.setText(currency.format(currentOrder.PRICE_DOUBLE_DOUBLE).toString());
        cheeseCostTextView.setText(currency.format(currentOrder.PRICE_CHEESEBURGER).toString());
        friesCostTextView.setText(currency.format(currentOrder.PRICE_FRENCH_FRIES).toString());
        shakesCostTextView.setText(currency.format(currentOrder.PRICE_SHAKES).toString());
        sodaSmallCostTextView.setText(currency.format(currentOrder.PRICE_SMALL_DRINK).toString());
        sodaMediumCostTextView.setText(currency.format(currentOrder.PRICE_MEDIUM_DRINK).toString());
        sodaLargeCostTextView.setText(currency.format(currentOrder.PRICE_LARGE_DRINK).toString());
    }

    public void activateOrderSummary(View view){
        int numDouble, numCheese, numFries, numShakes, numSmall, numMedium, numLarge;

        if(cheeseEditText.getText().toString().equals(""))
            numCheese = 0;
        else
            numCheese = Integer.parseInt(cheeseEditText.getText().toString());
        if(doubleEditText.getText().toString().equals(""))
            numDouble = 0;
        else
            numDouble = Integer.parseInt(doubleEditText.getText().toString());
        if(friesEditText.getText().toString().equals(""))
            numFries = 0;
        else
            numFries = Integer.parseInt(friesEditText.getText().toString());
        if(shakesEditText.getText().toString().equals(""))
            numShakes = 0;
        else
            numShakes = Integer.parseInt(shakesEditText.getText().toString());
        if(sodaSmallEditText.getText().toString().equals(""))
            numSmall = 0;
        else
            numSmall = Integer.parseInt(sodaSmallEditText.getText().toString());
        if(sodaMediumEditText.getText().toString().equals(""))
            numMedium = 0;
        else
            numMedium = Integer.parseInt(sodaMediumEditText.getText().toString());
        if(sodaLargeEditText.getText().toString().equals(""))
            numLarge = 0;
        else
            numLarge = Integer.parseInt(sodaLargeEditText.getText().toString());


        currentOrder.setDoubleDoubles(numDouble);
        currentOrder.setCheeseburgers(numCheese);
        currentOrder.setFrenchFries(numFries);
        currentOrder.setShakes(numShakes);
        currentOrder.setSmallDrinks(numSmall);
        currentOrder.setMediumDrinks(numMedium);
        currentOrder.setLargeDrinks(numLarge);

        createSummaryText();

        Intent orderSummaryIntent = new Intent (this, SummaryActivity.class);
        orderSummaryIntent.putExtra("TotalText", totalText);
        orderSummaryIntent.putExtra("OrderSummary", totalSummary);

        startActivity(orderSummaryIntent);
    }

    private void createSummaryText(){
        totalText = getString(R.string.total) + currency.format(currentOrder.calculateTotal());

        totalSummary = getString(R.string.order) + currentOrder.getOrder() + "\n" +
                        getString(R.string.subtotal) + currency.format(currentOrder.calculateSubTotal()) + "\n" +
                        getString(R.string.tax_rate) + "(" + (currentOrder.TAX_RATE * 100) + "%)" + currency.format(currentOrder.calculateTax());
    }

}
