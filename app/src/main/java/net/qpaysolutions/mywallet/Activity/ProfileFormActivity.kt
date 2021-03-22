package net.qpaysolutions.mywallet.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import net.qpaysolutions.mywallet.R

class ProfileFormActivity : AppCompatActivity() {
    lateinit var btn_continue : Button
    lateinit var til_fname : TextInputLayout
    lateinit var til_lname : TextInputLayout
    lateinit var til_email : TextInputLayout
    lateinit var et_fname : TextInputEditText
    lateinit var et_lname : TextInputEditText
    lateinit var et_email : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_form)

        btn_continue = findViewById(R.id.activity_profile_form_btn_continue)
        til_fname = findViewById(R.id.activity_profile_form_til_fname)
        til_lname = findViewById(R.id.activity_profile_form_til_lname)
        til_email = findViewById(R.id.activity_signup_til_email)
        et_fname = findViewById(R.id.activity_profile_form_et_fname)
        et_lname = findViewById(R.id.activity_profile_form_et_lname)
        et_email = findViewById(R.id.activity_profile_form_et_email)

        btn_continue.setOnClickListener {
            if (!validateFname() || !validateLname() || !validateEmail()){
                return@setOnClickListener
            }else {
                var intent = Intent(this, DashBoardActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validateFname(): Boolean {
        if (et_fname.text.toString().isEmpty()) {
            til_fname.error = "Please enter the First name."
            return false
        } else {
            til_fname.isErrorEnabled = false
            return true
        }
    }

    private fun validateLname(): Boolean {
        if (et_lname.text.toString().isEmpty()) {
            til_lname.error = "Please enter the Last name."
            return false
        } else {
            til_lname.isErrorEnabled = false
            return true
        }
    }

    private fun validateEmail(): Boolean {
        if (et_email.text.toString().isEmpty()) {
            til_email.error = "Please enter the Email."
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(et_email.text.toString()).matches()) {
            til_email.error="Please enter a valid email address"
            return false
        }else {
            til_email.isErrorEnabled = false
            return true
        }
    }
}