package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  CalculatorModel calculator;

    private TextView text;





        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numberIds = new int[] {
                R.id.btn_0,
                R.id.btn_1,
                R.id.btn_2,
                R.id.btn_3,
                R.id.btn_4,
                R.id.btn_5,
                R.id.btn_6,
                R.id.btn_7,
                R.id.btn_8,
                R.id.btn_9,
                R.id.dot_btn,

        };

        int[] actionIds = new int[] {
                R.id.back_btn,
                R.id.division,
                R.id.minus,
                R.id.equals,
                R.id.multiply,
                R.id.plus,
                R.id.reset
        };

        text =findViewById(R.id.math_operation);

        calculator = new CalculatorModel();



//  Обработчик кнопок

        View.OnClickListener nunberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());

            }
        };
//  Обработчик арифметических действий
        View.OnClickListener actionButtonOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numberIds.length; i++) {
            findViewById((int) numberIds[(int) i]).setOnClickListener(nunberButtonClickListener);
        }

        for (int i = 0; i < actionIds.length; i++) {
            findViewById(actionIds[(int) i]).setOnClickListener(actionButtonOnclickListener);
        }
        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.reset();
                text.setText(calculator.getText());
            }
        });


    }


}



