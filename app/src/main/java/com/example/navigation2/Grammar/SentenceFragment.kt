package com.example.navigation2.Grammar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation2.Grammar.GrammarSentence.*
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
        models.add(Model("2.Câu Bị Động","Cấu Trúc Ngữ Pháp,Các Trường Hợp Đặc Biệt"))
        models.add(Model("3.Câu Ước","Cấu Ước Các Loại 1 , 2 Và 3"))
        models.add(Model("4.Câu Trực Tiếp Và Câu Gián Tiếp","Câu trực Tiếp,Câu Gián Tiếp,Cách Chuyển Từ"))
        models.add(Model("5.Câu Điều Kiện","Câu Điều Kiện Loại 1, 2, 3"))
        models.add(Model("6.Câu So Sánh","So Sánh Bằng,So Sánh Hơn,So Sánh Nhất"))
        models.add(Model("7.Mệnh Đề Quan Hệ","Đại Từ Quan Hệ,Trạng Từ Quan Hệ,... "))

        val mAdapter = CustomAdapterGrammar(models,this)

        recyclerView = view.findViewById(R.id.recyclerViewSentence)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = mAdapter

            return view
    }

    override fun onCustomClick(position: Int) {
        if (position == 0){
            val intent = Intent(context,GrammarCacThi::class.java)
            startActivity(intent)
        }
        if (position == 1){
            val intent = Intent(context,GrammarCauBiDong::class.java)
            startActivity(intent)
        }
        if (position == 2){
            val intent = Intent(context,GrammarCauUoc::class.java)
            startActivity(intent)
        }
        if (position == 3){
            val intent = Intent(context,GrammarTrucTiepGianTiep::class.java)
            startActivity(intent)
        }
        if (position == 4){
            val intent = Intent(context,GrammarCauDieuKien::class.java)
            startActivity(intent)
        }
        if (position == 5){
            val intent = Intent(context,GrammarCauSoSanh::class.java)
            startActivity(intent)
        }
        if (position == 6){
            val intent = Intent(context,GrammarMenhDeQuanHe::class.java)
            startActivity(intent)
        }


    }


}

