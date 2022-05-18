package com.example.e_learing.network

 import com.example.e_learing.ScoreActivity
 import com.example.e_learing.modell.ExamModel
 import com.example.example.*
 import okhttp3.ResponseBody
 import retrofit2.Call
 import retrofit2.http.*

interface ELearningApinterFace {



    @GET("lecture/f1a1a4d1-e0bd-4218-840b-07e7db4d114e")
    fun getLeatures(): Call<List<LeactureModel>>

    @GET("question/{userId}")
    fun getAllquestion(@Path("userId") userId:String): Call<List<AllquestionModel>>

    @GET("exam/f1a1a4d1-e0bd-4218-840b-07e7db4d114e")
    fun getAllexam(): Call<List<AllexamModel>>

    @GET("lecture/f1a1a4d1-e0bd-4218-840b-07e7db4d114e")
    fun getAlllecture(): Call<List<AlllectureModel>>


    @GET("student/f1a1a4d1-e0bd-4218-840b-07e7db4d114e")
    fun getstudentprofile(): Call<List<StudentprofileModel>>



    @GET("register")
    fun login(@Query("A")email:String ,@Query("B")pass :String ):  Call<ResponseBody>


    @POST("register")
    fun registerNewUser(@Body regiserModel:RegisterModel): Call<RegisterModel>


    @POST("exam")
    fun score(@Body scoreModel:ScoreModel): Call<ScoreModel>

    @POST("question")
    fun askquestion(@Body askquestionModel: AskquestionModel): Call<AskquestionModel>



    @GET("exam")
    fun getSingleExam(@Query("A")userId:String ,@Query("B")ExamId :String ):  Call<SingleExamModel>

}