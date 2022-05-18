package com.nagwa.apisession


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_learing.R
import com.example.e_learing.SingleExam
import com.example.example.AllexamModel

class allexamAdapter(val allexamList: List<AllexamModel>) :
    RecyclerView.Adapter<allexamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): allexamViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.allexam_item, parent, false)
        return allexamViewHolder(view)
    }

    override fun getItemCount(): Int {
        return allexamList.size
    }

    override fun onBindViewHolder(holder: allexamViewHolder, position: Int) {

        var exam = allexamList.get(position)
        holder.title.text = exam.name

        holder.itemView.setOnClickListener {
            val examId = exam.examid //api
            val intent = Intent(holder.itemView.context,SingleExam::class.java)
            intent.putExtra("examId",examId)
            holder.itemView.context.startActivity(intent)
        }
    }
}

class allexamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
   // val photo: ImageView = itemView.findViewById(R.id.image)
    val title: TextView = itemView.findViewById(R.id.tvTitleallexam)


}
