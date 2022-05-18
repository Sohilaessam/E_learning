package com.example.example

import com.google.gson.annotations.SerializedName


data class Question (

  @SerializedName("questionid"    ) var questionid    : Int?    = null,
  @SerializedName("question"      ) var question      : String? = null,
   var questiongrade : String = "1",
  @SerializedName("first"         ) var first         : String? = null,
  @SerializedName("sec"           ) var sec           : String? = null,
  @SerializedName("third"         ) var third         : String? = null,
  @SerializedName("fourth"        ) var fourth        : String? = null,
  @SerializedName("correct"       ) var correct       : String? = null,
  @SerializedName("choise"        ) var choise        : String? = null,
  @SerializedName("Explanation"   ) var Explanation   : String? = null,
  @SerializedName("examid"        ) var examid        : Int?    = null,
    var userAsnwer        : String   = "",


  )