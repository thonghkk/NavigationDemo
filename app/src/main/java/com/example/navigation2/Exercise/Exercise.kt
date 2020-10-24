package com.example.navigation2.Exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation2.FragmentAdapter.ViewPagerAdapter
import com.example.navigation2.R
import kotlinx.android.synthetic.main.activity_exercise.*

class Exercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        setUpTabsExercise()
    }

    fun setUpTabsExercise(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(SmallTestFragment(),"Kiểm Tra")
        adapter.addFragment(GeneralTestFragment(),"Kiểm Tra Chung")

        viewPagerExercise.adapter = adapter
        tabsExercise.setupWithViewPager(viewPagerExercise)

    }
}