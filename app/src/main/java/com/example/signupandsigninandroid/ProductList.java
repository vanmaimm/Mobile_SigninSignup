package com.example.signupandsigninandroid;

import android.app.AppComponentFactory;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {
    GridView  gridView;
    ArrayList<Product> list;
    ProductListAdapter adapter = null;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_home);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new ProductListAdapter(this, R.layout.product_item, list);
        gridView.setAdapter(adapter);
//        Cursor cursor = MainActivity2.
    }
}
