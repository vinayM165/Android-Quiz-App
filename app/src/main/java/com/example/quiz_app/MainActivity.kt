package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    private var currentQuestion : Int = 1
    private var selectedIndex : Int = -1
    var score : Int = 0
    var timer : CountDownTimer? = null
    private  lateinit var question : TextView
    private  lateinit var Opt1 : TextView
    private  lateinit var Opt2 : TextView
    private  lateinit var Opt3 : TextView
    private  lateinit var Opt4 : TextView
    private lateinit var qList: List<Question>
    private lateinit var progressBar: ProgressBar
    private lateinit var  tv_progressStatus: TextView
    private lateinit var progress_timer: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        qList = Constant.getQuestions()
        question= findViewById(R.id.tv_question)
        progressBar = findViewById(R.id.progressBar)
        tv_progressStatus = findViewById(R.id.progressBar_position)
        Opt1= findViewById(R.id.tv_option_first)
        Opt2= findViewById(R.id.tv_option_second)
        Opt3 = findViewById(R.id.tv_option_third)
        Opt4 = findViewById(R.id.tv_option_fourth)
        progress_timer = findViewById(R.id.p_timer)
        setQue()
    }
    @SuppressLint("SetTextI18n")
    fun setQue(){
        val que = qList[currentQuestion - 1]
        setDefault()
        question.text = que.question
        Opt1.text = que.firstOption
        Opt2.text = que.secondOption
        Opt3.text = que.thirdOption
        Opt4.text = que.fourthOption
        progressBar.progress = currentQuestion
        progressBar.max = qList.size
        tv_progressStatus.text = "$currentQuestion/${qList.size}"
        progress_timer.progress = 0
        timer = object : CountDownTimer(30000, 1000){
            override fun onTick(millisUntilFinished: Long) {

               progress_timer.setProgress((millisUntilFinished/100).toInt())
            }
            override fun onFinish() {
               Toast.makeText(baseContext,"finished",Toast.LENGTH_LONG).show()
                selectedIndex = 5
                next()
            }
        }
        (timer as CountDownTimer).start()
        var all : ArrayList<TextView> = arrayListOf(
            Opt1, Opt2, Opt3, Opt4
        )
        all.forEach {
            it.setOnClickListener(optionClickListner())
        }


//        View.OnClickListener {
//            when(it){
//                Opt1 -> setSelectedOption(Opt1,1)
//                Opt2 -> setSelectedOption(Opt2,2)
//                Opt3 -> setSelectedOption(Opt3,3)
//                Opt4 -> setSelectedOption(Opt4,4)
//                submit -> next()
//            }
//        }

    }
    fun optionClickListner() : View.OnClickListener {
        return View.OnClickListener {
            when (it) {
                Opt1 -> setSelectedOption(Opt1, 1)
                Opt2 -> setSelectedOption(Opt2, 2)
                Opt3 -> setSelectedOption(Opt3, 3)
                Opt4 -> setSelectedOption(Opt4, 4)

            }
        }
    }
    fun next() {
        var curQ = qList[currentQuestion - 1]
        if (selectedIndex == -1) {
//            Toast.makeText(baseContext, "Select any option", Toast.LENGTH_LONG).show()
            return
        } else {
            if (curQ.answer == selectedIndex) {
                score++
            }
            if (currentQuestion == qList.size ) {
                startActivity(Intent(baseContext, ResultActivity::class.java).also {
                    it.putExtra("score", score.toString())
                    it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NEW_TASK )
                })
            }
            if(currentQuestion <= qList.size-1) {
                currentQuestion++
                selectedIndex = -1
//                Log.d(
//                    "vinay",
//                    "Question.name = ${curQ.question} , currQu = ${currentQuestion} , score = ${score}, currentInde = ${selectedIndex} "
//                )
                timer?.cancel()
                setQue()
            }
        }
    }
    fun setSelectedOption(tv: TextView, selectedOptionIndex: Int) {
        selectedIndex = selectedOptionIndex
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
        val handler = Handler()
        handler.postDelayed({
            next()
        }, 1000)

    }
    fun setDefault(){

        val options: ArrayList<TextView> = arrayListOf(
            Opt1, Opt2, Opt3, Opt4
        )
        options.forEach {
            it.setTextColor(Color.parseColor("#7A8089"))
            it.typeface = Typeface.DEFAULT
            it.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}



