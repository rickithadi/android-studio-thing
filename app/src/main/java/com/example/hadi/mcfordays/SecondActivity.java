package com.example.hadi.mcfordays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        if(getIntent().hasExtra("com.example.mcfordays")){
            TextView tv=(TextView) findViewById(R.id.textView);
            String text =getIntent().getExtras().getString("com.example.mcfordays");
            tv.setText(text);
        }
//
//        Button secondActivityBtn= (Button) findViewById(R.id.button2);
//        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//Intent startIntent= new Intent(getApplicationContext(),SecondActivity.class);
//
//startActivity(startIntent);
//            }
//                   });
//    }
}}
