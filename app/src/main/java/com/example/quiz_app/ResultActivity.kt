package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val score = intent.getStringExtra("score")
        val tv_score = findViewById<TextView>(R.id.r_score)
        tv_score.text = "Your score was $score correct answers"
        val btn= findViewById<Button>(R.id.btn_play_again)
        btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(baseContext,StartActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
        })
    }
}