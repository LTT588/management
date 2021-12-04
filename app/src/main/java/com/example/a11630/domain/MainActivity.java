package com.example.a11630.domain;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

//import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
//import android.support.annotation.RequiresApi;
//import android.support.v4.app.ActivityCompat;
//import android.support.v7.app.AppCompatActivity;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StrictMode;
import android.provider.MediaStore;
//import android.support.annotation.RequiresApi;
//import android.support.v7.app.AppCompatActivity;
//import androidx.annotation.Nullable;
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a11630.face_new.R;
import com.example.a11630.tools.Base64Util;
import com.example.a11630.tools.GsonUtils;
import com.example.a11630.tools.HttpUtil;
import com.example.a11630.tools.MyHelper;
import com.example.a11630.tools.toolsUnit;
import com.google.gson.Gson;

import org.apache.log4j.chainsaw.Main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.example.a11630.face_new.R;
import com.example.a11630.tools.MyHelper;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_f1,btn_f2,btn_f3,btn_f4,btn_f5;
    private String ImagePath = null;
    private Uri imageUri,imageUri_display;
    private int Photo_ALBUM = 1, CAMERA = 2;
    private Bitmap bp = null;
    private int flag=0;//打卡是否成功
    int flag2=0;//登录是否成功
    String result;
    ImageView iv_picture;
    TextView tv_sum;
    EditText ed1,ed2;
    String S_user;
    String user2;
    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        flag2=0;
        flag=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        btn_f1=(Button)findViewById(R.id.signin1);
        btn_f1.setOnClickListener(this);
        btn_f2=(Button)findViewById(R.id.register1);
        btn_f2.setOnClickListener(this);
        btn_f3=(Button)findViewById(R.id.btn_login_face);
        btn_f3.setOnClickListener(this);

        tv_sum=(TextView)findViewById(R.id.text_wjmm);
        tv_sum.setOnClickListener(this);
        Intent intent_t1=getIntent();
        String message=intent_t1.getStringExtra("password");
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        readRequest();

    }
   /* public boolean login(String username,String password){
        SQLiteDatabase db;
        MyHelper ggg = new MyHelper(MainActivity.this);
        db = ggg.getWritableDatabase();
        Cursor cursor = db.query("name_id", null,
                null, null, null, null, null);
        String id1 = cursor.getString(0);
        String name_time1 = cursor.getString(1);
    }*/

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void onClick(View v) {
        if(v.getId()==R.id.signin1){

            ed1=(EditText)findViewById(R.id.editTxt_userName);
            ed2=(EditText)findViewById(R.id.editTxt_password);
            String name=ed1.getText().toString().trim();
            String pass=ed2.getText().toString().trim();
            S_user=ed1.getText().toString().trim();
            SQLiteDatabase db;
            MyHelper ggg = new MyHelper(MainActivity.this);
            db = ggg.getWritableDatabase();
            Cursor c = db.query("name_id",null,"id=? and name=?",new String[]{name,pass},null,null,null);
            //如果有查询到数据
            if(c!=null && c.getCount() >= 1){
                c.close();
                Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();
                Intent in=new Intent(this,Menu.class);
                in.putExtra("username",name);
                startActivity(in);
            }
            else
            {
                Toast.makeText(this,"登陆失败",Toast.LENGTH_LONG).show();
            }
        }
        else if(v.getId()==R.id.register1){
            Intent in=new Intent(this,in.class);
            startActivity(in);
        }else  if(v.getId()==R.id.btn_login_face){

            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            builder.detectFileUriExposure();            //7.0拍照必加
            File outputImage = new File(Environment.getExternalStorageDirectory() + File.separator + "face.jpg");     //临时照片存储地
            try {                                                                                   //文件分割符
                if (outputImage.exists()) {   //如果临时地址有照片，先清除
                    outputImage.delete();
                }
                outputImage.createNewFile();    ///创建零食地址
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageUri = Uri.fromFile(outputImage);              //获取Uri

            //   imageUri_display= FileProvider.getUriForFile(opt.this,"com.example.a11630.face_new.fileprovider",outputImage);

            ImagePath = outputImage.getAbsolutePath();
            Log.i("拍照图片路径", ImagePath);         //，是传递你要保存的图片的路径，打开相机后，点击拍照按钮，系统就会根据你提供的地址进行保存图片
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);    //跳转相机
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);                          //相片输出路径
            startActivityForResult(intent, CAMERA);                        //返回照片路径

        }
        else if(v.getId()==R.id.text_wjmm)
        {
            Intent te1=new Intent(this,forgetpass.class);
            startActivity(te1);

        }
        else{
            System system = null;
            system.exit(0);
        }



    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 相册选择图片
        if (requestCode == Photo_ALBUM) {
            if (data != null) {       //开启了相册，但是没有选照片
                Uri uri = data.getData();
                //从uri获取内容的cursor
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                cursor.moveToNext();
                ImagePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA));   //获得图片的绝对路径
                cursor.close();
                Log.i("图片路径", ImagePath);
                bp = toolsUnit.getimage(ImagePath);
                //  iv_picture.setImageBitmap(bp);
                runthreaad();      //开启线程，传入图片
            }
        } else if (requestCode == CAMERA) {

                if(ImagePath==null)
                {return;}
                else {
                bp = toolsUnit.getimage(ImagePath);
                //  iv_picture.setImageBitmap(bp);
                runthreaad();  //开启线程，传入图片
                    }

        }
    }

    void runthreaad() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
                try {
                    byte[] bytes1 = toolsUnit.getBytesByBitmap(bp);

                    String image1 = Base64Util.encode(bytes1);

                    Map<String, Object> map = new HashMap<>();
                    map.put("image", image1);
                    map.put("liveness_control", "NORMAL");
                    map.put("group_id_list", "face");
                    map.put("image_type", "BASE64");
                    map.put("quality_control", "LOW");
                    String param = GsonUtils.toJson(map);
                    String clientId = "XLEhiC93w8n9uSNgA6uBv7dU";
                    String clientSecret = "8ksBKbrGdj9ni8FLK2jOoLbW2rgNr56n";
                    String accessToken = toolsUnit.getAuth(clientId, clientSecret);
                    result = HttpUtil.post(url, accessToken, "application/json", param);
                    System.out.println("hehehe:" + result);
                    Gson gson = new Gson();                      //新建GSON
                    Search_result_bean Result_bean = gson.fromJson(result, Search_result_bean.class); //GSON与我的工具类绑定
                    //  System.out.println("哈哈哈哈哈哈哈哈" + Result_bean.getError_code());
                    int Error_code = Result_bean.getError_code();
                    if (Error_code == 0) {                     //返回值为零，就是打卡识别成功

                        double score = Result_bean.getResult().getUser_list().get(0).getScore();   //一层层进入，获取到score

                        String user = Result_bean.getResult().getUser_list().get(0).getUser_id();   //获取用户名

                        //   System.out.println("分数：" + score);
                        if (score >= 78.0) {                                  //分数大于78.0分，判断为同一个人，提示打卡成功
                            flag=1;
                            flag2=1;
                            user2=user;
                            SQLiteDatabase db;
                            MyHelper ggg = new MyHelper(MainActivity.this);
                            db = ggg.getWritableDatabase();
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                            //  System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
                            ggg.Insert_two(db, "time_id", df.format(new Date()), user);


                            Looper.prepare();
                            Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_LONG).show();
                            Intent intent_te=new Intent(MainActivity.this,Menu.class);
                            intent_te.putExtra("username",user);
                            startActivity(intent_te);
                            Looper.loop();
                            finish();
                        } else {
                            flag2=0;
                            flag=0;
                            Looper.prepare();
                            Toast.makeText(MainActivity.this, "登录失败！照片不在人脸库", Toast.LENGTH_LONG).show();
                            Looper.loop();
                        }
                    } else {
                        flag=0;
                        flag2=0;
                        String error_message = "登录失败：" + Result_bean.getError_msg();
                        System.out.println("xixixixixixi" + error_message);

                        Looper.prepare();
                        Toast.makeText(MainActivity.this, error_message, Toast.LENGTH_LONG).show();
                        Looper.loop();
                    }

                } catch (Exception e) {
                    flag=0;
                    flag2=0;
                    Log.i("错误", "hahaha");
                    e.printStackTrace();
                }
            }
        }).start();
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
