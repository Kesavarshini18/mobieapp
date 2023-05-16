package com.example.speedygatewaytravels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import kotlin.collections.UCollectionsKt;

public class plastic extends AppCompatActivity {

    Button btn_add;
    EditText et_addname;
    ListView lv_listofnames;

    List<String> friends = new ArrayList<String>();
    String[] startingList ={"bags","bottles"};

    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastic);

        btn_add =findViewById(R.id.btn_add);
        et_addname= findViewById(R.id.et_addname);
        lv_listofnames= findViewById(R.id.lv_listofnames);

        friends = new ArrayList<String>(Arrays.asList(startingList));
        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 ,friends);
        lv_listofnames.setAdapter(ad);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName =et_addname.getText().toString();
                friends.add(newName);
                Collections.sort(friends);


                ad.notifyDataSetChanged();
            }
        });


        lv_listofnames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(plastic.this, "pos="+ i +"name" + friends.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}