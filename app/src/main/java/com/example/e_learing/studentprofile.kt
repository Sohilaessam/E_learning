package com.example.e_learing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_learing.network.ELearningApinterFace
import com.example.example.StudentprofileModel
import com.nagwa.apisession.network.ServiceBuilder
import com.nagwa.apisession.studentprofileAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class studentprofile : AppCompatActivity() {
    lateinit var studentprofileRV :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentprofile)
        studentprofileRV = findViewById(R.id.studentprofileRV)


        val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
        val call = request.getstudentprofile()

        call.enqueue(object : Callback<List<StudentprofileModel>> {
            override fun onResponse(call: Call<List<StudentprofileModel>>, response: Response<List<StudentprofileModel>>) {
                if (response.isSuccessful) {
                    Log.e("bakr",response.body().toString())
                    setupRecyclerview(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<StudentprofileModel>>, t: Throwable) {
                Log.e("bakr",t.message.toString())

                Toast.makeText(this@studentprofile, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


    }


    private fun setupRecyclerview(data: List<StudentprofileModel>) {

        studentprofileRV.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            adapter = studentprofileAdapter(data )
        }

    }

}
