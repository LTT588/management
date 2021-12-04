package com.example.a11630.domain;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
  /*  public MyHelper(Context context) {
        super(context, "facedata4.db", null, 1);
    }*/
  public MyHelper(Context context) {
      super(context, "database3.db", null, 1);
  }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String stu_table = "create table name_id (id text primary key ,name text)"; //name----id
        String stu_table1 = "create table time_id(id text ,time text)"; //time----id
//执行SQL语句
        String  stu_table2="create table resume_name(userid text primary key,name text ,age text,xueli text)";
        String  stu_table3="create table issue(userid text  ,title text ,job text,salary text,xueli text,cname text)";
        db.execSQL(stu_table);
        db.execSQL(stu_table1);
        db.execSQL(stu_table2);
        db.execSQL(stu_table3);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

  public  void Insert(SQLiteDatabase db, String table, String name, String id) {   ///db,table,name,id
        ContentValues cValue = new ContentValues();
        cValue.put("id", id);
        cValue.put("name", name);
        db.insert(table, null, cValue);
        System.out.println("插入成功："+id+"   "+name);
    }
    public  void Insert_two(SQLiteDatabase db, String table, String time, String id) {   ///db,table,time,id
        ContentValues cValue = new ContentValues();
        cValue.put("id", id);
        cValue.put("time", time);
        db.insert(table, null, cValue);
        System.out.println("插入time成功："+id+"   "+time);
    }
   public  void Insert3(SQLiteDatabase db, String table, String userid,String name, String age,String xueli) {   ///db,table,name,age,xueli
        ContentValues cValue = new ContentValues();
       cValue.put("userid", userid);
        cValue.put("name", name);
        cValue.put("age", age);
        cValue.put("xueli", xueli);
        db.insert(table, null, cValue);
        System.out.println("插入成功："+name+"   "+age+"   ");
    }
    public  void Insert4(SQLiteDatabase db, String table, String userid,String title,String job, String salary,String xueli,String cname) {   ///db,table,name,age,xueli
        ContentValues cValue = new ContentValues();
        cValue.put("userid", userid);
        cValue.put("title", title);
        cValue.put("job", job);
        cValue.put("salary", salary);
        cValue.put("xueli", xueli);
        cValue.put("cname", cname);
        db.insert(table, null, cValue);
        System.out.println("插入成功!");
    }

    public void Delete(SQLiteDatabase db, String table, String message) {
        String sql = "delete from " + table + " where  " + message;
        System.out.println("sqi语句："+sql);
        db.execSQL(sql);
    }
    /*public void Delete2(SQLiteDatabase db, String table, String message){
        String sql="delete from " + table + " where  " + message;
        System.out.println("sqi语句："+sql);
        db.execSQL(sql);

    }*/
    public void Delete3(SQLiteDatabase db, String table) {
        String sql = "delete from " + table;
        System.out.println("sqi语句："+sql);
        db.execSQL(sql);
    }

}
