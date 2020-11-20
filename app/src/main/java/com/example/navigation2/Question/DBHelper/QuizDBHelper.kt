package com.example.navigation2.Question.DBHelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.navigation2.Question.DBHelper.QuizContract.QuizTable.Companion.COLUMN_ANSWER_NR
import com.example.navigation2.Question.DBHelper.QuizContract.QuizTable.Companion.COLUMN_CATEGORY
import com.example.navigation2.Question.DBHelper.QuizContract.QuizTable.Companion.COLUMN_OPTION1
import com.example.navigation2.Question.DBHelper.QuizContract.QuizTable.Companion.COLUMN_OPTION2
import com.example.navigation2.Question.DBHelper.QuizContract.QuizTable.Companion.COLUMN_OPTION3
import com.example.navigation2.Question.DBHelper.QuizContract.QuizTable.Companion.COLUMN_QUESTION
import com.example.navigation2.Question.DBHelper.QuizContract.QuizTable.Companion.TABLE_NAME


class QuizDBHelper(private var context: Context): SQLiteOpenHelper(context,
    DATABASE_NAME,null,
    DATABASE_VER
) {

    private var db: SQLiteDatabase? = null
    companion object{
        val SQL_CREATE_QUESTIONS_TABLE: String =
            ("CREATE TABLE $TABLE_NAME ($COLUMN_QUESTION TEXT,$COLUMN_OPTION1 TEXT,$COLUMN_OPTION2 TEXT" +
                    ",$COLUMN_OPTION3 TEXT,$COLUMN_ANSWER_NR INTEGER,$COLUMN_CATEGORY TEXT)")
        val SQL_DELETE_ENTRIES:String =("DROP TABLE IF EXISTS $TABLE_NAME")

        // If you change the database schema, you must increment the database version.
        const val DATABASE_VER = 2
        const val DATABASE_NAME = "MyAwesomeQuiz.db"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        this.db = db
        db!!.execSQL(SQL_CREATE_QUESTIONS_TABLE)
        fillQuestionTable()

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    private fun fillQuestionTable(){

        //HTD
        val q1 = Question(
            "My teacher (have)...  long hair. ", "Have", "Has", "had", 2, Question.CATEGORY_HTD
        )
        addQuestion(q1)
        val q2 = Question(
            " They (not want )...to play the love games, but they (play)...now.", "isn't want, plays", "doesn't want, plays", "don’t want, are playing", 3, Question.CATEGORY_HTD
        )
        addQuestion(q2)
        val q3 = Question(
            "...Marry (be) an English person?- Yes, she (speak)...English at the meeting right now.", "Are, is speaking", "Is, is speaking", "Is, are speaking", 2, Question.CATEGORY_HTD
        )
        addQuestion(q3)
        val q4 = Question(
            "Look! The man (climb)……..up the tree.", "is climbing", "climbs", "are climbing", 1, Question.CATEGORY_HTD
        )
        addQuestion(q4)
        val q5 = Question(
            "The new comers (not know)...the rules of the club.", "don’t know", "isn't knowing", "aren't knowing", 2, Question.CATEGORY_HTD
        )
        addQuestion(q5)
        val q6 = Question(
            " What is the new chairman (do)...now. I (see)...that he (be)...very busy.", "doing, see, is", "do, see, is", "doing, sees, is", 1, Question.CATEGORY_HTD
        )
        addQuestion(q6)
        val q7 = Question(
            " I _____ (be) a student", "am", "is", "are", 1, Question.CATEGORY_HTD
        )
        addQuestion(q7)
        val q8 = Question(
            "My father __________ excuses when I feel like going to the cinema.", "make always", "make alway", "always makes", 3, Question.CATEGORY_HTD
        )
        addQuestion(q8)
        val q9 = Question(
            " His students ________ (not, speak) German in class.", "don’t speak", "doesn’t speak", "not speak", 1, Question.CATEGORY_HTD
        )
        addQuestion(q9)
        val q10 = Question(
            "She ________ (not, be) six years old.", ". isn't", " not is", "are not", 1, Question.CATEGORY_HTD
        )
        addQuestion(q10)
        /* Điền Hiện tại ở đây*/
        //HTTD q11-15
        val q11 = Question(
            "Harry often ______ books from the library.", ".borrows ", " is borrowing", "are borrowing", 2, Question.CATEGORY_HTTD
        )
        addQuestion(q11)
        val q12 = Question(
            "My grandfather ______ collecting stamps.", ".is loving ", " are loving", "loves", 3, Question.CATEGORY_HTTD
        )
        addQuestion(q12)
        val q13 = Question(
            "She ______ her friends at a bar right now.", ".waiting  ", " is waiting", "waits", 2, Question.CATEGORY_HTTD
        )
        addQuestion(q13)
        val q14 = Question(
            " Nguyen Nhat Anh is a writer. He ______ a short story about a dragon.", ".is writing ", " writes ", "are writing", 1, Question.CATEGORY_HTTD
        )
        addQuestion(q14)
        val q15 = Question(
            " I never ______ home late.", ".come  ", " is coming", "am coming", 1, Question.CATEGORY_HTTD
        )
        addQuestion(q15)

        //HTHT q16-20
        val q16 = Question(
            " My granny _______________ that detective novel.", ".has already read  ", " has yet read", "readed", 1, Question.CATEGORY_HTHT
        )
        addQuestion(q16)
        val q17 = Question(
            " There _______________ a lot of changes in Vietnam since the 1990s.", ".was  ", " have been", "has been", 2, Question.CATEGORY_HTHT
        )
        addQuestion(q17)
        val q18 = Question(
            " It _______________ him almost 1 hour to go to school by bus every day.", ".takes  ", " took", "has taking", 3, Question.CATEGORY_HTHT
        )
        addQuestion(q18)
        val q19 = Question(
            " Her hometown _______________ a lot of hills and mountains.", ".has  ", " gets", "is", 1, Question.CATEGORY_HTHT
        )
        addQuestion(q19)
        val q20 = Question(
            " My dog _______________ my cat since I came home.", ".is chasing  ", " has chased", "chased", 2, Question.CATEGORY_HTHT
        )
        addQuestion(q20)

        //HTHTD q21-25
        val q21 = Question(
            " We …… around Scotland for 8 days.", ".Traveled   ", " Have been travelling", "Has been travelling", 2, Question.CATEGORY_HTHTTD
        )
        addQuestion(q21)
        val q22 = Question(
            " Jonathan.....................in God since he was a child", ".believed  ", " has been believing", "have been believing", 2, Question.CATEGORY_HTHTTD
        )
        addQuestion(q22)
        val q23 = Question(
            " I..................... the book, you can have it back", ".has been reading  ", " have been reading", "have read", 2, Question.CATEGORY_HTHTTD
        )
        addQuestion(q23)
        val q24 = Question(
            " Why are your hands so dirty? - I.....................my bike.", ".have been repaired  ", " has been repaired", "have been repairing", 3, Question.CATEGORY_HTHTTD
        )
        addQuestion(q24)
        val q25 = Question(
            " We...............around Scotland for 8 years", ".travelled  ", " have travelled", "have been travelling", 3, Question.CATEGORY_HTHTTD
        )
        addQuestion(q25)


        /* Dien qua khu o day*/
        //với q = 26 -45
        //QKD

        val q26 = Question("I (be)___ a student in Moloxop School in 1998", "was", "were", "“to be”", 1, Question.CATEGORY_QKD)
        addQuestion(q26)
        val q27 = Question(
            "A number of duck (go) ___ through here", "yesterday.", "go", "goes", 3, Question.CATEGORY_QKD)
        addQuestion(q27)
        val q28 = Question(
            "“She (win) ___ the gold medal in 1986.”", "win", "won", "to won", 2, Question.CATEGORY_QKD)
        addQuestion(q28)
        val q29 = Question(
            "“He had taught in this school before he (leave)____ for London.”", "left", "leave", "to won", 1, Question.CATEGORY_QKD)
        addQuestion(q29)
        val q30 = Question(
            " “I didn’t (see)_____ you before.”", "see", "saw", "seen", 1, Question.CATEGORY_QKD)
        addQuestion(q30)
        //QKTD

        val q31 = Question(
            "“While people were talking to each other, he ………………… his book.”", "read", "was reading", "were reading", 2, Question.CATEGORY_QKTD
        )
        addQuestion(q31)
        val q32 = Question(
            "“While we ……………….. in the park, Mary fell over.”", "go", "run", "were running", 3, Question.CATEGORY_QKTD)
        addQuestion(q32)
        val q33 = Question(
            " “They ………………. football on TV all day.”", "watching"," were watching", "watched", 2, Question.CATEGORY_QKTD)
        addQuestion(q33)
        val q34 = Question(
            " “While I (drive) _____  home, Peter was trying desperately to contact me”", "was driving", "drove", "was drive", 1, Question.CATEGORY_QKTD )
        addQuestion(q34)
        val q35 = Question(
            "“In the 1990s few people (use) _____ mobile phones.”", "were using"," used"," using", 1, Question.CATEGORY_QKTD)
        addQuestion(q35)
        //QKHT
        val q36 = Question(
            " “She _________ the ocean before she moved to Vancouver.”", "has never seen", "had never seen", "have never seen", 2, Question.CATEGORY_QKHT
        )
        addQuestion(q36)
        val q37 = Question(
            "“The teacher ________ out when I arrived in the classroom.”", "goes", "has gone", "had gone", 3, Question.CATEGORY_QKHT)
        addQuestion(q37)

        val q38 = Question(
            "“I ______ my document before the power went out in the computer lab”","had save", "had saved", "saved", 2, Question.CATEGORY_QKHT)
        addQuestion(q38)
        val q39 = Question(
            " “When they arrived we _________ the test.”", "had already started", "have already started", "already starting", 1, Question.CATEGORY_QKHT
        )
        addQuestion(q39)
        val q40 = Question(
            "“George _________ his furniture before he moved to Japan”", "had sold", "have sold", "sold", 1, Question.CATEGORY_QKHT)
        addQuestion(q40)

        //QKHTTD

        val q41 = Question(
            "“We (sleep)___________ for 12 hours when he woke us up”", "sleeping", "had been sleeping"," were sleeping", 2, Question.CATEGORY_QKHTTD
        )
        addQuestion(q41)
        val q42 = Question(
            "“They (wait)________ at the station for 90 minutes when the train finally arrived”", "had waiting", "waiting", "had been waiting", 3, Question.CATEGORY_QKHTTD
        )
        addQuestion(q42)

        val q43 = Question(
            "“We (look for)_______ her ring for two hours and then we found it in the bathroom”", "have been looking for", "had been looking for", "look for", 2, Question.CATEGORY_QKHTTD
        )
        addQuestion(q43)
        val q44 = Question(
            " “He (drive)________less than an hour when he ran out of petrol”", "had been driving", "drove", "was driving", 1, Question.CATEGORY_QKHTTD
        )
        addQuestion(q44)
        val q45 = Question(
            "“They (cycle)_____ all day so their legs were sore in the evening”", "had been cycling", "cyling", "have been cycling", 1, Question.CATEGORY_QKHTTD
        )
        addQuestion(q45)
        /*Điền tương lai ở đây*/
        //với q = 45 - 65
        //TLD
        val q46 = Question(
            " By the time we get there, the store ________ (close).", ".will close  ", " will have closed", "closed", 2, Question.CATEGORY_TLD
        )
        addQuestion(q46)
        val q47 = Question(
            " I ________ (see) you tomorrow at 3:00 PM.", ".will see  ", " see", "will be seeing", 1, Question.CATEGORY_TLD
        )
        addQuestion(q47)
        val q48 = Question(
            " After we finish this video, I ________ (see) all of this director’s movies.", ".will see", " will be seeing", "will have seen", 3, Question.CATEGORY_TLD
        )
        addQuestion(q48)
        val q49 = Question(
            " This time next week I ________ (drink) wine in Argentina.", ".will drink  ", " drink", "will be drinking", 3, Question.CATEGORY_TLD
        )
        addQuestion(q49)
        val q50 = Question(
            " She doesn’t realize what kind of person he is, but she ________ (find out).", ".will find out  ", " will be finding out", "will have found out", 1, Question.CATEGORY_TLD
        )
        addQuestion(q50)

        //TLTD
        val q51 = Question(
            " They ............pingpong when their father comes back home.", ".will play  ", " will be playing", "would play", 2, Question.CATEGORY_TLTD
        )
        addQuestion(q51)
        val q52 = Question(
            " I’m going on holiday on Saturday.This time next week I............on a beach in the sea. ", ".will lie ", " am lying", "will be lying", 3, Question.CATEGORY_TLTD
        )
        addQuestion(q52)
        val q53 = Question(
            " At 8 o’clock this evening my friends and I ________ a famous film at the cinema.", ". were watching ", " will be watching", " have been watching", 2, Question.CATEGORY_TLTD
        )
        addQuestion(q53)
        val q54 = Question(
            " They ________ their presentation at this time tomorrow morning.", ".are making", " are going to make", "will be making", 3, Question.CATEGORY_TLTD
        )
        addQuestion(q54)
        val q55 = Question(
            " When they (come) tomorrow, we (swim) in the sea.", ".come - swim  ", " are coming - swim", " come - will be coming", 3, Question.CATEGORY_TLTD
        )
        addQuestion(q55)




        //TLHT
        val q56 = Question(
            "By the end of next year, Geoge............…English for 2 years.", ". will have learned", " will learn", " has learned", 1, Question.CATEGORY_TLHT
        )
        addQuestion(q56)
        val q57 = Question(
            " I like looking at these pictures, but I.............enough by lunch time.", ".should have", " will have", " will have had", 3, Question.CATEGORY_TLHT
        )
        addQuestion(q57)
        val q58 = Question(
            "When will you send the message? - We _________ it by Friday.", ".will deliver", " will be delivering", " will have delivered", 3, Question.CATEGORY_TLHT
        )
        addQuestion(q58)
        val q59 = Question(
            " Can we start the party at 3 o'clock? - I don't think so. All our guests ________ by then, I'm afraid.", ".won't have arrived", " haven't arrived", "didn't arrive", 2, Question.CATEGORY_TLHT
        )
        addQuestion(q59)
        val q60 = Question(
            " ____________ her homework before 10 a.m tomorrow?", ".Will have she done", " Will has she done", " Will she have done", 3, Question.CATEGORY_TLHT
        )
        addQuestion(q60)

        //TLHTTD
        val q61 = Question(
            " By November I _____ (work) for this company for 6 years.", ".will have worked", "will have been working", "will have been worked", 2, Question.CATEGORY_TLHTTD
        )
        addQuestion(q61)
        val q62 = Question(
            "By March 15, I ______ (be) here for one year.", ".will have been", " will have been being", " will be", 2, Question.CATEGORY_TLHTTD
        )
        addQuestion(q62)
        val q63 = Question(
            " By this time next week, he ______ (write) his novel  for 6 months.", ".will have written", " will have been writing", " Will writte", 2, Question.CATEGORY_TLHTTD
        )
        addQuestion(q63)
        val q64 = Question(
            " You _______ (finish) your work by 9 tonight?", ".Will you have finished", " Will you have been finishing", " Will finished", 2, Question.CATEGORY_TLHTTD
        )
        addQuestion(q64)
        val q65 = Question(
            " By 2013 we ______ (live) in London for 14 years.", ".will have lived", " will have been living", " Will lived", 2, Question.CATEGORY_TLHTTD
        )
        addQuestion(q65)

        ///exe total

        val q66 = Question(
            " There's someone at the door. ", ".I'll go.", ".I'll make you a sandwich, if you like.", ".In that case, I won't go. I hate crowds", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q66)
        val q67 = Question(
            "You __________ (have) an excellent job.", "won’t have", "will has", "will have", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q67)
        val q68 = Question(
            "I __________ my eye tested tomorrow.", "have", "am having", "am going to have", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q68)
        val q69 = Question(
            "Keep silent! My father __________ in his room.", "is sleeping", "was sleeping", "has slept", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q69)
        val q70 = Question(
            "He __________ us the house where he was born.", "showed", "had shown", "be showing", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q70)
        val q71 = Question(
            "David not only finished the homework well but also	__________ extra-exercises.", "done", "had did", "did", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q71)
        val q72 = Question(
            "He never __________ to that restaurant once again.", "go", "goes", "gone", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q72)
        val q73 = Question(
            "Peter __________ home as soon as he came over the supermarket.", "went", "goes", "going", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q73)
        val q74 = Question(
            "Cities now __________ separated into smaller communities.", "is being", "are being", "is", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q74)
        val q75 = Question(
            "I __________ reading the book before 9 o’clock this evening.", "will be finishing", "will have finished", "will finish", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q75)
        val q76 = Question(
            "I __________ my grandma two days ago.", "meet", "meets", "met", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q76)
        val q77 = Question(
            "Columbus __________ in the New World in 1492.", "arrive", "arrived", "is arriving", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q77)
        val q78 = Question(
            "Our team __________ 4 gold medals this season.", "has won", "win", "is winning", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q78)
        val q79 = Question(
            "My last birthday was the worst day I __________ ", "had", "have ever", "have ever had", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q79)
        val q80 = Question(
            "She __________ for that company for 4 years. ", "had worked", "worked", "has been working", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q80)
        val q81 = Question(
            "_____________ this before 2012. ", "Had you ever seen", "Did you ever", "Have you", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q81)
        val q82 = Question(
            "She __________ his proposal last year. ", "do not", "have not refused", "did not refuse", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q82)
        val q83 = Question(
            "I ________________ in London by the time your wedding is held. ", "am studying", "will be studying", "will studying", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q83)
        val q84 = Question(
            "He __________ to church twice a week. ", "did go", "went", "goes", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q84)
        val q85 = Question(
            "I __________ the road when I saw Harry. ", "were crossing", "was crossing", "am crossing", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q85)
        val q86 = Question(
            "Harry Potter is the most fascinating film I __________ ", "had seen", "saw", "have seen", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q86)
        val q87 = Question(
            "They __________ on the country lanes tomorrow morning.", "will drive", "are driving", "will be driving", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q87)
        val q88 = Question(
            "This task seems difficult. I __________ you.", "will be helping", "will help", "help", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q88)
        val q89 = Question(
            "He __________ home by the fime I arrived.", "had gone", "went", "goes", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q89)
        val q90 = Question(
            "When I arrived, he ____________ TV and she ____________ .", "was watching - was cooking", "watched - cooked", "watched — was cooking", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q90)
        val q91 = Question(
            "I did not watch the film because I __________ it before.", "have seen", "had seen", "has seen", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q91)
        val q92 = Question(
            "Where have you been?- I __________ for you for 3 hours.", "have been waiting", "am	waiting", "waited", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q92)
        val q93 = Question(
            "He __________ as an English teacher in my school.", "has worked", "worked", "works", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q93)
        val q94 = Question(
            "I can't go outside. It __________ for 3 hours.", "rains", "has rained", "has been raining", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q94)
        val q95 = Question(
            "By the time you get there, the shop __________ .", "has closed", "will have closed", "closes", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q95)
        val q96 = Question(
            "Mum got angry because I _____________ up my room.", "did not fidy", "had fidy", "had not tidied", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q96)
        val q97 = Question(
            "I _____________ coffee at Roberto's at 3 PM yesterday.", "was having", "had", "have had", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q97)
        val q98 = Question(
            "She _____________ about her heavy workload.", "complain", "always complained", "is always complaining", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q98)
        val q99 = Question(
            "Lynda _____________ Yorkshire so many times.", "visited", "visits", "has visited", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q99)
        val q100 = Question(
            "I _____________ up the photo album Amy had made.", "packed", "packs", "be packing", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q100)
        val q101 = Question(
            "When 1 fell down, you _____________ there holding me up.", "has been", "will be", "would be", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q101)
        val q102 = Question(
            "He insulted  her. She _____________ to him again.", "will speak", "will never speak", "doesn’t speak", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q102)
        val q103 = Question(
            "They _____________ English before they went to London.", "learnt", "had learnt", "have learnt", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q103)
        val q104 = Question(
            "Rory was tired. He _____________ in the garden all day.", "was working", "worked", "works", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q104)
        val q105 = Question(
            "You _____________ for the key, aren't you?", "have looked", "look", "are looking", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q105)
        val q106 = Question(
            "I hope I _____________ the course by May.", "will have finished", "will be finished", "finish", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q106)
        val q107 = Question(
            "They always _____________ their holidays together in Italy.", "spend", "is spending", "spends", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q107)
        val q108 = Question(
            "After she _____________ engaged, I will have moved to a new house.", "have", "have got", "gets", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q108)
        val q109 = Question(
            "I came across my old ball while I _____________ upmy room.", "tidied", "was tidying", "tidy", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q109)
        val q110 = Question(
            "Unlike him, she _____________ 10 books.", "has written", "wrote", "write", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q110)
        val q111= Question(
            "The train to Barcelona _____________ at 3 AM next Monday.", "is leaving", "leaves", "be leaving", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q111)
        val q112 = Question(
            "After she _____________ engaged, I will have moved to a new house.", "have", "have got", "gets", 3, Question.CATEGORY_TOTALEXE1)
        addQuestion(q112)
        val q113 = Question(
            "I came across my old ball while I _____________ upmy room.", "tidied", "was tidying", "tidy", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q113)
        val q114 = Question(
            "Unlike him, she _____________ 10 books.", "has written", "wrote", "write", 1, Question.CATEGORY_TOTALEXE1)
        addQuestion(q114)
        val q115= Question(
            "The train to Barcelona _____________ at 3 AM next Monday.", "is leaving", "leaves", "be leaving", 2, Question.CATEGORY_TOTALEXE1)
        addQuestion(q115)










    }

    private fun addQuestion(question: Question){

        //lưu các giá trị tương ứng với các trường trong bảng
        val cv = ContentValues().apply {
            put(COLUMN_QUESTION,question.getQuestion())
            put(COLUMN_OPTION1,question.getOption1())
            put(COLUMN_OPTION2,question.getOption2())
            put(COLUMN_OPTION3,question.getOption3())
            put(COLUMN_ANSWER_NR,question.getAnswer())
            put(COLUMN_CATEGORY,question.getCategory())
        }
        // Insert the new row, returning the primary key value of the new row
        db!!.insert(TABLE_NAME,null,cv)


    }


    fun getQuestions(category: String): ArrayList<Question>{
        val questionList: ArrayList<Question> = ArrayList()
        db = readableDatabase
        val selectionArgs = arrayOf(category)

        //lưu giá trị trả về của câu lệnh sql
        val c: Cursor = db!!.rawQuery("SELECT * FROM " + TABLE_NAME.toString() +
                " WHERE " + COLUMN_CATEGORY.toString() + " = ?", selectionArgs)

        if(c.moveToFirst()){//di chuyển con trỏ cursor lên dòng đầu tiên
            do {
                val questions = Question()
                questions.setQuestion(c.getString(c.getColumnIndex( COLUMN_QUESTION)))
                questions.setOption1(c.getString(c.getColumnIndex(COLUMN_OPTION1)))
                questions.setOption2(c.getString(c.getColumnIndex(COLUMN_OPTION2)))
                questions.setOption3(c.getString(c.getColumnIndex(COLUMN_OPTION3)))
                questions.setAnswer(c.getInt(c.getColumnIndex(COLUMN_ANSWER_NR)))
                questions.setCategory(c.getInt(c.getColumnIndex(COLUMN_CATEGORY)))
                questionList.add(questions)
            }while (c.moveToNext())//chuyển sang hàng tiếp theo

        }
        c.close()
        return questionList

    }




}



