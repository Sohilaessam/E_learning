package com.example.e_learing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_learing.network.ELearningApinterFace
import com.example.example.LeactureModel
import com.nagwa.apisession.lectureAdapter
import com.nagwa.apisession.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class lectureActivity : AppCompatActivity() {
    lateinit var  lectureRV:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)

        lectureRV=findViewById(R.id.examRV)


        val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
        val call = request.getLeatures()

        call.enqueue(object : Callback<List<LeactureModel>> {
            override fun onResponse(call: Call<List<LeactureModel>>, response: Response<List<LeactureModel>>) {
                if (response.isSuccessful) {
                    Log.e("bakr",response.body().toString())
                    setupRecyclerview(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<LeactureModel>>, t: Throwable) {
                Log.e("bakr",t.message.toString())

                Toast.makeText(this@lectureActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


    }


    private fun setupRecyclerview(data: List<LeactureModel>) {

        lectureRV.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            adapter = lectureAdapter(data )
        }

    }


}