package com.example.navigation2.Question.DBHelper

open class Question {


    companion object{
        val CATEGORY_HTD = "htd"
        val CATEGORY_HTTD = "httd"
        val CATEGORY_HTHT = "htht"
        val CATEGORY_HTHTTD = "httdht"

        val CATEGORY_QKD = "qkd"
        val CATEGORY_QKTD = "qktd"
        val CATEGORY_QKHT = "qkht"
        val CATEGORY_QKHTTD = "qkhttd"

        val CATEGORY_TLD = "tld"
        val CATEGORY_TLTD = "tld"
        val CATEGORY_TLHT = "tlht"
        val CATEGORY_TLHTTD = "tlhttd"
        val CATEGORY_TOTALEXE1 = "totalexe1"

    }

    private var question:String ?= null
    private var option1:String ?=null
    private var option2:String ?=null
    private var option3:String ?=null
    private var answer:Int =0
    private var category:String ?=null

    constructor()
    // khởi tạo các giá trị ban đầu cho các đối tượng khi cấp phát bộ nhớ
    constructor(question:String,option1:String,option2:String,option3:String,answer:Int,category:String){
        this.question = question
        this.option1 = option1
        this.option2 = option2
        this.option3 = option3
        this.answer = answer
        this.category = category
    }


    fun getQuestion(): String? {
        return question
    }

    fun setQuestion(question: String) {
        this.question = question
    }

    fun getOption1(): String? {
        return option1
    }

    fun setOption1(option1: String) {
        this.option1 = option1
    }

    fun getOption2(): String? {
        return option2
    }

    fun setOption2(option2: String) {
        this.option2 = option2
    }

    fun getOption3(): String? {
        return option3
    }

    fun setOption3(option3: String) {
        this.option3 = option3
    }

    fun getAnswer(): Int {
        return answer
    }

    fun setAnswer(answer: Int) {
        this.answer = answer
    }

    fun getCategory(): String? {
        return category
    }

    fun setCategory(answer: Int) {
        this.category = category
    }



//    var mQuestion: String
//        get() = question!!
//        set(value){
//            question = value
//        }
//    var mOption1 : String
//        get() = option1!!
//    set(value) {
//        option1 = value
//    }
//    var mOption2 : String
//        get() = option2!!
//        set(value) {
//            option2 = value
//        }
//    var mOption3 : String
//        get() = option3!!
//        set(value) {
//            option3 = value
//        }
//    var mAnswer : Int
//        get() = answer
//        set(value) {
//            answer = value
//        }
//    var mCategory : String
//        get() = category!!
//        set(answer) {
//            category = answer
//        }



}