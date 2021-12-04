package com.example.a11630.domain;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Looper;
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
import com.example.a11630.domain.MyHelper;


public class My_information extends AppCompatActivity implements View.OnClickListener{
    String f1_name,f1_age,f1_xueli,user_id;
    EditText ed1,ed2,ed3;
    Button bt1;
    int flag_4=0;
    int flag_5=0;//是否有简历
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinformation);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        bt1=(Button)findViewById(R.id.func1_bt1);
        bt1.setOnClickListener(this);
        Intent intent_t1=getIntent();
         user_id=intent_t1.getStringExtra("username");
        SQLiteDatabase db1;
        MyHelper ggg = new MyHelper(My_information.this);
        db1 = ggg.getWritableDatabase();
       // ggg.Insert3(db1,"resume_name","ltt","罗田田","21","本科");
        Cursor cursor =null;
        db1.rawQuery("select * from resume_name where userid=?", new String[]{user_id});
        try {
             cursor =  db1.rawQuery("select * from resume_name where userid=?", new String[]{user_id});
             if(cursor!=null) {
                 cursor.moveToFirst();
                 ed1.setText(cursor.getString(1));
                 ed2.setText(cursor.getString(2));
                 ed3.setText(cursor.getString(3));
             }


        }
             catch(Exception e){e.printStackTrace();
        ed1.setText("");
                 ed2.setText("");
                 ed3.setText("");
        }finally {
            if(cursor != null) {cursor.close();}

        }
       /* if(cursor!=null){
            cursor.moveToFirst();
            ed1.setText(cursor.getString(1));
            ed2.setText(cursor.getString(2));
            ed3.setText(cursor.getString(3));
            cursor.close();
        }*/

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.func1_bt1) {
            f1_name = ed1.getText().toString().trim();
            f1_age = ed2.getText().toString().trim();
            f1_xueli = ed3.getText().toString().trim();
            if (f1_name.equals("") || f1_xueli.equals("")||f1_age.equals("")) {
                SQLiteDatabase db;
                MyHelper ggg = new MyHelper(My_information.this);
                db = ggg.getWritableDatabase();
                String message="userid=\""+  user_id +"\"";

                ggg.Delete(db,"resume_name",message);
              //  ggg.Delete3(db,"resume_name");
                Toast.makeText(this, "姓名、学历不能为空", Toast.LENGTH_SHORT).show();
            } else {
                SQLiteDatabase db;
                MyHelper ggg = new MyHelper(My_information.this);
                db = ggg.getWritableDatabase();
                String message="userid=\""+  user_id +"\"";
                ggg.Delete(db,"resume_name",message);
             //   Toast.makeText(My_information.this,"修改成功" , Toast.LENGTH_LONG).show();
                // Looper.prepare();
                //  Toast.makeText(My_information.this,"删除成功" , Toast.LENGTH_LONG).show();
                ggg.Insert3(db, "resume_name", user_id,f1_name,f1_age,f1_xueli);
                Toast.makeText(My_information.this, "设置成功", Toast.LENGTH_LONG).show();
            }
            /**楼下这段话之后的语句跑不了**/
            // Looper.prepare();

            // Looper.loop();
            //  db.close();

            // }
        }



    }
}
