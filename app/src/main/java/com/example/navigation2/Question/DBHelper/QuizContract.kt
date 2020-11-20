package com.example.navigation2.Question.DBHelper

import android.provider.BaseColumns

object QuizContract {
    //đinh nghĩa bảng
    // Table contents are grouped together in an anonymous object.
    class QuizTable : BaseColumns {
        companion object{
            val TABLE_NAME = "quiz_question"
            val COLUMN_QUESTION = "question"
            val COLUMN_OPTION1 = "option1"
            val COLUMN_OPTION2 = "option2"
            val COLUMN_OPTION3 = "option3"
            val COLUMN_ANSWER_NR = "answer"
            val COLUMN_CATEGORY = "category"

        }

    }
}