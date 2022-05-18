package com.example.example

import com.google.gson.annotations.SerializedName


data class ScoreModel (

  @SerializedName("id"        ) var id        : Int?    = null,
  @SerializedName("examid"    ) var examid    : Int?    = null,
  @SerializedName("studentid" ) var studentid : String? = null,
  @SerializedName("degree"    ) var degree    : Int?    = null,
  @SerializedName("total"     ) var total     : Int?    = null

)