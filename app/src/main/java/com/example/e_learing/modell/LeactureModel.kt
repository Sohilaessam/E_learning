package com.example.example

import com.google.gson.annotations.SerializedName


data class LeactureModel(

  @SerializedName("lectureid") var lectureid: Int? = null,
  @SerializedName("name") var name: String? = null,
  @SerializedName("date") var date: String? = null,
  @SerializedName("text") var text: String? = null,
  @SerializedName("fileurl") var fileurl: String? = null,
  @SerializedName("examid") var examid: Int? = null,
  @SerializedName("homework") var homework: Boolean? = null

)