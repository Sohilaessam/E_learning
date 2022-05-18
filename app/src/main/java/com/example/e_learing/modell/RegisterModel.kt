package com.example.example

import com.google.gson.annotations.SerializedName


data class RegisterModel (

  @SerializedName("UserName"        ) var UserName        : String? = null,
  @SerializedName("school"          ) var school          : String? = null,
  @SerializedName("Appointment"     ) var Appointment     : String? = null,
  @SerializedName("Yourclass"       ) var Yourclass       : String? = null,
  @SerializedName("secphonenumber"  ) var secphonenumber  : String? = null,
  @SerializedName("PhoneNumber"     ) var PhoneNumber     : String? = null,
  @SerializedName("Email"           ) var Email           : String? = null,
  @SerializedName("Password"        ) var Password        : String? = null,
  @SerializedName("ConfirmPassword" ) var ConfirmPassword : String? = null

)