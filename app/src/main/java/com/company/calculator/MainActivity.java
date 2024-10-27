package com.company.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,Del,ac,
                    dot,plus,devide,minus,multiply,equal;
    private TextView result,history;
    private String number = null;
    double firstNumber = 0;
    double lastNumber = 0;
    String status = null;
    Boolean operation = false;
    DecimalFormat myformat = new DecimalFormat("######.#######");
    String hist,currentResult;
    Boolean decimal = true;
    Boolean btnAccontrol = true;
    Boolean btnEqualControl = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0= findViewById(R.id.Btn0);
        btn1= findViewById(R.id.Btn1);
        btn2= findViewById(R.id.Btn2);
        btn3= findViewById(R.id.Btn3);
        btn4= findViewById(R.id.Btn4);
        btn5= findViewById(R.id.Btn5);
        btn6= findViewById(R.id.Btn6);
        btn7= findViewById(R.id.Btn7);
        btn8= findViewById(R.id.Btn8);
        btn9= findViewById(R.id.Btn9);
        
        devide= findViewById(R.id.BtnDivide);
        multiply= findViewById(R.id.BtnMultiply);
        plus = findViewById(R.id.BtnAdd);
        minus = findViewById(R.id.BtnMinus);

        ac = findViewById(R.id.BtnAc);
        dot = findViewById(R.id.BtnDot);
        Del = findViewById(R.id.BtnDelete);
        equal = findViewById(R.id.BtnEquals);

        result = findViewById(R.id.textViewResult);
        history = findViewById(R.id.textViewHistory);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = null;
                status = null;
                result.setText("0");
                history.setText("");
                firstNumber = 0;
                lastNumber = 0;
                decimal = true;
                btnAccontrol = true;
            }
        });

        Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btnAccontrol) {
                    result.setText("0");
                }
                else {
                    number = number.substring(0,number.length()-1);
                    if(number.length() == 0) {
                        Del.setClickable(false);
                    }
                    else if(number.contains(".")) {
                        decimal = false;
                    }
                    else {
                        decimal = true;
                    }
                    result.setText(number);
                }
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(decimal) {
                    if(number == null) {
                        number = "0.";
                    }
                    else {
                        number = number + ".";
                    }
                }
                result.setText(number);
                decimal = false;
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(operation) {
                    if(status == "multiplication") {
                        Multiply();
                    } else if (status == "sum") {
                        plus();
                    } else if (status == "subtraction") {
                        minus();
                    }
                    else if(status == "division"){
                        devide();
                    }
                    else {
                        firstNumber = Double.parseDouble(result.getText().toString());
                    }
                }
                operation = false;
                btnEqualControl = true;
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hist = history.getText().toString();
                currentResult = result.getText().toString();
                history.setText(hist+currentResult+"+");

                if(operation) {
                    if(status == "multiplication") {
                        Multiply();
                    } else if (status == "division") {
                        devide();
                    } else if (status == "subtraction") {
                        minus();
                    }
                    else {
                        plus();
                    }
                }
                status = "sum";
                operation = false;
                number = null;
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hist = history.getText().toString();
                currentResult = result.getText().toString();
                history.setText(hist+currentResult+"-");

                if(operation) {
                    if(status == "multiplication") {
                        Multiply();
                    } else if (status == "division") {
                        devide();
                    } else if (status == "sum") {
                        plus();
                    }
                    else {
                        minus();
                    }
                }

                status = "subtraction";
                operation = false;
                number = null;


            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hist = history.getText().toString();
                currentResult = result.getText().toString();
                history.setText(hist+currentResult+"*");

                if(operation) {
                    if(status == "add") {
                        plus();
                    }
                    else if (status == "division") {
                        devide();
                    }
                    else if (status == "subtraction") {
                        minus();
                    }
                    else {
                        Multiply();
                    }
                }

                status = "multiplication";
                operation = false;
                number = null;
            }
        });
        devide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hist = history.getText().toString();
                currentResult = result.getText().toString();
                history.setText(hist+currentResult+"/");

                if(operation) {
                    if(status == "multiplication") {
                        Multiply();
                    } else if (status == "sum") {
                        plus();
                    } else if (status == "subtraction") {
                        minus();
                    }
                    else {
                        devide();
                    }
                }

                status = "division";
                operation = false;
                number = null;
            }
        });


    }
    public void numberClick(String view) {
        if(number == null) {
            number = view;
        }
        else if(btnEqualControl) {
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        }
        else {
            number = number + view;
        }
        result.setText(number);
        operation = true;
        btnAccontrol = false;
        Del.setClickable(true);
        btnEqualControl = false;
    }
    public void plus()
    {
        lastNumber = Double.parseDouble(result.getText().toString());
        firstNumber = firstNumber + lastNumber;
        result.setText(myformat.format(firstNumber));
        decimal = true;
    }
    public void minus() {
        if(firstNumber == 0) {
            firstNumber = Double.parseDouble(result.getText().toString());
        }
        else {
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }
        result.setText(myformat.format(firstNumber));
        decimal = true;
    }
    public void Multiply() {
        if(firstNumber == 0) {
            firstNumber = 1;
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else {
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        result.setText(myformat.format(firstNumber));
        decimal = true;
    }
    public void devide() {
        if(firstNumber == 0) {
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = lastNumber/1;
        }
        else {
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        result.setText(myformat.format(firstNumber));
        decimal = true;
    }
}