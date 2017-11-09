package com.example.hadi.mcfordays;

import android.content.Intent;
import android.net.Uri;
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

            //button onclick
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



    Button secondActivityBtn= (Button) findViewById(R.id.button2);
    secondActivityBtn.setOnClickListener(new View.OnClickListener() {
    //button2 onclick
    @Override
    public void onClick(View view) {

        Intent startIntent =new Intent(getApplicationContext(), SecondActivity.class);
        startIntent.putExtra("com.example.mcfordays", " world");
        startActivity(startIntent);

    }
});

        Button googleButton= (Button) findViewById(R.id.button3);
        googleButton.setOnClickListener(new View.OnClickListener() {
            //google button onclick
            @Override
            public void onClick(View view) {
                String google="http://google.com.sg";
                Uri webaddress = Uri.parse(google);

                Intent gotoGogle=new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoGogle.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoGogle);
                }

            }
        });


    }




    }


