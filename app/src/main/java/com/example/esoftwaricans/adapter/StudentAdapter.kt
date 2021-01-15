package com.example.esoftwaricans.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.esoftwaricans.R
import com.example.esoftwaricans.model.Student

class StudentAdapter(
    private val context: Context,
    private val stdList: ArrayList<Student>

): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val stdName : TextView = view.findViewById(R.id.tvName)
        val stdAge : TextView = view.findViewById(R.id.tvAge)
        val stdAddress : TextView = view.findViewById(R.id.tvAddress)
        val stdGender : TextView = view.findViewById(R.id.tvGender)
        val stdPicture : ImageView = view.findViewById(R.id.picture)
        val btnDelete : ImageButton = view.findViewById(R.id.btnDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.student_details, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val std =stdList[position]
        holder.stdName.text = std.stdName
        holder.stdAge.text = std.stdAge
        holder.stdAddress.text = std.stdAddress
        holder.stdGender.text = std.stdGender

        holder.btnDelete.setOnClickListener{
            removeItem(position)
        }

        if (std.stdPicture.isNullOrEmpty()){
            if (std.stdGender.equals("male")){
                Glide.with(context).load(R.drawable.ic_male).into(holder.stdPicture)
            }else{
                Glide.with(context).load(R.drawable.ic_female).into(holder.stdPicture)
            }
        }else{
            Glide.with(context).load(std.stdPicture).into(holder.stdPicture)
        }
    }

    override fun getItemCount(): Int {
        return stdList.size
    }

    fun removeItem(position: Int) {
        stdList.removeAt(position)
        notifyDataSetChanged()
    }
}