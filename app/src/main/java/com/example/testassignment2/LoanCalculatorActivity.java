package com.example.testassignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class LoanCalculatorActivity extends AppCompatActivity {

    private EditText vehiclePriceEditText, downPaymentEditText, loanPeriodEditText, interestRateEditText;
    private Button calculateButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);

        vehiclePriceEditText = findViewById(R.id.vehicle_price);
        downPaymentEditText = findViewById(R.id.down_payment);
        loanPeriodEditText = findViewById(R.id.loan_period);
        interestRateEditText = findViewById(R.id.interest_rate);
        calculateButton = findViewById(R.id.calculate_button);
        backButton = findViewById(R.id.back_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndShowResult();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calculateAndShowResult() {
        if (vehiclePriceEditText.getText().toString().isEmpty() ||
                downPaymentEditText.getText().toString().isEmpty() ||
                loanPeriodEditText.getText().toString().isEmpty() ||
                interestRateEditText.getText().toString().isEmpty()) {
            // Or show a toast message
            return;
        }

        double vehiclePrice = Double.parseDouble(vehiclePriceEditText.getText().toString());
        double downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        int loanPeriod = Integer.parseInt(loanPeriodEditText.getText().toString());
        double interestRate = Double.parseDouble(interestRateEditText.getText().toString());

        double loanAmount = vehiclePrice - downPayment;
        double totalInterest = loanAmount * (interestRate / 100) * loanPeriod;
        double totalPayment = loanAmount + totalInterest;
        double monthlyPayment = totalPayment / (loanPeriod * 12);

        DecimalFormat df = new DecimalFormat("#,###.##");

        Intent intent = new Intent(LoanCalculatorActivity.this, LoanResultActivity.class);
        intent.putExtra("loanAmount", df.format(loanAmount));
        intent.putExtra("totalInterest", df.format(totalInterest));
        intent.putExtra("totalPayment", df.format(totalPayment));
        intent.putExtra("monthlyPayment", df.format(monthlyPayment));
        startActivity(intent);
    }
}