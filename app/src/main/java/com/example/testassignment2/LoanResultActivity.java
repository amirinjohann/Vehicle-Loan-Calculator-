package com.example.testassignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoanResultActivity extends AppCompatActivity {

    private TextView loanAmountTextView, totalInterestTextView, totalPaymentTextView, monthlyPaymentTextView;
    private Button goHomeButton, newInputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_result);

        loanAmountTextView = findViewById(R.id.loan_amount);
        totalInterestTextView = findViewById(R.id.total_interest);
        totalPaymentTextView = findViewById(R.id.total_payment);
        monthlyPaymentTextView = findViewById(R.id.monthly_payment);
        goHomeButton = findViewById(R.id.go_home_button);
        newInputButton = findViewById(R.id.new_input_button);

        Intent intent = getIntent();
        String loanAmount = intent.getStringExtra("loanAmount");
        String totalInterest = intent.getStringExtra("totalInterest");
        String totalPayment = intent.getStringExtra("totalPayment");
        String monthlyPayment = intent.getStringExtra("monthlyPayment");

        loanAmountTextView.setText("Loan Amount: RM " + loanAmount);
        totalInterestTextView.setText("Total Interest: RM " + totalInterest);
        totalPaymentTextView.setText("Total Payment: RM " + totalPayment);
        monthlyPaymentTextView.setText("Monthly Payment: RM " + monthlyPayment);

        goHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoanResultActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        newInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}