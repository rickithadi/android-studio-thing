package com.example.hadi.mcfordays;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editId, editName,editAuthor;
    Button btnAdd,btnUpdate,btnDelete;
    ListView stBooks;


    List<Book> data=new ArrayList();
    DataBaseHelper db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db =new DataBaseHelper(this);



        btnAdd= (Button) findViewById(R.id.btnAdd);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        stBooks=(ListView)findViewById( R.id.list );
        editId=(EditText) findViewById(R.id.editId);
        editName=(EditText) findViewById(R.id.editName);
        editAuthor=(EditText) findViewById(R.id.editAuthor);


        refreshData();



        btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book= new Book(Integer.parseInt( editId.getText().toString() ),editName.getText().toString(),editAuthor.getText().toString());
                db.addBooks( book );
                Log.d("added1","added view :"+ book);
                refreshData();
               // Log.d("added1","added view"+ book);
            }
        } );

        btnUpdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book= new Book(Integer.parseInt( editId.getText().toString() ),editName.getText().toString(),editAuthor.getText().toString());
                db.updateBooks( book );
                Log.d("updated1","updated  :"+ book);
                refreshData();
            }
        } );

        btnDelete.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book= new Book(Integer.parseInt( editId.getText().toString() ),editName.getText().toString(),editAuthor.getText().toString());
                db.deleteBooks( book );
                Log.d("deleted1","deleted  :"+ book);
                refreshData();
            }
        } );


//        Button butt= (Button) findViewById(R.id.playButton);
//        butt.setOnClickListener(new View.OnClickListener() {
//
//            //button onclick
//            @Override
//            public void onClick(View view) {
//                Intent startIntent =new Intent(getApplicationContext(), PlayActivity.class);
//                startIntent.putExtra("com.example.mcfordays", " world");
//                startActivity(startIntent);
//
//            }
//        });



//       Button users= (Button) findViewById(R.id.usersButton);
//    users.setOnClickListener(new View.OnClickListener() {
//    //button2 onclick
//    @Override
//    public void onClick(View view) {
//
//        Intent startIntent =new Intent(getApplicationContext(), UserActivity.class);
//        startIntent.putExtra("com.example.mcfordays", " world");
//        startActivity(startIntent);
//
//    }
//});
////
////        Button stats= (Button) findViewById(R.id.statsButton);
//        stats.setOnClickListener(new View.OnClickListener() {
//            //button2 onclick
//            @Override
//            public void onClick(View view) {
//
//                Intent startIntent =new Intent(getApplicationContext(), StatsActivity.class);
//                startIntent.putExtra("com.example.mcfordays", " world");
//                startActivity(startIntent);
//
//            }
//        });
//
//        Button googleButton= (Button) findViewById(R.id.button3);
//        googleButton.setOnClickListener(new View.OnClickListener() {
//            //google button onclick
//            @Override
//            public void onClick(View view) {
//                String google="http://google.com.sg";
//                Uri webaddress = Uri.parse(google);
//
//                Intent gotoGogle=new Intent(Intent.ACTION_VIEW, webaddress);
//                if (gotoGogle.resolveActivity(getPackageManager()) != null){
//                    startActivity(gotoGogle);
//                }
//
//            }
//        });


    }


private void refreshData(){
    data=db.getAllBook();
    BookAdapter adapter=new BookAdapter( MainActivity.this,data,editId,editName,editAuthor );
    stBooks.setAdapter( adapter );
}

    }


