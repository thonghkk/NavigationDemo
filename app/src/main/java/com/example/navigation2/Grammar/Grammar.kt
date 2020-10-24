package com.example.navigation2.Grammar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation2.FragmentAdapter.ViewPagerAdapter
import com.example.navigation2.R
import kotlinx.android.synthetic.main.activity_grammar.*

class Grammar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar)

        setUpTabsGrammar()

    }
    private fun setUpTabsGrammar(){
        //
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(SentenceFragment(),"Câu")
        adapter.addFragment(WordFragment(),"Từ")

        //cho adapter truyen vao ViewPagerGrammar
        viewPagerGrammar.adapter = adapter
        tabsGrammar.setupWithViewPager(viewPagerGrammar)


    }
}