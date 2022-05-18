package com.nagwa.apisession


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_learing.R
import com.example.example.AllexamModel
import com.example.example.Questions

class SingleExamAdapter(val examlist: List<Questions>) :
    RecyclerView.Adapter<SingleExamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleExamViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.examdesgin_item, parent, false)
        return SingleExamViewHolder(view)
    }

    override fun getItemCount(): Int {
        return examlist.size
    }

    override fun onBindViewHolder(holder: SingleExamViewHolder, position: Int) {

        var questions = examlist.get(position)
        holder.title.text = questions.question!!.question
        holder.answer1.text = questions.question!!.first
        holder.answer2.text = questions.question!!.sec
        holder.answer3.text = questions.question!!.third
        holder.answer4.text = questions.question!!.fourth

      holder.answerGroup.setOnCheckedChangeListener { group, checkedId ->
          when(checkedId){
              holder.answer1.id->examlist.get(position).question!!.userAsnwer=questions.question!!.first!!
              holder.answer2.id->examlist.get(position).question!!.userAsnwer=questions.question!!.sec!!
              holder.answer3.id->examlist.get(position).question!!.userAsnwer=questions.question!!.third!!
              holder.answer4.id->examlist.get(position).question!!.userAsnwer=questions.question!!.fourth!!

          }
      }

    }
}

class SingleExamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.tvTitleexamdesgin)
    val answerGroup: RadioGroup = itemView.findViewById(R.id.answerGroup)

    val answer1: RadioButton = itemView.findViewById(R.id.answer1)
    val answer2: RadioButton = itemView.findViewById(R.id.answer2)
    val answer3: RadioButton = itemView.findViewById(R.id.answer3)
    val answer4: RadioButton = itemView.findViewById(R.id.answer4)


}
