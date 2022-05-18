package com.example.e_learing

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.e_learing.network.ELearningApinterFace
import com.example.example.AskquestionModel
import com.example.example.RegisterModel
import com.nagwa.apisession.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AskquestionActivity : AppCompatActivity() {
    lateinit var questionEdt: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_askquestion)
        questionEdt = findViewById(R.id.questionedt)
    }


    fun askQuestion(view: View) {

        var question = questionEdt.text.toString()

        if (question.isEmpty()) {
            Toast.makeText(
                this@AskquestionActivity,
                "please enter new question",
                Toast.LENGTH_SHORT
            ).show()

        } else {

            var askquestion = AskquestionModel(
                studentquestion = question,
                teacherreplay = " adf ",
                studentid = getUserKey()
            )

            val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
            val call = request.askquestion(askquestion)

            call.enqueue(object : Callback<AskquestionModel> {
                override fun onResponse(
                    call: Call<AskquestionModel>,
                    response: Response<AskquestionModel>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(
                            this@AskquestionActivity,
                            "Your question has been successfully added",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }

                override fun onFailure(call: Call<AskquestionModel>, t: Throwable) {

                    Toast.makeText(this@AskquestionActivity, "${t.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            })

        }


    }

    fun getUserKey(): String {
        val sharedPreference = getSharedPreferences("elearning", Context.MODE_PRIVATE)
        return sharedPreference.getString("userId", "")!!
    }
}