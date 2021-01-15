package com.example.esoftwaricans.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esoftwaricans.R

class IntroSlideAdapter():RecyclerView.Adapter<IntroSlideAdapter.IntroSlideViewHolder>() {
    class IntroSlideViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val txtTitle = view.findViewById<TextView>(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}