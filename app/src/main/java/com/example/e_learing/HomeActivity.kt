package com.example.e_learing

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var alllecture = findViewById<CardView>(R.id.lectureimg)
        var allexamimg = findViewById<CardView>(R.id.allexamimg)
        var askqustion = findViewById<CardView>(R.id.myquestionimg)
        var question = findViewById<CardView>(R.id.questionimg)
        var score = findViewById<CardView>(R.id.scoreimg)
        var logoutBtn = findViewById<Button>(R.id.buttonlodout)
        var profile = findViewById<CardView>(R.id.profileimg)
        allexamimg.setOnClickListener {
            startActivity(Intent(this, AllExamActivity::class.java))
        }

        askqustion.setOnClickListener {
             startActivity(Intent(this, AskquestionActivity::class.java))
        }
        alllecture.setOnClickListener {
            startActivity(Intent(this, alllectureActivity::class.java))
        }
        question.setOnClickListener {
            startActivity(Intent(this, allquestion::class.java))
        }
        score.setOnClickListener {
            startActivity(Intent(this, socreActivity::class.java))
        }
        profile.setOnClickListener {
            startActivity(Intent(this, studentprofile::class.java))
        }

        logoutBtn.setOnClickListener {
            logout()
        }
    }


    fun logout() {


        val builder = AlertDialog.Builder(this)

        builder.setTitle("Logout")

        builder.setMessage("Are Your Sure To  Logout?")
        builder.setIcon(android.R.drawable.ic_dialog_alert)


        builder.setPositiveButton("Yes"){dialogInterface, which ->
            val sharedPreference = getSharedPreferences("elearning", Context.MODE_PRIVATE)
            var editor = sharedPreference.edit()
            editor.clear()
            editor.apply()

            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        builder.setNegativeButton("No"){dialogInterface, which ->
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()

        alertDialog.setCancelable(false)
        alertDialog.show()


    }

}
