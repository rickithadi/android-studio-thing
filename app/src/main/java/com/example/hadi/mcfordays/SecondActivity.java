package com.example.hadi.mcfordays;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        if(getIntent().hasExtra("com.example.mcfordays")){
            TextView tv=(TextView) findViewById(R.id.textView);
            String text =getIntent().getExtras().getString("com.example.mcfordays");
            tv.setText(text);
        }

        Resources res=getResources();
        myListView=(ListView)findViewById(R.id.MyListView);
        items=res.getStringArray(R.array.items);
        prices=res.getStringArray(R.array.prices);
        descriptions=res.getStringArray(R.array.descriptions);

        itemAdapter itemAdapter=new itemAdapter(this, items,prices,descriptions);
        myListView.setAdapter(itemAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showDetailActivity =new Intent(getApplicationContext(), detailActivity.class);
                showDetailActivity.putExtra("com.example.mcfordays.ITEM_INDEX",  i);
                startActivity(showDetailActivity);
            }
        });



//        if(getIntent().hasExtra("com.example.mcfordays")){
//            TextView tv=(TextView) findViewById(R.id.textView);
//            String text =getIntent().getExtras().getString("com.example.mcfordays");
//            tv.setText(text);
//        }
////
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
