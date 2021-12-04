package com.example.a11630.domain;

import android.app.Activity;
import android.os.Bundle;
//import android.support.annotation.Nullable;
//import androidx.annotation.Nullable;

//import android.support.annotation.Nullable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;


import com.example.a11630.face_new.R;


public class RegisterActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button bt_tem=findViewById(R.id.btn_login);
        bt_tem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }
}
