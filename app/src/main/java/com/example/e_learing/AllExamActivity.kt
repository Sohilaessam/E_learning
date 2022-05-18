package com.example.e_learing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_learing.network.ELearningApinterFace
import com.example.example.AllexamModel
import com.nagwa.apisession.allexamAdapter
import com.nagwa.apisession.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllExamActivity : AppCompatActivity() {
    lateinit var allexamRV :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allexam)
        allexamRV = findViewById(R.id.allexamRV)

        val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
        val call = request.getAllexam()

        call.enqueue(object : Callback<List<AllexamModel>> {
            override fun onResponse(call: Call<List<AllexamModel>>, response: Response<List<AllexamModel>>) {
                if (response.isSuccessful) {
                    Log.e("bakr",response.body().toString())
                    setupRecyclerview(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<AllexamModel>>, t: Throwable) {
                Log.e("bakr",t.message.toString())

                Toast.makeText(this@AllExamActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


    }


    private fun setupRecyclerview(data: List<AllexamModel>) {

        allexamRV.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            adapter = allexamAdapter(data )
        }

    }

}
