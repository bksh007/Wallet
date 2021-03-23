package net.qpaysolutions.mywallet.Activity

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import net.qpaysolutions.mywallet.Database.RegisterDatabase
import net.qpaysolutions.mywallet.Database.RegisterDatabaseDao
import net.qpaysolutions.mywallet.Database.RegisterEntity
import net.qpaysolutions.mywallet.R
import org.jetbrains.anko.doAsync
import kotlin.concurrent.thread
import android.widget.Toast.makeText as toastMakeText

class SignupActivity : AppCompatActivity() {
    lateinit var til_phone : TextInputLayout
    lateinit var til_password : TextInputLayout
    lateinit var et_password  : EditText
    lateinit var et_phone  : EditText
    lateinit var btn_signup : Button
    lateinit var btn_back : ImageButton
    lateinit var checkbox : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        til_phone = findViewById(R.id.activity_signup_til_ph_number)
        til_password = findViewById(R.id.activity_signup_til_password)
        btn_signup = findViewById(R.id.activity_signup_btn_signup)
        btn_back = findViewById(R.id.btn_back)
        checkbox = findViewById(R.id.activity_signup_checkbox)

        et_phone = findViewById(R.id.activity_signup_et_phone)
        et_password = findViewById(R.id.activity_signup_et_password)


        btn_signup.setOnClickListener {
            if (!validateNum() or !validatePass()){
                return@setOnClickListener
            }else if (!checkbox.isChecked){
                toastMakeText(this, "Check the terms and conditions", Toast.LENGTH_SHORT).show()
            }else{
//                creating user entity
                var registerEntity = RegisterEntity(
                    phoneNumber = et_phone.text.toString(),
                    password = et_password.text.toString()
                )


                var registerDatabase : RegisterDatabase = RegisterDatabase.getInstance(context = applicationContext)
                val registerDatabaseDao = registerDatabase.registerDatabaseDao

                doAsync {
                    registerDatabaseDao.insert(registerEntity)
                    Toast.makeText(applicationContext, "Register successful.", Toast.LENGTH_SHORT)
                        .show()
                }

//                Thread(Runnable {
//                    registerDatabaseDao.insert(registerEntity)
//                    Toast.makeText(applicationContext, "Register successful.", Toast.LENGTH_SHORT)
//                        .show()
//                })


            }
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
        } else if (et_password.text.toString().length < 8) {
            til_password.error = "Password should be more than 8 characters."
            return false
        } else {
            til_password.isErrorEnabled = false
            return true
        }
    }

    fun btn_back(view: View) {
        onBackPressed()
    }
}
