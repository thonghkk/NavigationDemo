package com.example.navigation2.Grammar

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


class SentenceFragment : Fragment(), CustomListener {
    private var recyclerView : RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view :View = inflater.inflate(R.layout.fragment_sentence, container, false)

        val models = ArrayList<Model>()
        models.add(Model("1.Các Thì Trong Tiếng Anh","Tập Hợp Lý Thuyết Về Tất Cả Các Thì"))
        models.add(Model("2.Câu Bị Động","Cấu Trúc Ngữ Pháp Và Các Trường Hợp Đặc Biệt"))
        models.add(Model("3.Câu Ước","Cấu Ước Các Loại 1 , 2 Và 3"))
        models.add(Model("4.Câu Trực Tiếp Và Câu Gián Tiếp","Câu trực Tiếp,Câu Gián Tiếp Và Cách Chuyển Từ"))
        models.add(Model("Câu Điều Kiện","Câu Điều Kiện Loại 1, 2, 3"))
        models.add(Model("Câu So Sánh","So Sánh Bằng,So Sánh Hơn,So Sánh Nhất"))
        models.add(Model("Mệnh Đề Quan Hệ","Đại Từ Quan Hệ,Trạng Từ Quan Hệ,... "))

        val mAdapter = CustomAdapterGrammar(models,this)

        recyclerView = view.findViewById(R.id.recyclerViewSentence)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = mAdapter

            return view
    }

    override fun onCustomClick(position: Int) {
        if (position == 0){
//            val intent = Intent(context,Main2::class.java)
//            startActivity(intent)
            Toast.makeText(context,"Click1",Toast.LENGTH_SHORT).show()
        }
        if (position == 1){
            Toast.makeText(context,"Click2",Toast.LENGTH_SHORT).show()
        }
        if (position == 2){
            Toast.makeText(context,"Click3",Toast.LENGTH_SHORT).show()
        }

    }


}

