package com.example.a11630.domain;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import androidx.annotation.Nullable;
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.a11630.face_new.R;
import com.example.a11630.tools.MyHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Recruitment_activity extends AppCompatActivity implements View.OnClickListener {
    TextView t1,t2,t3,t4,t5;
    Button bt1,bt_1,bt_2,bt_3,bt_4,bt_5,bt_6,bt_7,bt_8,bt_9,bt_10,bt_11,bt_12,bt_13,bt_14,bt_15,bt_16
            ,bt_17,bt_18,bt_19,bt_20,bt_21,bt_22,bt_23,bt_24,bt_25;
    Button btsz[]=new Button[25];
    int []a=new int[25];
    int temcount=0;
    int []ids={R.id.fc2_ac1,R.id.fc2_ac2,R.id.fc2_ac3,R.id.fc2_ac4,R.id.fc2_ac5,R.id.fc2_ac6
            ,R.id.fc2_ac7,R.id.fc2_ac8,R.id.fc2_ac9,R.id.fc2_ac10,R.id.fc2_ac11,R.id.fc2_ac12
            ,R.id.fc2_ac13,R.id.fc2_ac14,R.id.fc2_ac15,R.id.fc2_ac16,R.id.fc2_ac17,R.id.fc2_ac18
            ,R.id.fc2_ac19,R.id.fc2_ac20,R.id.fc2_ac21,R.id.fc2_ac22,R.id.fc2_ac23,R.id.fc2_ac24
            ,R.id.fc2_ac25
    };
    int[]ids2={R.id.fc22_inf1,R.id.fc22_inf3,R.id.fc22_inf4,R.id.fc22_inf5,R.id.fc22_inf2};
    int[]bt_ids={
            R.id.bt_id1,R.id.bt_id2,R.id.bt_id3,R.id.bt_id4,R.id.bt_id5,R.id.bt_id6,R.id.bt_id7
            ,R.id.bt_id8,R.id.bt_id9,R.id.bt_id10,R.id.bt_id11,R.id.bt_id12,R.id.bt_id13,R.id.bt_id14
            ,R.id.bt_id15,R.id.bt_id16,R.id.bt_id17,R.id.bt_id18,R.id.bt_id19,R.id.bt_id20,R.id.bt_id21
            ,R.id.bt_id22,R.id.bt_id23,R.id.bt_id24,R.id.bt_id25
    };
    int[]tt_ids={
            R.id.tt_id1, R.id.tt_id2, R.id.tt_id3, R.id.tt_id4, R.id.tt_id5,
            R.id.tt_id6, R.id.tt_id7, R.id.tt_id8, R.id.tt_id9, R.id.tt_id10,
            R.id.tt_id11, R.id.tt_id12, R.id.tt_id13, R.id.tt_id14, R.id.tt_id15,
            R.id.tt_id16, R.id.tt_id17, R.id.tt_id18, R.id.tt_id19, R.id.tt_id20,
            R.id.tt_id21, R.id.tt_id22, R.id.tt_id23, R.id.tt_id24, R.id.tt_id25,
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruitment_inf2);
        /*Spinner mSpinner = (Spinner)findViewById(R.id.Spinner_id);
        ArrayList<String> list = new ArrayList<String>();
        list.add("境界");
        list.add("筑基期");
        list.add("化神期");
        list.add("天帝境");
        //为下拉列表定义一个适配器
        final ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        //设置下拉菜单样式。
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //添加数据
        mSpinner.setAdapter(ad);
        //点击响应事件
        mSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {
                String sInfo=adapter.getItemAtPosition(position).toString();
                if(sInfo.equals("境界")){

                    creatText();
                }
                else if(sInfo.equals("筑基期"))
                {


                }

                Toast.makeText(getApplicationContext(), sInfo, Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });*/
      //  bt1=(Button)findViewById(R.id.func2_bt1);
        btsz[0]=bt_1;
        btsz[1]=bt_2;
        btsz[2]=bt_3;
        btsz[3]=bt_4;
        btsz[4]=bt_5;
        btsz[5]=bt_6;
        btsz[6]=bt_7;
        btsz[7]=bt_8;
        btsz[8]=bt_9;
        btsz[9]=bt_10;
        btsz[10]=bt_11;
        btsz[11]=bt_12;
        btsz[12]=bt_13;
        btsz[13]=bt_14;
        btsz[14]=bt_15;
        btsz[15]=bt_16;
        btsz[16]=bt_17;
        btsz[17]=bt_18;
        btsz[18]=bt_19;
        btsz[19]=bt_20;
        btsz[20]=bt_21;
        btsz[21]=bt_22;
        btsz[22]=bt_23;
        btsz[23]=bt_24;
        btsz[24]=bt_25;
        t1=(TextView)findViewById(R.id.func2_text1);
        t2=(TextView)findViewById(R.id.func2_text2);
        t3=(TextView)findViewById(R.id.func2_text3);
        t4=(TextView)findViewById(R.id.func2_text4);
        t5=(TextView)findViewById(R.id.func2_text5);
       // bt1.setOnClickListener(this);

      // creatText();
       creatText2();
       for(int i=0;i<temcount;i++)
       {
           btsz[i]=(Button)findViewById(bt_ids[i]);
           btsz[i].setOnClickListener(this);
       }
    for(int i=0;i<25;i++)
    {
        a[i]=0;
    }



    }

    @Override
    public void onClick(View v) {
        for(int ite=0;ite<temcount;ite++) {
            if (v.getId() == bt_ids[ite]) {
                TextView tv1=(TextView)findViewById(tt_ids[ite]);
                String tem=tv1.getText().toString();
                SQLiteDatabase db;
                com.example.a11630.domain.MyHelper ggg = new com.example.a11630.domain.MyHelper(Recruitment_activity.this);
                db = ggg.getWritableDatabase();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                //  System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
                ggg.Insert_two(db, "time_id", tem,df.format(new Date()));
                Toast.makeText(Recruitment_activity.this, "投递成功", Toast.LENGTH_SHORT).show();
            }
        }

    }
    /**
     * 创建一个textView，参数为文本框内容
     */

    public void creatText2() {
        SQLiteDatabase db;
        MyHelper ggg = new MyHelper(Recruitment_activity.this);
        db = ggg.getWritableDatabase();
        Cursor cursor = db.query("issue", null,
                null, null, null, null, null);
        temcount=cursor.getCount();
        if(temcount!=0){
            int f1=0,f2=0;
            cursor.moveToFirst();
            for(int i=0;i<temcount;i++){
                for(int j=0;j<5;j++) {
                    LinearLayout linearLayout = (LinearLayout) findViewById(ids2[j]);
                    if(j==4)
                    {
                        Button button=new Button(this);
                        button.setId(bt_ids[f1]);
                        f1++;
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(170,70, LinearLayout.LayoutParams.WRAP_CONTENT);
                        button.setLayoutParams(params);
                        button.setText("投递");
                        button.setLayoutParams(params);
                        button.setBackgroundColor(Color.parseColor("#FF2196F3"));
                        button.setPadding(10,10,10,10);
                        linearLayout.addView(button);
                    }
                    else {

                        TextView textView = new TextView(this);

                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 80, LinearLayout.LayoutParams.WRAP_CONTENT);
                        textView.setPadding(20, 10, 10, 10);
                        if(j==0){
                            textView.setText(cursor.getString(j + 1));
                        }
                        else
                        {
                            if(j==3){ textView.setId(tt_ids[f2]);f2++;}

                            textView.setText(cursor.getString(j + 2));
                        }

                        linearLayout.addView(textView);
                    }
                }
                cursor.moveToNext();
            }
            cursor.close();
        }

    }
    public void creatText() {
        SQLiteDatabase db;
        MyHelper ggg = new MyHelper(Recruitment_activity.this);
        db = ggg.getWritableDatabase();
        Cursor cursor = db.query("issue", null,
                null, null, null, null, null);
        temcount=cursor.getCount();
        if(temcount!=0){
            cursor.moveToFirst();
        for(int i=0;i<temcount;i++){
            LinearLayout linearLayout= (LinearLayout)findViewById(ids[i]);
            TextView textView = new TextView(this);
            TextView textView2 = new TextView(this);
            TextView textView3 = new TextView(this);
            TextView textView4 = new TextView(this);
            TextView textView5 = new TextView(this);
            TextView textView6 = new TextView(this);
            Button button=new Button(this);
            button.setId(bt_ids[i]);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200,80, LinearLayout.LayoutParams.WRAP_CONTENT);
            button.setLayoutParams(params);
            button.setText("投递简历");
            button.setBackgroundColor(Color.parseColor("#FF2196F3"));
            button.setPadding(10,10,10,10);
            textView.setPadding(20, 10, 10, 10);
            textView2.setPadding(10, 10, 10, 10);
            textView3.setPadding(10, 10, 10, 10);
            textView4.setPadding(10, 10, 10, 10);
            textView5.setPadding(10, 10, 10, 10);
            textView6.setPadding(10, 10, 10, 10);
            textView.setText(cursor.getString(1));
            textView2.setText(cursor.getString(2));
            textView3.setText(cursor.getString(3));
            textView4.setText(cursor.getString(4));
            textView5.setText(cursor.getString(5));
            linearLayout.addView(textView);
            linearLayout.addView(textView2);
            linearLayout.addView(textView3);
            linearLayout.addView(textView4);
            linearLayout.addView(textView5);
            linearLayout.addView(textView6);
            linearLayout.addView(button);
            cursor.moveToNext();

        }
        cursor.close();
        }

    }
    /**
     * 创建一个iamgeview，参数为图片名 R.drawable.image
     */


}
