package com.example.navigation2.Grammar.GrammarWord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation2.R
import com.github.barteksc.pdfviewer.PDFView

class GrammarTrangTu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar_trang_tu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pdf =findViewById<PDFView>(R.id.pdfTrangTu)
        pdf.fromAsset("trangtu.pdf").load()
    }
}