package com.nagwa.apisession


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_learing.R
import com.example.e_learing.allquestion
import com.example.example.AllquestionModel

class allquestionAdapter(val allquestionList: List<AllquestionModel>) :
    RecyclerView.Adapter<ALLquestionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ALLquestionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.allquestion_item, parent, false)
        return ALLquestionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return allquestionList.size
    }

    override fun onBindViewHolder(holder: ALLquestionViewHolder, position: Int) {

        var charchter = allquestionList.get(position)
        holder.question.text = charchter.studentquestion
        holder.replay.text = charchter.teacherreplay

     //   Glide.with(holder.photo.context).load(charchter.image).into(holder.photo)

    }
}

class ALLquestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  //  val photo: ImageView = itemView.findViewById(R.id.image)
    val question: TextView = itemView.findViewById(R.id.allquestioncenter)
    val replay: TextView = itemView.findViewById(R.id.tvReply)


}
