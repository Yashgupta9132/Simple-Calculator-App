package com.example.basiccalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private DecimalFormat decimalFormat;

    Button equalto, decimal, number0, sign, addition, number3, number2, number1, subtraction, number6, number5, number4, multiplication, number9, number8, number7, division, percentage, parenthesis, clearTextView;
    TextView input, result;
    ImageView delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);

        decimalFormat = new DecimalFormat("#.##########");

        equalto = findViewById(R.id.equalto);
        decimal = findViewById(R.id.decimal);
        number0 = findViewById(R.id.number0);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);
        number5 = findViewById(R.id.number5);
        number6 = findViewById(R.id.number6);
        number7 = findViewById(R.id.number7);
        number8 = findViewById(R.id.number8);
        number9 = findViewById(R.id.number9);
        sign = findViewById(R.id.sign);
        addition = findViewById(R.id.addition);
        subtraction = findViewById(R.id.subtraction);
        multiplication = findViewById(R.id.multiplication);
        division = findViewById(R.id.divison);
        percentage = findViewById(R.id.percentage);
        parenthesis = findViewById(R.id.parathesis);
        clearTextView = findViewById(R.id.clearTextView);

        input = findViewById(R.id.input);
        result = findViewById(R.id.result);

        delete = findViewById(R.id.delete);


        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "0");
            }
        });

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "1");
            }
        });

        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "2");
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "3");
            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "4");
            }
        });

        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "5");
            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "6");
            }
        });

        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "7");
            }
        });

        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "8");
            }
        });

        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "9");
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "+");
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "-");
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "x");
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "/");
            }
        });

        clearTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                result.setText("");
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "%");
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "-");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + ".");
            }
        });

        parenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();

                // Count the number of opening and closing parentheses
                int openCount = 0;
                int closeCount = 0;

                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        openCount++;
                    } else if (str.charAt(i) == ')') {
                        closeCount++;
                    }
                }

                // If open parentheses are more, add a closing parenthesis
                // Otherwise, add an opening parenthesis
                if (openCount > closeCount) {
                    input.setText(input.getText() + ")");
                } else {
                    input.setText(input.getText() + "(");
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(removeLastChar(input.getText().toString()));
                result.setText("");
            }

            private String removeLastChar(String string) {
                if (string != null && string.length() > 0) {
                    return string.substring(0, string.length() - 1);
                } else {
                    return "";
                }
            }
        });


        /*
        equalto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = input.getText().toString();

                int j = 0;
                for (int i = 0; i < str.length(); i++) {
                    if ((str.charAt(i) == '+' )|| (str.charAt(i) == '-' ) || (str.charAt(i) == '/' ) || (str.charAt(i) == 'x' ) || (str.charAt(i) == '%' )) {
                        j = i;
                        break;
                    }
                }

                int resultInt = 0;
                float resultFloat = 0.0f;
                float result1 = 0.0f;

                Float num1 = Float.parseFloat(str.substring(0, j));
                String op = str.substring(j, j + 1);
                Float num2 = Float.parseFloat(str.substring(j + 1));

                switch(op) {
                    case "+":
                        result1 = num1 + num2;
                        break;
                    case "-":
                        result1 = num1 - num2;
                        break;
                    case "x":
                        result1 = num1 * num2;
                        break;
                    case "/":
                        result1 = num1 / num2;
                        break;
                    case "%":
                        result1 = num1 % (num2);
                        break;
                    default:
                }

                if (result1 % 1 != 0) {
                    resultFloat = result1;
                    result.setText(String.valueOf(resultFloat));
                } else {
                    resultInt = (int) result1;  // Convert float to int
                    result.setText(String.valueOf(resultInt));
                }
            }
        });

        */


        equalto.setOnClickListener(v -> {
            String expressionString = input.getText().toString().replaceAll("x", "*").replaceAll("%", "/100");

            // Check for multiple consecutive operators
            if (expressionString.matches(".*[\\+\\-\\*/]{2,}.*")) {
                result.setText("Error: Invalid Operator Sequence");
                return;
            }

            try {
                Expression expression = new ExpressionBuilder(expressionString).build();
                double resultValue = expression.evaluate();
                result.setText(decimalFormat.format(resultValue));
            } catch (ArithmeticException e) {
                result.setText("Error");
            }
        });
    }
}



