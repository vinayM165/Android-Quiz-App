package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout

class StartActivity : AppCompatActivity() {
    lateinit var play : RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        play = findViewById(R.id.play_btn)
        play.setOnClickListener(View.OnClickListener {
            startActivity(Intent(baseContext,MainActivity::class.java))
        })
    }
}