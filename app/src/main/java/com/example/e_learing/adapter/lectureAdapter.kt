package com.nagwa.apisession

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_learing.R
import com.example.example.LeactureModel

class lectureAdapter(val lectureList: List<LeactureModel>) :
    RecyclerView.Adapter<LectureViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.alllecture_item, parent, false)
        return LectureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lectureList.size
    }

    override fun onBindViewHolder(holder: LectureViewHolder, position: Int) {

        var charchter = lectureList.get(position)
        holder.title.text = charchter.name

    //    Glide.with(holder.photo.context).load(charchter.image).into(holder.photo)

    }
}

class LectureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
   // val photo: ImageView = itemView.findViewById(R.id.image)
    val title: TextView = itemView.findViewById(R.id.alllecturecenter)


}
