package com.example.example

import com.example.e_learing.modell.ExamModel
import com.google.gson.annotations.SerializedName


data class SingleExamModel (

  @SerializedName("exam"           ) var exam           : ExamModel?           = ExamModel(),
  @SerializedName("questions"      ) var questions      : List<Questions> = arrayListOf(),
  @SerializedName("essayquestions" ) var essayquestions : String?         = null,
  @SerializedName("time"           ) var time           : Int?            = null,
  @SerializedName("mass"           ) var mass           : String?         = null,
  @SerializedName("question"       ) var question       : String?         = null,
  @SerializedName("img"            ) var img            : String?         = null

)