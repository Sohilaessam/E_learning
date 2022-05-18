package com.example.e_learing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.e_learing.network.ELearningApinterFace
import com.example.example.RegisterModel
import com.example.example.ScoreModel
import com.google.gson.annotations.SerializedName
import com.nagwa.apisession.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScoreActivity : AppCompatActivity() {

    lateinit var name: TextView
    lateinit var examid: TextView
    lateinit var studentid: TextView
    lateinit var degree: TextView
    lateinit var total: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_socre)

        name=findViewById(R.id.name)
        examid=findViewById(R.id.examid)
        studentid=findViewById(R.id.studentid)
        degree=findViewById(R.id.degree)
        total=findViewById(R.id.total)


//        var scoreModel = ScoreModel(
//
//            "examid" ,
//            "examid" ,
//            "degree" ,
//            "total"
//        )
//
//        val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
//        val call = request.registerNewUser(ScoreModel)
//
//        call.enqueue(object : Callback<RegisterModel> {
//            override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>) {
//                if (response.isSuccessful) {
//
//
//                }
//            }
//
//            override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
//
//                Toast.makeText(this@ScoreActivity, "${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
    }
}