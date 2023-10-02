package com.example.csc311_loancalc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller class for the Loan Calculator application.
 */
public class HelloController {

    @FXML
    private Label loanAmount;

    @FXML
    private TextField loanAmountInput;

    @FXML
    private Label loanPeriod;

    @FXML
    private TextField loanPeriodInput;

    @FXML
    private Label interestRate;

    @FXML
    private TextField interestRateInput;

    @FXML
    private Label monthlyPayment;

    @FXML
    private Label monthlyPaymentOutput;

    @FXML
    private Label totalPayment;

    @FXML
    private Label totalPaymentOutput;

    @FXML
    private Button calculateButton;

    /**
     * Handles the event when the "Calculate" button is clicked.
     */
    @FXML
    protected void onCalculateButtonClick() {
        // Parse input values from text fields
        double loanAmount = Double.parseDouble(loanAmountInput.getText());
        double loanPeriod = Double.parseDouble(loanPeriodInput.getText());
        double interestRate = Double.parseDouble(interestRateInput.getText());

        // Calculate monthly and total payments
        double monthlyPayment = calculateMonthlyPayment(loanAmount, loanPeriod, interestRate);
        double totalPayment = calculateTotalPayment(monthlyPayment, loanPeriod);

        // Display the results
        monthlyPaymentOutput.setText(String.format("$%.2f", monthlyPayment));
        totalPaymentOutput.setText(String.format("$%.2f", totalPayment));
    }

    /**
     * Calculates the total payment over the loan period.
     *
     * @param monthlyPayment The monthly payment amount.
     * @param loanPeriod     The loan period in years.
     * @return The total payment over the loan period.
     */
    private double calculateTotalPayment(double monthlyPayment, double loanPeriod) {
        return monthlyPayment * 12 * loanPeriod;
    }

    /**
     * Calculates the monthly payment for the loan using the formula.
     *
     * @param loanAmount    The initial loan amount.
     * @param loanPeriod    The loan period in years.
     * @param interestRate  The annual interest rate.
     * @return The calculated monthly payment.
     */
    private double calculateMonthlyPayment(double loanAmount, double loanPeriod, double interestRate) {
        // Convert annual interest rate to monthly rate and number of months
        double monthlyInterestRate = (interestRate / 100) / 12;
        double numberOfMonths = loanPeriod * 12;

        // Calculate monthly payment using the formula
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfMonths));

        return monthlyPayment;
    }
}
