package com.example.navigation2.Exercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation2.RecycleViewAdapter.CustomAdapterGrammar
import com.example.navigation2.RecycleViewAdapter.CustomListener
import com.example.navigation2.RecycleViewAdapter.Model
import com.example.navigation2.R


class GeneralTestFragment : Fragment(), CustomListener {

    private var recyclerView : RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view :View =  inflater.inflate(R.layout.fragment_general_test, container, false)
        val models = ArrayList<Model>()
        models.add(Model("1.Câu Gián Tiếp ","Bài Kiểm Tra 1"))

        val mAdapter = CustomAdapterGrammar(models,this)

         recyclerView = view.findViewById(R.id.recyclerViewSentence)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = mAdapter
        return view

    }

    override fun onCustomClick(position: Int) {
        if (position == 0){
//            val intent = Intent(context,Main2::class.java)
///          startActivity(intent)
            Toast.makeText(context,"Click1", Toast.LENGTH_SHORT).show()
        }

    }


}