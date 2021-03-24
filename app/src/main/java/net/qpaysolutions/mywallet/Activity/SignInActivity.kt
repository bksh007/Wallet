package net.qpaysolutions.mywallet.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import net.qpaysolutions.mywallet.Database.RegisterDatabase
import net.qpaysolutions.mywallet.Database.RegisterEntity
import net.qpaysolutions.mywallet.R
import net.qpaysolutions.mywallet.ViewModel

class SignInActivity : AppCompatActivity() {
    lateinit var btn_signin : Button
    lateinit var btn_back : ImageButton
    lateinit var forgot_password : TextView
    lateinit var til_phone : TextInputLayout
    lateinit var til_password : TextInputLayout
    lateinit var ph_number  : String
    lateinit var password  : String

    lateinit var et_password  : EditText
    lateinit var et_phone  : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        til_phone = findViewById(R.id.activity_signin_til_ph_number)
        til_password = findViewById(R.id.activity_signin_til_password)
        btn_signin = findViewById(R.id.activity_signin_btn_signin)
        forgot_password = findViewById(R.id.activity_signin_tv_forgot_password)
        btn_back = findViewById(R.id.btn_back)

        et_phone = findViewById(R.id.et_phone)
        et_password = findViewById(R.id.et_password)

        btn_signin.setOnClickListener {
            val phone = et_phone.text.toString()
            val password = et_password.text.toString()

            val user = RegisterEntity(0, phone, password)

            val userDao = RegisterDatabase.getInstance(getApplication())?.registerDatabaseDao
            var userPhone=userDao?.getUser(user.phoneNumber)
            var userPassword=userDao?.getUserPass(user.password)

            if (!validateNum() or !validatePass()){
                return@setOnClickListener
            }

            if (phone.equals(userPhone) && password.equals(userPassword)){
                var intent = Intent(this, DashBoardActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

        forgot_password.setOnClickListener {
           val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }


    private fun validateNum(): Boolean {
        if (et_phone.text.toString().isEmpty()) {
            til_phone.error = "Please enter the Ph number."
            return false
        } else if (et_phone.text.toString().length != 10) {
            til_phone.error = "Please enter valid Ph number."
            return false
        } else {
            til_phone.isErrorEnabled = false
            return true
        }
    }

    private fun validatePass(): Boolean {
        if (et_password.text.toString().isEmpty()) {
            til_password.error = "Please enter the password."
            return false
        } else {
            til_password.isErrorEnabled = false
        }
        return true
    }

    fun btn_back(view: View) {
        onBackPressed()
    }
}