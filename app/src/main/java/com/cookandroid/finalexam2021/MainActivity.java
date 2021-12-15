package com.cookandroid.finalexam2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Debug;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class MainActivity extends AppCompatActivity {

    Button btnNum[] = new Button[10];
    int btnId[] = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
                    R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };

    Button btnAdd, btnSub, btnMul, btnDiv, btnEqual, btnClean, btnRecode;
    TextView textView1;
    Integer num1, num2, operator;
    Integer result;

    ArrayList<String> list = new ArrayList<>();

    public void addList(String string) {
        this.list.add(string);
    }

    public static Context context_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");

        context_main = this;

        // id 추가
        textView1 = (TextView) findViewById(R.id.TextView1);
        btnAdd = (Button)findViewById(R.id.BtnAdd);
        btnSub = (Button)findViewById(R.id.BtnSub);
        btnMul = (Button)findViewById(R.id.BtnMultiply);
        btnDiv = (Button)findViewById(R.id.BtnDivide);
        btnEqual = (Button)findViewById(R.id.BtnEqual);
        btnClean = (Button)findViewById(R.id.BtnClean);
        btnRecode = (Button)findViewById(R.id.BtnRecod);
        for (int i=0; i<btnNum.length; i++) {
            btnNum[i] = (Button)findViewById(btnId[i]);
        }

        View.OnClickListener Click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String) textView1.getText();
                text += ((Button) v).getText();

                textView1.setText(text);
            }
        };

        for (int i=0; i<btnNum.length; i++) {
            btnNum[i].setOnClickListener(Click);
        }


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String) textView1.getText();
                num1 = Integer.parseInt(text);
                textView1.setText("");
                operator = 1;
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String) textView1.getText();
                num1 = Integer.parseInt(text);
                textView1.setText("");
                operator = 2;
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String) textView1.getText();
                num1 = Integer.parseInt(text);
                textView1.setText("");
                operator = 3;
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String) textView1.getText();
                num1 = Integer.parseInt(text);
                textView1.setText("");
                operator = 4;
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Integer.valueOf(textView1.getText().toString());
                if (operator == 1) {
                    result = num1 + num2;
                    addList(num1 + " + " + num2 + " = " + result.toString());
                } else if (operator == 2) {
                    result = num1 - num2;
                    addList(num1 + " — " + num2 + " = " + result.toString());
                } else if (operator == 3) {
                    result = num1 * num2;
                    addList(num1 + " × " + num2 + " = " + result.toString());
                } else if (operator == 4) {
                    result = num1 / num2;
                    addList(num1 + " ÷ " + num2 + " = " + result.toString());
                }
                textView1.setText(String.valueOf(result));
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = 0;
                textView1.setText("");
            }
        });

        // activity 전환
        btnRecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RecodeActivity.class);
                startActivity(intent);
            }
        });



    }
}