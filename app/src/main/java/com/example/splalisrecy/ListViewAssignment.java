package com.example.splalisrecy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewAssignment extends AppCompatActivity {
    ListView listview;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_assignment);

        listview=(ListView)findViewById(R.id.listview);

        final ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("");

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,android.R.layout.simple_list_item_1,arrayList);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           Toast.makeText(ListViewAssignment.this, "Clicked" +1+ ""+" "+""+
                   ""+arrayList.get(1).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(ListViewAssignment.this,Recycler.class);
                startActivity(i);
            }
        });
    }
}
