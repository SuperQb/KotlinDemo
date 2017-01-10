package com.qb.kotlindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.qb.kotlindemo.model1.CompanionObject;
import com.qb.kotlindemo.model1.Data;
import com.qb.kotlindemo.model1.DataM;
import com.qb.kotlindemo.model1.DataS;
import com.qb.kotlindemo.model1.DemoKt;
import com.qb.kotlindemo.model1.JsonData;
import com.qb.kotlindemo.model1.OverLoad;
import com.qb.kotlindemo.model1.Singleton;
import com.qb.kotlindemo.model2.ModelTwo;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=null;
                str="test";
                Data data=new Data(str);
                Log.i(TAG, "onClick: "+data.toString());
                data.a="lalal";
                Log.i(TAG, "onClick: "+data.toString());
                Singleton.INSTANCE.printHello();

                OverLoad overLoad=new OverLoad();
                overLoad.overLoad(1,2,3);
                overLoad.overLoadJava(1);
                DemoKt.printHello();
                Log.i(TAG, "onClick: "+ DemoKt.notEmpty("test"));
                DemoKt.toast(MainActivity.this,"test");

                DataS datas=new DataS("222");
                datas.printA();

                DataM datam=new DataM();
                datam.printA();


                Log.i(TAG, "onClick: "+ CompanionObject.Companion.getName());
                ModelTwo model=new ModelTwo();
                model.run();
                JsonData jsonData=new JsonData(data);
                jsonData.getA().printA();
            }
        });
    }
}

