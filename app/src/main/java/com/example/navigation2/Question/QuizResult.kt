package com.example.navigation2.Question

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.navigation2.Exercise.Exercise
import com.example.navigation2.R
import kotlinx.android.synthetic.main.activity_quiz_result.*

class QuizResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        val txtScore = findViewById<TextView>(R.id.txt_score)

        val scoreTotal = intent.getIntExtra("Score",0)

        txtScore.text = "Số Câu Trả Lời Đúng Của Bạn Là: $scoreTotal"
        nextActivity()
    }

    override fun onBackPressed() {

        Toast.makeText(this@QuizResult, "Không Thể Quay Lại", Toast.LENGTH_SHORT).show()

    }

    fun nextActivity(){
        btn_finishZ.setOnClickListener {
            val intent = Intent(this@QuizResult, Exercise::class.java)
            startActivity(intent)
        }
    }
}