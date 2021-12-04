package com.example.a11630.domain;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a11630.face_new.R;



public class Release_activity extends AppCompatActivity implements View.OnClickListener {
    Button func3_bt;
    EditText ed1,ed2,ed3,ed4,ed5;
    String tem1;
    String tem2;
    String tem3;
    String tem4;
    String tem5;
    String user2_id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release);
        func3_bt=(Button)findViewById(R.id.func3_bt1);
        func3_bt.setOnClickListener(this);
        ed1=(EditText)findViewById(R.id.func3_ed1);
        ed2=(EditText)findViewById(R.id.func3_ed2);
        ed3=(EditText)findViewById(R.id.func3_ed3);
        ed4=(EditText)findViewById(R.id.func3_ed4);
        ed5=(EditText)findViewById(R.id.func3_ed5);
        Intent intent_t1=getIntent();
        user2_id=intent_t1.getStringExtra("username");



    }

    @Override
    public void onClick(View v) {
        tem1=ed1.getText().toString();
        tem2=ed2.getText().toString();
        tem3=ed3.getText().toString();
        tem4=ed4.getText().toString();
        tem5=ed5.getText().toString();
        if (tem1.equals("") || tem2.equals("")||tem3.equals("")||tem4.equals("")||tem5.equals("")) {
            Toast.makeText(this, "请把信息填写完整", Toast.LENGTH_SHORT).show();
        }
        else {
            SQLiteDatabase db;
            MyHelper ggg = new MyHelper(Release_activity.this);
            db = ggg.getWritableDatabase();
            String message="userid=\""+  user2_id +"\"";
            // Looper.prepare();
            //  Toast.makeText(My_information.this,"删除成功" , Toast.LENGTH_LONG).show();
            ggg.Insert4(db, "issue",user2_id,tem1,tem2,tem3,tem4,tem5);
            Toast.makeText(Release_activity.this, "发布成功", Toast.LENGTH_LONG).show();
        }


    }
}
