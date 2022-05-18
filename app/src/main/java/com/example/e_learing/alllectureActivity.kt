package com.example.e_learing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_learing.network.ELearningApinterFace
import com.example.example.AlllectureModel
import com.example.example.AllquestionModel
import com.nagwa.apisession.alllectureAdapter
import com.nagwa.apisession.allquestionAdapter
import com.nagwa.apisession.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class alllectureActivity : AppCompatActivity() {
    lateinit var alllectureRV:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alllecture)
        alllectureRV =findViewById(R.id.alllectureRV)


        val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
        val call = request.getAlllecture()

        call.enqueue(object : Callback<List<AlllectureModel>> {
            override fun onResponse(call: Call<List<AlllectureModel>>, response: Response<List<AlllectureModel>>) {
                if (response.isSuccessful) {
                    Log.e("bakr",response.body().toString())
                    setupRecyclerview(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<AlllectureModel>>, t: Throwable) {
                Log.e("bakr",t.message.toString())

                Toast.makeText(this@alllectureActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


    }


    private fun setupRecyclerview(data: List<AlllectureModel>) {

        alllectureRV.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            adapter = alllectureAdapter(data)
        }

    }

    }
