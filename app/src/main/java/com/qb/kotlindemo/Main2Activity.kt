package com.qb.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.qb.kotlindemo.model1.packageHello
import com.qb.kotlindemo.model1.printHello
import com.qb.kotlindemo.model1.setIcon


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById(R.id.bt2).setOnClickListener {
            printHello()
            val image: ImageView = findViewById(R.id.iv) as ImageView
            image.setIcon()
            packageHello()
        }
    }
}
