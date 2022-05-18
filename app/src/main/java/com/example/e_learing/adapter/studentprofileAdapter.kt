package com.nagwa.apisession


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_learing.R
import com.example.example.StudentprofileModel

class studentprofileAdapter(val studentList: List<StudentprofileModel>) :
    RecyclerView.Adapter<StudentprofileViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentprofileViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.studentprofile_item, parent, false)
        return StudentprofileViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentprofileViewHolder, position: Int) {

        var charchter = studentList.get(position)
        holder.title.text = charchter.day

      //  Glide.with(holder.photo.context).load(charchter.image).into(holder.photo)

    }
}

class StudentprofileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
 //   val photo: ImageView = itemView.findViewById(R.id.image)
    val title: TextView = itemView.findViewById(R.id.allstudentcenter)


}
