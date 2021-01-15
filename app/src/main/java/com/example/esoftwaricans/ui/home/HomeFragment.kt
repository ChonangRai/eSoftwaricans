package com.example.esoftwaricans.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esoftwaricans.MainActivity2
import com.example.esoftwaricans.R
import com.example.esoftwaricans.adapter.StudentAdapter
class HomeFragment : Fragment() {

    private lateinit var student_detail : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        student_detail = view.findViewById(R.id.recylerView)
        student_detail.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        student_detail.adapter = StudentAdapter(requireContext(),(activity as MainActivity2).stdList)

    return view
    }
}