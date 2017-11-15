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



        Button butt= (Button) findViewById(R.id.playButton);
        butt.setOnClickListener(new View.OnClickListener() {

            //button onclick
            @Override
            public void onClick(View view) {
                Intent startIntent =new Intent(getApplicationContext(), PlayActivity.class);
                startIntent.putExtra("com.example.mcfordays", " world");
                startActivity(startIntent);

            }
        });



       Button users= (Button) findViewById(R.id.usersButton);
    users.setOnClickListener(new View.OnClickListener() {
    //button2 onclick
    @Override
    public void onClick(View view) {

        Intent startIntent =new Intent(getApplicationContext(), UserActivity.class);
        startIntent.putExtra("com.example.mcfordays", " world");
        startActivity(startIntent);

    }
});

        Button stats= (Button) findViewById(R.id.statsButton);
        stats.setOnClickListener(new View.OnClickListener() {
            //button2 onclick
            @Override
            public void onClick(View view) {

                Intent startIntent =new Intent(getApplicationContext(), StatsActivity.class);
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


