package com.cookandroid.finalexam2021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;


public class RecodeActivity extends AppCompatActivity {

    Button btnListClear, btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recode);
        setTitle("기록");

        btnListClear = (Button)findViewById(R.id.BtnListClear);
        btnMain = (Button)findViewById(R.id.BtnMain);
        ListView listView = (ListView)findViewById(R.id.ListView1);


        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ((MainActivity)MainActivity.context_main).list);
        listView.setAdapter(adapter);

        btnListClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)MainActivity.context_main).list.clear();
                adapter.notifyDataSetChanged();
            }
        });

        // activity 전환

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
