package com.example.hadi.mcfordays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button butt= (Button) findViewById(R.id.button);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num1= (EditText) findViewById(R.id.firstNum);
                EditText num2= (EditText) findViewById(R.id.secondNum);
                TextView result=(TextView) findViewById(R.id.result);

                int number1 = Integer.parseInt(num1.getText().toString());
                int number2 = Integer.parseInt(num2.getText().toString());
                int resultz= number1+number2;
                result.setText(resultz +"");
            }
        });
    }
}
