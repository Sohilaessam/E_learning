package com.example.example

import com.google.gson.annotations.SerializedName


data class StudentprofileModel (

  @SerializedName("courseid" ) var courseid : Int?    = null,
  @SerializedName("day"      ) var day      : String? = null,
  @SerializedName("time"     ) var time     : String? = null

)