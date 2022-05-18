package com.example.example

import com.google.gson.annotations.SerializedName


data class Questions (

  @SerializedName("question" ) var question : Question? = Question(),
//  @SerializedName("img"      ) var img      : String?   = null

) {

}