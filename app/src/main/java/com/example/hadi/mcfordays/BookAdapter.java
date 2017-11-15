package com.example.hadi.mcfordays;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.List;

/**
 * Created by hadi on 11/16/17.
 */

public class BookAdapter extends BaseAdapter {
    Activity activity;
    List<Book> stBooks;
    LayoutInflater inflater;
    EditText editId, editTitle;

    public BookAdapter(Activity activity, List<Book> stBooks, LayoutInflater inflater, EditText editId, EditText editTitle) {
        this.activity = activity;
        this.stBooks = stBooks;
        this.inflater = inflater;
        this.editId = editId;
        this.editTitle = editTitle;
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
        return stBooks.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
