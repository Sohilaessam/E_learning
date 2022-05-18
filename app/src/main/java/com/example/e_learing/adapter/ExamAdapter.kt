package com.nagwa.apisession

 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
 import com.example.e_learing.R
import com.example.e_learing.modell.ExamModel

class ExamAdapter(val examList: List<ExamModel>) :
    RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.examdesgin, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return examList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        var charchter = examList.get(position)
        holder.title.text = charchter.name
    }
}
class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     val title: TextView = itemView.findViewById(R.id.allexamcenter)
}
