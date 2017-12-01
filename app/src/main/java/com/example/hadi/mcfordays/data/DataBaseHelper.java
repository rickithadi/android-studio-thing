package com.example.hadi.mcfordays.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hadi.mcfordays.data.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadi on 11/16/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    //DB
    private static final int DATABASE_VER = 1;
    // Database Name
    private static final String DATABASE_NAME = "BookDeeB";

    //table
    private static final String TABLE_NAME = "Books";
    private static final String KEY_ID = "Id";
    private static final String KEY_NAME= "Name";
    private static final String KEY_AUTHOR = "Author";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE=    "CREATE TABLE "+ TABLE_NAME+"("
                        +KEY_ID+" INTEGER PRIMARY KEY,"+KEY_NAME+" TEXT,"
                       +KEY_AUTHOR+" TEXT"+")";

        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       sqLiteDatabase.execSQL(  "DROP TABLE IF EXISTS "+ TABLE_NAME );
        onCreate( sqLiteDatabase );

    }

    //CRUD BOOKS

    public void addBooks(Book book){
        Log.d("added2","added view :"+ book);
        SQLiteDatabase db=this.getWritableDatabase();
    ContentValues values=new ContentValues(  );
    values.put( KEY_NAME,book.getName() );
    values.put( KEY_AUTHOR,book.getAuthor() );

    db.insert(TABLE_NAME, null, values);
    db.close();
}

    public int updateBooks(Book book){
        SQLiteDatabase db=this.getWritableDatabase();
        Log.d("updated2","updated  :"+ book);
        ContentValues values=new ContentValues(  );
        values.put( KEY_NAME,book.getName() );
        values.put( KEY_AUTHOR,book.getAuthor() );

        return db.update(TABLE_NAME, values, KEY_ID+" =?", new String[]{String.valueOf(book.getId())});

           }

    public void deleteBooks(Book book){
        SQLiteDatabase db=this.getWritableDatabase();
        Log.d("deleted2","deleted  :"+ book);

        db.delete(TABLE_NAME, KEY_ID+ " =?", new String[]{String.valueOf( book.getId())} );
        db.close();

    }

    public Book getBook(int id){

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{KEY_ID,KEY_NAME,KEY_AUTHOR}, KEY_ID+"-?",
                new String[]{String.valueOf( id )},null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();
      return new Book( cursor.getInt( 0 ),cursor.getString( 1 ),cursor.getString( 2 ) );


    }

    public List<Book> getAllBook() {
        List<Book> stBooks = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery( selectQuery, null );

        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setId( cursor.getInt( 0 ) );
                book.setName( cursor.getString( 1 ) );
                book.setAuthor( cursor.getString( 2 ) );

                stBooks.add( book );
             //   cursor.close();

            }
            while (cursor.moveToNext());

        }
        return stBooks;
    }
}