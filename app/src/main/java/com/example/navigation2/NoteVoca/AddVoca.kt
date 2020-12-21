package com.example.navigation2.NoteVoca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.navigation2.R

class AddVoca : AppCompatActivity() {

    private var btnSave : Button? = null
    private var btnCancel : Button? = null
    private var edt_input : EditText? = null
    private var edt_output : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_voca)

        btnSave = findViewById(R.id.btnSave)
        btnCancel = findViewById(R.id.btnCancel)
        edt_input = findViewById(R.id.input)
        edt_output = findViewById(R.id.output)

        btnSave?.setOnClickListener {

            if(edt_input!!.text.isEmpty() || edt_output!!.text.isEmpty()){
                Toast.makeText(this,"Enter Text", Toast.LENGTH_SHORT).show()
            }else {
                val myDB = DatabaseHelperVoca(this)
                myDB.addNote2(edt_input?.text.toString().trim(),edt_output?.text.toString().trim())

                remoteEdits()
            }

        }
        btnCancel?.setOnClickListener {
            remoteEdits()
            finish()
        }

    }

    private fun remoteEdits(){
        edt_input!!.text.clear()
        edt_output!!.text.clear()
    }
}