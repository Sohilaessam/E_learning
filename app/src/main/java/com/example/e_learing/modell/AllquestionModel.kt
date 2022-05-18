package com.example.example

import com.google.gson.annotations.SerializedName


data class AllquestionModel (

  @SerializedName("studentquestionid" ) var studentquestionid : Int?    = null,
  @SerializedName("studentquestion"   ) var studentquestion   : String? = null,
  @SerializedName("teacherreplay"     ) var teacherreplay     : String? = null,
  @SerializedName("studentid"         ) var studentid         : String? = null

)