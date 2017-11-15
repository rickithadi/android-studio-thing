package com.example.hadi.mcfordays;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hadi on 11/16/17.
 */

public class BookAdapter extends BaseAdapter {
    Activity activity;
    List<Book> stBooks;
    LayoutInflater inflater;
    EditText editId, editName,editAuthor;

    public BookAdapter(Activity activity, List<Book> stBooks ,EditText editId, EditText editName, EditText editAuthor) {
        this.activity = activity;
        this.stBooks = stBooks;
       inflater=(LayoutInflater)activity.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        this.editId = editId;
        this.editName = editName;
        this.editAuthor=editAuthor;
    }

    @Override
    public int getCount() {
        return stBooks.size();
    }

    @Override
    public Object getItem(int i) {
        return stBooks.get(i);
    }

    @Override
    public long getItemId(int i) {
        Log.d("Id_BookAdapter ","Id_BookAdapter"+ stBooks.get(i).getId());
        return stBooks.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView;
        rowView=inflater.inflate(R.layout.row,null);
        final TextView txtRowId,txtRowName,txtRowAuthor;
        txtRowId=(TextView)rowView.findViewById( R. id.txtRowId);
        txtRowName=(TextView)rowView.findViewById( R. id.txtRowName);
        txtRowAuthor=(TextView)rowView.findViewById( R. id.txtRowAuthor);

        txtRowId.setText( ""+stBooks.get( i ).getId() );
        txtRowName.setText( ""+stBooks.get( i ).getName() );
        txtRowAuthor.setText( ""+stBooks.get( i ).getAuthor() );

        rowView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editId.setText( ""+txtRowId.getText() );
                editName.setText( ""+txtRowName.getText() );
                editAuthor.setText( ""+txtRowAuthor.getText() );
            }
        } );
        return rowView;
    }
}
