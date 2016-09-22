package edu.orangecoastcollege.cs273.kdo94.inandout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private TextView totalTextView;
    private TextView totalSummaryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalSummaryText = (TextView) findViewById(R.id.totalSummaryTextView);

        Bundle orderBundle = getIntent().getExtras();

        totalTextView.setText(orderBundle.getString("TotalText"));
        totalSummaryText.setText(orderBundle.getString("OrderSummary"));
    }

    public void returnToOrderMenu(View view){
        this.finish();
    }
}
