package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTextView, solutionTextView;

    // All Button declare
    MaterialButton buttonC, buttonOpenBracket, buttonCloseBracket;
    MaterialButton buttonDivide, buttonMultiply, buttonSum, buttonMinus, buttonEquals;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    MaterialButton buttonAC, buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  TextView assign
        resultTextView = findViewById(R.id.result_textView);
        solutionTextView = findViewById(R.id.solution_textView);

        //  Button assign + click listener
        assignId(buttonC, R.id.button_c);
        assignId(buttonOpenBracket, R.id.button_open_bracket);
        assignId(buttonCloseBracket, R.id.button_close_bracket);
        assignId(buttonDivide, R.id.button_divide);
        assignId(buttonMultiply, R.id.button_multiply);
        assignId(buttonSum, R.id.button_sum);
        assignId(buttonMinus, R.id.button_minus);
        assignId(buttonEquals, R.id.button_equals);

        assignId(button0, R.id.button_zero);
        assignId(button1, R.id.button_1);
        assignId(button2, R.id.button_2);
        assignId(button3, R.id.button_3);
        assignId(button4, R.id.button_4);
        assignId(button5, R.id.button_5);
        assignId(button6, R.id.button_6);
        assignId(button7, R.id.button_7);
        assignId(button8, R.id.button_8);
        assignId(button9, R.id.button_9);

        assignId(buttonAC, R.id.button_ac);
        assignId(buttonDot, R.id.button_dot);
    }

    //  button id assign method
    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String buttonText = button.getText().toString(); // button er value
        String dataToCalculate = solutionTextView.getText().toString(); // already input

        //  All Clear
        if (buttonText.equals("AC")) {
            solutionTextView.setText("");
            resultTextView.setText("0");
            return;
        }

        //  Equal button
        if (buttonText.equals("=")) {
            try {
                double result = evaluate(dataToCalculate);
                String finalResult = formatResult(result);

                resultTextView.setText(finalResult);   // just result show korbe
                solutionTextView.setText("");          // input clear hobe

            } catch (Exception e) {
                resultTextView.setText("Error");
                solutionTextView.setText("");
            }
            return;
        }

        //  C button = last char delete
        if (buttonText.equals("C")) {
            if (!dataToCalculate.isEmpty()) {
                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
            }
        } else {
            //  normally input add
            dataToCalculate = dataToCalculate + buttonText;
        }

        solutionTextView.setText(dataToCalculate);
    }

    //  Expression evaluate (support + - * /)
    private double evaluate(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            //  Number or decimal point
            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                i--;
                numbers.push(Double.parseDouble(sb.toString()));
            }
            //  Operator
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(c);
            }
        }

        //  baki operator apply
        while (!operators.isEmpty()) {
            numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    //  Operator precedence
    private int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    //  Operator apply
    private double applyOp(char op, double b, double a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b == 0 ? 0 : a / b; // zero division handle
        }
        return 0;
    }

    // Result format (int hole int, decimal hole decimal)
    private String formatResult(double result) {
        if (result == (long) result) {
            return String.valueOf((long) result);
        } else {
            DecimalFormat df = new DecimalFormat("#.######");
            return df.format(result);
        }
    }
}
