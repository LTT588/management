package com.example.a11630.domain;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
//import androidx.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.a11630.face_new.R;
import com.example.a11630.tools.MyHelper;


public class Menu extends AppCompatActivity implements View.OnClickListener
{
    Button btn_change,btn_opt,btn_in,btn_delete,btn_out;
    String message;
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    @SuppressLint("NewApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_change=findViewById(R.id.change);
        btn_change.setOnClickListener(this);

        btn_in=findViewById(R.id.in);
        btn_in.setOnClickListener(this);

        btn_opt=findViewById(R.id.opt);
        btn_opt.setOnClickListener(this);

        btn_delete=findViewById(R.id.delete);
        btn_delete.setOnClickListener(this);

        btn_out=findViewById(R.id.out);
        btn_out.setOnClickListener(this);

        Intent intent_t1=getIntent();
        message=intent_t1.getStringExtra("username");
        SQLiteDatabase db;
        com.example.a11630.domain.MyHelper ggg = new com.example.a11630.domain.MyHelper(Menu.this);
        db = ggg.getWritableDatabase();
        db.query("issue",null,null,null,null,null,null);
        Cursor cursor=db.query("issue",null,null,null,null,null,null);
        if(cursor.getCount()==0)
        {
            ggg.Insert4(db,"issue","1","花果山饲养员","饲养员","5亿/天","筑基期","花果");
            ggg.Insert4(db,"issue","1","南天门保安","保安","6亿/天","筑基期","天庭");
            ggg.Insert4(db,"issue","1","地狱使者","使者","9亿/天","化神期","地狱");
           //
        }
        //ggg.Delete3(db,"issue");

        TextView textView1=findViewById(R.id.user_name1);
        textView1.setText("用户名:"+message);
        com.example.a11630.tools.MyHelper hhh=new MyHelper(Menu.this);
      //  readRequest();


    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.change){
            Intent in=new Intent(this,Release_activity.class);
            in.putExtra("username",message);
            startActivity(in);
        }
        else if(v.getId()==R.id.in){
            Intent in=new Intent(this,My_information.class);
            in.putExtra("username",message);
            startActivity(in);
        }else  if(v.getId()==R.id.opt){
            Intent in=new Intent(this,Recruitment_activity.class);
            in.putExtra("username",message);
            startActivity(in);
        }else if(v.getId()==R.id.delete){
            Intent in=new Intent(this,searcher.class);
            in.putExtra("username",message);
            startActivity(in);
        }else{
            System system = null;
            system.exit(0);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    void readRequest() {             //获取相机拍摄读写权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, 1);
            }
        }
    }

}
