package com.example.e_learing

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_learing.modell.ExamModel
import com.example.e_learing.network.ELearningApinterFace
import com.example.example.AllquestionModel
import com.nagwa.apisession.ExamAdapter
import com.nagwa.apisession.allquestionAdapter
import com.nagwa.apisession.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class allquestion : AppCompatActivity() {
    lateinit var allquestionRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allquestion)
        allquestionRV = findViewById(R.id.allquestionRV)


        val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
        val call = request.getAllquestion(getUserKey())

        call.enqueue(object : Callback<List<AllquestionModel>> {
            override fun onResponse(call: Call<List<AllquestionModel>>, response: Response<List<AllquestionModel>>) {
                if (response.isSuccessful) {
                    Log.e("bakr",response.body().toString())
                    setupRecyclerview(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<AllquestionModel>>, t: Throwable) {
                Log.e("bakr",t.message.toString())

                Toast.makeText(this@allquestion, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


    }


    private fun setupRecyclerview(data: List<AllquestionModel>) {

        allquestionRV.apply {
            layoutManager = LinearLayoutManager(this@allquestion)

            adapter = allquestionAdapter(data )
        }

    }

    fun getUserKey(): String {
        val sharedPreference = getSharedPreferences("elearning", Context.MODE_PRIVATE)
        return sharedPreference.getString("userId", "")!!
    }
}
