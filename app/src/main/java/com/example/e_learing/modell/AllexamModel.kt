package com.example.example

import com.google.gson.annotations.SerializedName


data class AllexamModel (

  @SerializedName("examid"     ) var examid     : Int?     = null,
  @SerializedName("name"       ) var name       : String?  = null,
  @SerializedName("Date"       ) var Date       : String?  = null,
  @SerializedName("open"       ) var open       : Boolean? = null,
  @SerializedName("timeofexam" ) var timeofexam : Int?     = null

)