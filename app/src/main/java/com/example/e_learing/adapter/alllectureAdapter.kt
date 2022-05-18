package com.nagwa.apisession


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_learing.R
import com.example.example.AlllectureModel


class alllectureAdapter(val alllectureList: List<AlllectureModel>) :
    RecyclerView.Adapter<AlllectureViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlllectureViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.alllecture_item, parent, false)
        return AlllectureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return alllectureList.size
    }

    override fun onBindViewHolder(holder: AlllectureViewHolder, position: Int) {

        var leatureModel = alllectureList.get(position)
        holder.title.text = leatureModel.name
        holder.itemView.setOnClickListener {
            val url = leatureModel.text //api
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            holder.itemView.context.startActivity(intent)
        }

    }
}

class AlllectureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     val title: TextView = itemView.findViewById(R.id.alllecturecenter)
}
