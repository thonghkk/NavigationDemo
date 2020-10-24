package com.example.navigation2.Grammar.GrammarSentence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation2.R
import com.github.barteksc.pdfviewer.PDFView

class GrammarCacThi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar_cac_thi)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pdf =findViewById<PDFView>(R.id.pdfCacThi)
        pdf.fromAsset("present.pdf").load()
    }
}