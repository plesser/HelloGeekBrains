package ru.plesser.hellogeekbrains;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final private String TAG = "calculator";
    final private String BUNDLE = "data";

    TextView historyTextView;
    TextView displayTextView;

    Button clearButton;
    Button divButton;
    Button multiButton;
    Button minusButton;

    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button plusButton;

    Button fourButton;
    Button fiveButton;
    Button sixButton;

    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button equalButton;

    Button zeroButton;
    Button dotButton;

    float numberOne = 0;
    float numberTwo = 0;
    float result;
    String operator;

    Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            data = (Data) savedInstanceState.get(BUNDLE);
        }

        initViews();

        displayTextView.setText("0");
    }


    @Override
    public void onClick(View view) {
        String display = displayTextView.getText().toString();
        String key = "";

        Log.d(TAG, "originally " + display);
        switch (view.getId()){
            case R.id.clear_button:
                key = "C";
                break;
            case R.id.zero_button:
                key = "0";
                break;
            case R.id.one_button:
                key = "1";
                break;
            case R.id.two_button:
                key = "2";
                break;
            case R.id.three_button:
                key = "3";
                break;
            case R.id.four_button:
                key = "4";
                break;
            case R.id.five_button:
                key = "5";
                break;
            case R.id.six_button:
                key = "6";
                break;
            case R.id.seven_button:
                key = "7";
                break;
            case R.id.eight_button:
                key = "8";
                break;
            case R.id.nine_button:
                key = "9";
                break;
            case R.id.dot_button:
                key = ".";
                break;
            case R.id.plus_button:
                key = "+";
                break;
            case R.id.minus_button:
                key = "-";
                break;
            case R.id.multi_button:
                key = "*";
                break;
            case R.id.div_button:
                key = "/";
                break;
            case R.id.equal_button:
                key = "=";
                break;
            default:
                key = "";
        }

        String numbers = "0123456789";
        if (numbers.indexOf(key) >= 0) {
            Log.d(TAG, "numbers " + key);
            if (display.equals("0") && key == "0"){
                // nothing
            } else if (display.equals("0") && key != "0"){
                display = key;
            } else {
                display = display + key;
            }
        }
        if (key.equals(".") && display.indexOf(key) < 0){
                display = display + key;
        }

        if (key.equals("C")){
            numberOne = 0;
            numberTwo = 0;
            operator = "";
            display = "0";
        }

        String operators = "+-*/";
        if (operators.indexOf(key) >= 0){
            Log.d(TAG, "into operators " + display);
            numberOne = Float.valueOf(display);
            operator = key;
            display = "0";
            Log.d(TAG, "into operators " + numberOne + " " + operator);
        }

        if ( "=".equals(key) ) {
            Log.d(TAG, "get result");
            numberTwo = Float.valueOf(display);
            Log.d(TAG, "A into operators " + numberOne + " " + operator + " " + numberTwo + " = ");
            if ("+".equals(operator)){
                result = numberOne + numberTwo;
            }
            if ("-".equals(operator)){
                result = numberOne - numberTwo;
            }
            if ("*".equals(operator)){
                result = numberOne * numberTwo;
            }
            if ("/".equals(operator)){
                result = numberOne / numberTwo;
            }
            Log.d(TAG, "B into operators " + numberOne + " " + operator + " " + numberTwo + " = " + result);
            display = String.valueOf(result);
        }



        displayTextView.setText(display);
    }

    private void initViews() {
        historyTextView = findViewById(R.id.history_textview);
        displayTextView = findViewById(R.id.display_textvew);

        clearButton = findViewById(R.id.clear_button);
        clearButton.setOnClickListener(this);

        divButton = findViewById(R.id.div_button);
        divButton.setOnClickListener(this);

        multiButton = findViewById(R.id.multi_button);
        multiButton.setOnClickListener(this);

        minusButton = findViewById(R.id.minus_button);
        minusButton.setOnClickListener(this);
        //-------------------------------------------------------
        sevenButton = findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(this);

        eightButton = findViewById(R.id.eight_button);
        eightButton.setOnClickListener(this);

        nineButton = findViewById(R.id.nine_button);
        nineButton.setOnClickListener(this);

        plusButton = findViewById(R.id.plus_button);
        plusButton.setOnClickListener(this);
        //-------------------------------------------------------

        fourButton = findViewById(R.id.four_button);
        fourButton.setOnClickListener(this);

        fiveButton = findViewById(R.id.five_button);
        fiveButton.setOnClickListener(this);

        sixButton = findViewById(R.id.six_button);
        sixButton.setOnClickListener(this);

        //------------------------------------------------------
        oneButton = findViewById(R.id.one_button);
        oneButton.setOnClickListener(this);

        twoButton = findViewById(R.id.two_button);
        twoButton.setOnClickListener(this);

        threeButton = findViewById(R.id.three_button);
        threeButton.setOnClickListener(this);

        equalButton = findViewById(R.id.equal_button);
        equalButton.setOnClickListener(this);

        //-------------------------------------------------------
        zeroButton = findViewById(R.id.zero_button);
        zeroButton.setOnClickListener(this);

        dotButton = findViewById(R.id.dot_button);
        dotButton.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(BUNDLE, data);
    }
}