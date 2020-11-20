package com.example.navigation2.Question

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import com.example.navigation2.Question.DBHelper.Question
import com.example.navigation2.Question.DBHelper.QuizDBHelper
import com.example.navigation2.R
import java.util.*

class QuizActivity : AppCompatActivity() {


    //btn
    private var txtQuestion: TextView? = null
    private var txtScore: TextView? = null
    private var txtQuestionCount: TextView? = null
    private var txtCounter: TextView? = null
    private var radioGroup: RadioGroup? = null
    private var r1: RadioButton? = null
    private var r2: RadioButton? = null
    private var r3: RadioButton? = null
    private var mSubmit: Button? = null

    private var txtColorDefault: ColorStateList? = null
    private var txtColorStateListCountDown: ColorStateList? = null
    private var questionCounter:Int = 0
    private var questionCounterTotal:Int = 0
    private var currentQuestion: Question? =null

    private var score:Int = 0
    private var     answered:Boolean = false

    private var onBackPressedTime: Long = 0

    private var countDownTimer: CountDownTimer? = null

    private var questionList:List<Question>?=null

    private  var categoryValue:String ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        //begin use basic btn txt
        txtQuestion = findViewById(R.id.text_view_question)
        txtScore = findViewById(R.id.text_view_score)
        txtQuestionCount = findViewById(R.id.text_view_question_count)
        //txtCounter = findViewById(R.id.text_view_countdown)
        radioGroup = findViewById(R.id.radio_group)
        r1 = findViewById(R.id.radio_button1)
        r2 = findViewById(R.id.radio_button2)
        r3 = findViewById(R.id.radio_button3)
        mSubmit = findViewById(R.id.button_confirm_next)

        txtColorDefault = r1!!.textColors
        //txtColorStateListCountDown = txtCounter!!.textColors


        val dbHelper =
            QuizDBHelper(this)
        val intentCategory : Intent = intent
        categoryValue = intentCategory.getStringExtra("Category")

        //let dùng để định nghĩa một biến trong 1 phạm vi cụ thể
        questionList = categoryValue?.let { dbHelper.getQuestions(it) }


        questionCounterTotal = questionList!!.size
        //Trộn ngẫu nhiên các phần tử trong questionList
        Collections.shuffle(questionList!!)
        //get quiz in db
        showQuestion()

        mSubmit!!.setOnClickListener {
            if(!answered){
                if(r1!!.isChecked || r2!!.isChecked || r3!!.isChecked ){
                    check()
                } else {
                    Toast.makeText(this@QuizActivity,"Vui Lòng Chọn 1 Đáp Án", Toast.LENGTH_SHORT).show()
                }
            } else{
                showQuestion()
            }
        }

    }

    private fun showQuestion(){
        //'!!' tranh viec kiem tra null khi ban chac chan no ko null
        r1!!.setTextColor(txtColorDefault)
        r2!!.setTextColor(txtColorDefault)
        r3!!.setTextColor(txtColorDefault)

        radioGroup!!.clearCheck()

        if(questionCounter<questionCounterTotal){
            currentQuestion = questionList!![questionCounter]

            txtQuestion!!.text = currentQuestion!!.getQuestion()
            r1!!.text = currentQuestion!!.getOption1()
            r2!!.text = currentQuestion!!.getOption2()
            r3!!.text = currentQuestion!!.getOption3()

            questionCounter ++
            //So cau hoi
            txtQuestionCount!!.text = "Question: $questionCounter / $questionCounterTotal"

            answered = false
            mSubmit!!.text = "Confirm"
        }
        else  {
            finishQuiz()
        }
    }

    private fun check(){

        answered = true
        // countDownTimer!!.cancel()

        //selected answer click
        val radioSelected = findViewById<View>(radioGroup!!.checkedRadioButtonId) as RadioButton
        //select answer
        val answer = radioGroup!!.indexOfChild(radioSelected) + 1

        if(answer == currentQuestion!!.getAnswer()){
            score++
            txtScore!!.text = "Score: $score"
        }
        showRightAns()
    }

    private fun showRightAns(){
        r1!!.setTextColor(Color.RED)
        r2!!.setTextColor(Color.RED)
        r3!!.setTextColor(Color.RED)

        when(currentQuestion!!.getAnswer()){
            1->{
                r1!!.setTextColor(Color.GREEN)
            }
            2->{
                r2!!.setTextColor(Color.GREEN)
            }
            3->{
                r3!!.setTextColor(Color.GREEN)
            }
        }
        if(questionCounter<questionCounterTotal){
            mSubmit!!.text = "Next"
        } else {
            mSubmit!!.text = "Finish"
        }
    }
    private fun finishQuiz(){

        val intent = Intent(this,QuizResult::class.java)
        intent.putExtra("Score",score)
        startActivity(intent)

    }

    override fun onBackPressed() {
        if (onBackPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz()
        } else {
            Toast.makeText(this@QuizActivity, "Không Thể Quay Lại", Toast.LENGTH_SHORT).show()
        }
        onBackPressedTime = System.currentTimeMillis()
    }





}