package com.example.navigation2.NoteVoca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation2.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainNote : AppCompatActivity() {

    private var btn_Click: FloatingActionButton? = null
    private var recyclerView: RecyclerView? = null

    companion object {
        lateinit var dbHandler: DatabaseHelperVoca
    }

    var customList = ArrayList<ModelVoca>()
    lateinit var adapter: RecyclerView.Adapter<*>
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_note)

        btn_Click = findViewById(R.id.add_book)
        recyclerView = findViewById(R.id.recycleViewVocabulary)
        // editSearch = findViewById(R.id.editSearch)

        btn_Click?.setOnClickListener {
            val intent = Intent(this, AddVoca::class.java)
            startActivity(intent)
        }


        dbHandler = DatabaseHelperVoca(this)
        viewNote()


    }

    fun viewNote() {
        customList = dbHandler.readAllData(this)
        adapter = CustomAdapter(this, customList)
        rv = findViewById(R.id.recycleViewVocabulary)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv.adapter = adapter

    }

    override fun onResume() {
        viewNote()
        super.onResume()
    }


    //Custom Search
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.seach_voca, menu)
        val item: MenuItem? = menu?.findItem(R.id.search_voca)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredCustomer = ArrayList<ModelVoca>()
                if (searchView.requestFocus()) {
                    for (i in 0 until customList.size) {
                        if (customList[i].output.toLowerCase().contains(newText.toString().toLowerCase()))
                            filteredCustomer.add(customList[i])
                    }
                    adapter = CustomAdapter(this@MainNote, filteredCustomer)
                    rv.adapter = adapter
                } else {
                    adapter = CustomAdapter(this@MainNote, customList)
                    rv.adapter = adapter
                }
                return true
            }
        })
        return true

    }


}