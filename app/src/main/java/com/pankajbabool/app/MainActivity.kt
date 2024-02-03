package com.pankajbabool.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pankajbabool.modules.sayHelloWorld

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<View?>(android.R.id.content).setOnClickListener {
            sayHelloWorld(this)
        }
    }
}