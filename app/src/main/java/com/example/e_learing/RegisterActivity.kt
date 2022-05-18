package com.example.e_learing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.e_learing.network.ELearningApinterFace
import com.example.example.RegisterModel
import com.nagwa.apisession.network.ServiceBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {


    lateinit var firstname: EditText
    lateinit var university: EditText
    lateinit var phone: EditText
    lateinit var year: EditText
    lateinit var e_mail: EditText
    lateinit var pass1: EditText
    lateinit var confirmpass1: EditText
   lateinit var personalphone:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.buttonregister)

        firstname=findViewById(R.id.firstname)
        university=findViewById(R.id.university)
        personalphone=findViewById(R.id.personalphone)
        phone=findViewById(R.id.phone)
        year=findViewById(R.id.year)
        e_mail=findViewById(R.id.e_mail)
        pass1=findViewById(R.id.pass1)
        confirmpass1=findViewById(R.id.confirmpass1)

        btn.setOnClickListener {
            regiser()
        }
    }

    fun openActivity2() {
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun regiser() {

   //   var EditText= EditText.text.toString()
//        var pass = edtPass.text.toString()

        var registerModel = RegisterModel(
            "firstname",
            "university",
            "الاحد", "3rd",
            "personalphone",
            "phone",
            "e_mail",
            "pass1",
            "confirmpass1"
        )

        val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
        val call = request.registerNewUser(registerModel)

        call.enqueue(object : Callback<RegisterModel> {
            override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>) {
                if (response.isSuccessful) {
                    //go to home screen
                        openActivity2()

                }
            }

            override fun onFailure(call: Call<RegisterModel>, t: Throwable) {

                Toast.makeText(this@RegisterActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


    }


}
