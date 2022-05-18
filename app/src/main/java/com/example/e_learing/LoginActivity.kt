package com.example.e_learing

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.e_learing.network.ELearningApinterFace
import com.example.example.AlllectureModel
import com.nagwa.apisession.network.ServiceBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var edtEmail: EditText
    lateinit var edtPass: EditText
    lateinit var checkBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Log.e("sohile", getUserKey())
        if (getRemember()) {
            //go to home screen
            var intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        edtEmail = findViewById(R.id.edtEmail)
        edtPass = findViewById(R.id.edtPass)
        checkBox = findViewById(R.id.checkbox)

        edtPass.setText("123456")
        edtEmail.setText("soh@gmail.com")

    }

    fun openRegister(view: View) {
        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun openHome(view: View) {

        var mail = edtEmail.text.toString()
        var pass = edtPass.text.toString()

        val request = ServiceBuilder.buildService(ELearningApinterFace::class.java)
        val call = request.login(mail, pass)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    saveUserData(checkBox.isChecked, response.body()?.string().toString())


                    //go to home screen
                    var intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(intent)


                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("bakr", t.message.toString())

                Toast.makeText(this@LoginActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


    }


    fun saveUserData(boolean: Boolean, usserId: String) {
        val sharedPreference =
            getSharedPreferences("elearning", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putBoolean("rememberMe", boolean)
        editor.putString("userId", usserId.replace("\"", ""))
        editor.apply()
    }

    fun getRemember(): Boolean {
        val sharedPreference = getSharedPreferences("elearning", Context.MODE_PRIVATE)
        return sharedPreference.getBoolean("rememberMe", false)
    }

    fun getUserKey(): String {
        val sharedPreference = getSharedPreferences("elearning", Context.MODE_PRIVATE)
        return sharedPreference.getString("userId", "")!!
    }
}