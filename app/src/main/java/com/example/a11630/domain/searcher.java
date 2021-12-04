package com.example.a11630.domain;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.support.v7.app.AppCompatActivity;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.a11630.face_new.R;
import com.example.a11630.tools.MyHelper;

import java.util.Calendar;

public class searcher extends AppCompatActivity implements View.OnClickListener {

    Button bt_1,bt_2,bte_3;
    TextView search_sum;
    int flag;
    EditText IDS;
    String user3_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);
        Intent intent_t1=getIntent();
        user3_id=intent_t1.getStringExtra("username");
        bt_1 = (Button) findViewById(R.id.search_1);
        bt_1.setOnClickListener(this);
        bt_2 = (Button) findViewById(R.id.search_2);
        bt_2.setOnClickListener(this);
        bte_3=(Button)findViewById(R.id.btn_search);
        bte_3.setOnClickListener(this);

        search_sum=(TextView)findViewById(R.id.tv_sum);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_search) {

            StringBuffer sum = new StringBuffer();
            SQLiteDatabase db;
            MyHelper ggg = new MyHelper(searcher.this);
            db = ggg.getWritableDatabase();
            Cursor cursor =  db.rawQuery("select * from issue where userid=?", new String[]{user3_id});
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                String id = cursor.getString(0);
                String name_time = cursor.getString(1);
                String tem1=cursor.getString(2);
                System.out.println("查询结果：");
                System.out.println(id + ":" + name_time);
                sum.append("查询结果：" + "\n  用户:" + id + "    主题:" + name_time +"职位   "+tem1 +"\n");

                while (cursor.moveToNext()) {
                    String id1 = cursor.getString(0);
                    String name_time1 = cursor.getString(1);
                    System.out.println("查询结果：");
                    System.out.println(id1 + ":" + name_time1);
                    sum.append("   用户:" + id1 + "      主题:" + name_time1 +"职位   "+tem1 +"\n");
                } cursor.close();
            }


            search_sum.setText(sum.toString());
        }

        if (v.getId() == R.id.search_2) {
            StringBuffer sum = new StringBuffer();
            SQLiteDatabase db;
            MyHelper ggg = new MyHelper(searcher.this);
            db = ggg.getWritableDatabase();
            Cursor cursor = db.query("time_id", null,
                    null, null, null, null, null);
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                String id = cursor.getString(0);
                String name_time = cursor.getString(1);

                System.out.println("查询结果：\n");
                System.out.println(id + ":" + name_time);
                sum.append("查询结果：" + "\n    时间:" + id + "        公司:" + name_time + "\n");

                while (cursor.moveToNext()) {
                    String id1 = cursor.getString(0);
                    String name_time1 = cursor.getString(1);
                    System.out.println("查询结果：");
                    System.out.println(id1 + ":" + name_time1);
                    sum.append("    时间:" + id1 + "        公司:" + name_time1 + "\n");
                }
            }
            cursor.close();
            db.close();
            search_sum.setText(sum.toString());

        }
        if (v.getId() == R.id.search_1) {

            StringBuffer sum = new StringBuffer();
            SQLiteDatabase db;
            MyHelper ggg = new MyHelper(searcher.this);
            db = ggg.getWritableDatabase();
            Cursor cursor = db.query("name_id", null,
                    null, null, null, null, null);
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                String id = cursor.getString(0);
                String name_time = cursor.getString(1);
                System.out.println("查询结果：");
                System.out.println(id + ":" + name_time);
                sum.append("查询结果：" + "\n    ID:" +  name_time + "\n");

                while (cursor.moveToNext()) {
                    String id1 = cursor.getString(0);
                    String name_time1 = cursor.getString(1);
                    System.out.println("查询结果：");
                    System.out.println(id1 + ":" + name_time1);
                    sum.append("    ID:"  + name_time1 + "\n");
                }
            }
            cursor.close();
            db.close();
            search_sum.setText(sum.toString());


        }







    }
}
