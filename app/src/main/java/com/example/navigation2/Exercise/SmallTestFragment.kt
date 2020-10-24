package com.example.navigation2.Exercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation2.R
import com.example.navigation2.RecycleViewAdapter.CustomAdapterGrammar
import com.example.navigation2.RecycleViewAdapter.CustomListener
import com.example.navigation2.RecycleViewAdapter.Model


class SmallTestFragment : Fragment() ,CustomListener {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_small_test, container, false)

        val models = ArrayList<Model>()
        models.add(Model("Bài Tập Hiện Tại Đơn"," "))
        models.add(Model("Bài Tập Hiện Tại Tiếp Diễn"," "))
        models.add(Model("Bài Tập Hiện Tại Hoàn Thành"," "))
        models.add(Model("Bài Tập Hiện Tại Hoàn Thành Tiếp Diễn"," "))
        models.add(Model("Bài Tập Quá Khứ Đơn"," "))
        models.add(Model("Bài Tập Quá Khứ Tiếp Diễn"," "))
        models.add(Model("Bài Tập Quá Khứ Hoàn Thành"," "))
        models.add(Model("Bài Tập Quá Khứ Hoàn Thành Tiếp Diễn"," "))
        models.add(Model("Bài Tập Tương Lai Đơn"," "))
        models.add(Model("Bài Tập Tương Lai Tiếp Diễn"," "))
        models.add(Model("Bài Tập Tương Lai Hoàn Thành"," "))
        models.add(Model("Bài Tập Tương Lai Hoàn Thành Tiếp Diễn"," "))

        val mAdapter = CustomAdapterGrammar(models,this)
        recyclerView = view.findViewById(R.id.recyclerViewSmallTest)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = mAdapter

        return view

    }

    override fun onCustomClick(position: Int) {
        if(position == 0){
            Toast.makeText(context,"Click 1",Toast.LENGTH_SHORT).show()
        }
        if(position == 1){
            Toast.makeText(context,"Click 1",Toast.LENGTH_SHORT).show()
        }
        if(position == 2){
            Toast.makeText(context,"Click 2",Toast.LENGTH_SHORT).show()
        }
        if(position == 3){
            Toast.makeText(context,"Click 3",Toast.LENGTH_SHORT).show()
        }
    }


}