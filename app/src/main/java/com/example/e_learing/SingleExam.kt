package com.example.e_learing

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_learing.network.ELearningApinterFace
import com.example.example.*
import com.google.gson.annotations.SerializedName
import com.nagwa.apisession.SingleExamAdapter
import com.nagwa.apisession.alllectureAdapter
import com.nagwa.apisession.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.example.Questions as Questions1

class SingleExam : AppCompatActivity() {

  lateinit  var questionsExam :List<Questions1>

    lateinit var examdesgin:RecyclerView
    var examId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_exam)
        examdesgin=findViewById(R.id.examdesgin)
          examId=intent.getIntExtra("examId",0)



        val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
          val call = request.getSingleExam("f1a1a4d1-e0bd-4218-840b-07e7db4d114e","21")
        call.enqueue(object : Callback<SingleExamModel> {
            override fun onResponse(call: Call<SingleExamModel>, response: Response<SingleExamModel>) {
                if (response.isSuccessful) {

                    setupRecyclerview(response.body()!!.questions)


        //           val timer = object: CountDownTimer( response.body()!!.exam.time, 1000) {
         //               override fun onTick(millisUntilFinished: Long) {
        //                  ti.text=mimillisUntilFinished.tos
                  //     }

                //        override fun onFinish() {


                //        }
            //      }
            //   timer.start()


                }
            }

            override fun onFailure(call: Call<SingleExamModel>, t: Throwable) {
                Log.e("bakr",t.message.toString())

                Toast.makeText(this@SingleExam, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


        

    }
       var useranswer:String ="null"
       var counter :Int =1
    fun correct() {
        for (counter in questionsExam) {
            if (useranswer == "correct") {
                print("correct")
            }
        }
    }

    fun getUserKey(): String {
        val sharedPreference = getSharedPreferences("elearning", Context.MODE_PRIVATE)
        return sharedPreference.getString("userId", "")!!
    }

    lateinit var fsdg:SingleExamAdapter
    private fun setupRecyclerview(data: List<Questions1>) {
        fsdg= SingleExamAdapter(data)
        examdesgin.apply {
            layoutManager = LinearLayoutManager(this@SingleExam)

            adapter = fsdg
        }

    }

    public fun correctTheExam(view:View)
    {
       // Log.e("bakr",fsdg.examlist.toString())
        var score=0

        for (question in fsdg.examlist)
        {
            if(question.question!!.userAsnwer==question.question!!.correct)
                score++
               // Log.e("bakr", "grade = ${question.question!!.questiongrade}")
        }
        Log.e("bakr","score = $score")
//api score

    //    var scoreModel1 = ScoreModel(


       //     examId     ,
        //    examId ,
        //    "getUserKey()" ,
         //   score ,
         //   score,
       // )
    //    val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
     //   val call = request.score(scoreModel1)

      //  call.enqueue(object : Callback<ScoreModel> {
       //     override fun onResponse(call: Call<ScoreModel>, response: Response<ScoreModel>) {
               // if (response.isSuccessful) {
               //     val intent = Intent(this,SingleExam::class.java)
                 //  intent.putExtra(Degree,1)
                  //  intent.putExtra(NameExam,"GOLOGICAL")
                  //  startActivity(intent)

                    // open activity and send data in intent

                //    Toast.makeText(this@SingleExam, "you Got >>${score} ", Toast.LENGTH_SHORT).show()

             //   }
           // }
          //  override fun onFailure(call: Call<ScoreModel>, t: Throwable) {

             //   Toast.makeText(this@SingleExam, "${t.message}", Toast.LENGTH_SHORT).show()
          //  }
       // })
    }

}