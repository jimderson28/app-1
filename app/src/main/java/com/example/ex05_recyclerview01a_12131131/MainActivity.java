package com.example.ex05_recyclerview01a_12131131;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ArrayList<MyListData> mList = null;
MyListAdapter adeapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mList = MyListData.getMyListDataArrayList();
        adeapter =  new MyListAdapter(mList);
        recyclerView.setAdapter(adeapter);
        Button btnInsert = findViewById(R.id.btnIster);
        Button btndelete = findViewById(R.id.btnDelete);
        btnInsert.setOnClickListener(this);
        btndelete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnIster:
                InsertItem(v);
            break;
            case R.id.btnDelete:
                DeleteItem(v);
                break;
        }

    }

    private void InsertItem(View v) {
        int min = 0;
        int max = 8;
        Random random = new Random();
        int index = random.nextInt((max - min)+1)+min;
        MyListData newItem = new MyListData("new Item"+index, android.R
                .drawable.ic_dialog_map);
        mList.add(index, newItem);
        adeapter.notifyItemInserted(index);
    }private void DeleteItem(View v){
        int min = 0;
        int max = 8;
        Random random = new Random();
        int index = random.nextInt((max - min)+1)+min;
        mList.remove(index);
        adeapter.notifyItemRemoved(index);

    }
}