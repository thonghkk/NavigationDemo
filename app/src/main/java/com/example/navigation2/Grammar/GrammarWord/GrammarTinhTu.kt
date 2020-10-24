package com.example.navigation2.Grammar.GrammarWord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation2.R
import com.github.barteksc.pdfviewer.PDFView

class GrammarTinhTu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar_tinh_tu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pdf =findViewById<PDFView>(R.id.pdfTinhTu)
        pdf.fromAsset("tinh-tu.pdf").load()
    }
}