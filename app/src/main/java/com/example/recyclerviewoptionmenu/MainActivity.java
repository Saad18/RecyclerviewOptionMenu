package com.example.recyclerviewoptionmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

     RecyclerView recyclerView;
     MyAdapter adapter;
     List<RecyclerItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for (int i = 0; i<20; i++){
           listItems.add(new RecyclerItem("item"+ (i+1), "Welcome to Android World, this is description of item " + (i+1)));
        }

        adapter = new MyAdapter(listItems,this);
        recyclerView.setAdapter(adapter);
    }

}
