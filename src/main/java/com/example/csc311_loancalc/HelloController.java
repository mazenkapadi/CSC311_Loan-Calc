package com.example.csc311_loancalc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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


    @FXML
    protected void onCalculateButtonClick() {
        double loanAmount = Double.parseDouble(loanAmountInput.getText());
        double loanPeriod = Double.parseDouble(loanPeriodInput.getText());
        double interestRate = Double.parseDouble(interestRateInput.getText());

        double monthlyPayment = calculateMonthlyPayment(loanAmount, loanPeriod, interestRate);
        double totalPayment = calculateTotalPayment(monthlyPayment, loanPeriod);

        monthlyPaymentOutput.setText(String.format("$%.2f", monthlyPayment));
        totalPaymentOutput.setText(String.format("$%.2f", totalPayment));
    }

    private double calculateTotalPayment(double monthlyPayment, double loanPeriod) {
        return monthlyPayment * 12 * loanPeriod;
    }

    private double calculateMonthlyPayment(double loanAmount, double loanPeriod, double interestRate) {
        // Convert annual interest rate to monthly rate and number of months
        double monthlyInterestRate = (interestRate / 100) / 12;
        double numberOfMonths = loanPeriod * 12;

        // Calculate monthly payment
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfMonths));

        return monthlyPayment;
    }


}