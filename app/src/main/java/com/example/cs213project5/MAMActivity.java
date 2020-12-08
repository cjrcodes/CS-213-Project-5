package com.example.cs213project5;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Christian Rodriguez, Yazhini Shanmugam
 *
 * MAMActivity, Activity class for Montclair Art Museum
 */
public class MAMActivity extends AppCompatActivity {

    private EditText ticketPriceText;
    private EditText salesTaxText;
    private EditText ticketTotalText;

    private Button calculateTicketPrice;
    private Spinner adultTickets;
    private Spinner seniorTickets;
    private Spinner studentTickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mam);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toast.makeText(this, "Maximum of 5 tickets for each!",
                Toast.LENGTH_LONG).show();


        setSpinners();

        ticketPriceText = findViewById(R.id.ticketPriceText);
        salesTaxText = findViewById(R.id.salesTaxText);
        ticketTotalText = findViewById(R.id.ticketTotalText);

        adultTickets = findViewById(R.id.spnAdult);
        seniorTickets = findViewById(R.id.spnSenior);
        studentTickets = findViewById(R.id.spnStudent);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        calculateTicketPrice = (Button) view.findViewById(R.id.btnCalculatePrice);

        return view;
    }


    public void setSpinners() {
        Spinner spinner = (Spinner) findViewById(R.id.spnAdult);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ticket_amount, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setSelection(0);

        Spinner spinner2 = (Spinner) findViewById(R.id.spnSenior);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.ticket_amount, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        spinner2.setSelection(0);


        Spinner spinner3 = (Spinner) findViewById(R.id.spnStudent);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.ticket_amount, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner3.setAdapter(adapter3);

        spinner3.setSelection(0);

    }

    public void openWebsite(View view) {
        Uri uri = Uri.parse("https://www.montclairartmuseum.org/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void calculateTicketPrice(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spnAdult);

        if (adultTickets.getSelectedItem() == null || seniorTickets.getSelectedItem() == null || studentTickets.getSelectedItem() == null) {
            return;
        } else {
            //TextInputLayout til = (TextInputLayout) findViewById(R.id.ticketPrice);
            //til.setHint(R.string.ticketprice);

            //EditText et = new EditText(this);
            int ticketPriceAdult = 23;
            int ticketPriceSenior = 16;
            int ticketPriceStudent = 14;

            double adultPrice = Integer.parseInt(adultTickets.getSelectedItem().toString()) * ticketPriceAdult;
            double seniorPrice = Integer.parseInt(seniorTickets.getSelectedItem().toString()) * ticketPriceSenior;
            double studentPrice = Integer.parseInt(studentTickets.getSelectedItem().toString()) * ticketPriceStudent;

            double ticketPrice = adultPrice + seniorPrice + studentPrice;
            //adultNumOfTickets =  spinner.getSelectedItem();
            DecimalFormat formatter = new DecimalFormat("0.00");
            String priceToString = formatter.format(ticketPrice);
            ticketPriceText.setText("$" + priceToString);

            double salesTax = ticketPrice * .06625;

            String taxToString = formatter.format(salesTax);

            salesTaxText.setText("$" + taxToString);

            double ticketTotal = salesTax + ticketPrice;

            String totalToString = formatter.format(ticketTotal);

            ticketTotalText.setText("$" + totalToString);

            //til.addView(ticketPriceText);

            //  til.setHintAnimationEnabled(true);
            // int value = (Integer) spinner.getSelectedItem();
        }

        /*
         */


    }
}
