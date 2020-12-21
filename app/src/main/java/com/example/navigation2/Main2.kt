package com.example.navigation2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.navigation2.Exercise.Exercise
import com.example.navigation2.Grammar.Grammar
import com.example.navigation2.NoteVoca.MainNote
import kotlinx.android.synthetic.main.activity_main2.*

class Main2 : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //create button back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //create one in your Activity and call through to the following methods corresponding to your Activity callbacks
        toggle = ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close)

        drawer_layout.addDrawerListener(toggle)//add activity

        toggle.syncState()  //Sync the toggle state after onRestoreInstanceState has occurred.

        //item event handling
        navMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mHome -> {
                    val intent = Intent(this,Main2::class.java)
                    startActivity(intent)
                }
                R.id.mBook ->{
                    val intent = Intent(this,MainNote::class.java)
                    startActivity(intent)
                }

                R.id.mLogout -> {
                    finish()
                }
            }
            true
        }

        btnGrammar.setOnClickListener {
            val intent = Intent(this, Grammar::class.java)
            startActivity(intent)
        }
        btnExercise.setOnClickListener {
            val intent = Intent(this,Exercise::class.java)
            startActivity(intent)
        }

    }

    // will allow the user to access menu options from any context including the Menu Button and the Action Bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //Handles the event when the back button is pressed
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }


}