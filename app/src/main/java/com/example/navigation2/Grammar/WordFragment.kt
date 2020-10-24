package com.example.navigation2.Grammar

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


class WordFragment : Fragment() ,CustomListener {
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
        models.add(Model("1.Bảng Động Từ Bất Quy Tắc","Tổng Hợp Các Động Từ Bất Quy Tắc Thường Gặp"))
        models.add(Model("2.Danh Từ","Các Loại Danh Từ Đếm Được và Không Đếm Được"))
        models.add(Model("3.Động Từ","Động Từ Khuyết Thiếu,Nội Động Từ Và Ngoại Động Từ"))
        models.add(Model("4.Trạng Từ","Vị Trị,Phân Loại,Các Loại Thường Gặp"))
        models.add(Model("5.Giới Từ","Định Nghĩa Cách Dùng,Các Loại Giới Từ"))
        models.add(Model("6.Tính Từ","Vị Trí Cấu Trúc,Các Loại Thường Gặp"))

        val mAdapter = CustomAdapterGrammar(models,this)

        recyclerView = view.findViewById(R.id.recyclerViewSentence)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = mAdapter
        return view
    }

    override fun onCustomClick(position: Int) {
        if (position == 0){
            Toast.makeText(context,"Click 0",Toast.LENGTH_SHORT).show()
        }
        if (position == 1){
            Toast.makeText(context,"Click 1",Toast.LENGTH_SHORT).show()
        }
        if (position == 2){
            Toast.makeText(context,"Click 2",Toast.LENGTH_SHORT).show()
        }
        if (position == 3){
            Toast.makeText(context,"Click 3",Toast.LENGTH_SHORT).show()
        }
        if (position == 4){
            Toast.makeText(context,"Click 4",Toast.LENGTH_SHORT).show()
        }
    }


}