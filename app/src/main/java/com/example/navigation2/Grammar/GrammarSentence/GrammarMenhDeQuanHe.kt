package com.example.navigation2.Grammar.GrammarSentence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation2.R
import com.github.barteksc.pdfviewer.PDFView

class GrammarMenhDeQuanHe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar_menhdequanhe)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pdf =findViewById<PDFView>(R.id.pdfMenhDeQuanHe)
        pdf.fromAsset("menhdequanhe.pdf").load()
    }
}