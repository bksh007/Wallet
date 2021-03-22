package net.qpaysolutions.mywallet.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import net.qpaysolutions.mywallet.R

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var btn_back: ImageButton
    lateinit var btn_send_code: Button
    lateinit var et_phone: EditText
    lateinit var til_phone: TextInputLayout
    lateinit var number: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        til_phone = findViewById(R.id.activity_forgot_password_til_phone)
        et_phone = findViewById(R.id.activity_forgot_password_et_ph_number)
        btn_send_code = findViewById(R.id.activity_forgot_password_btn_send_code)
        btn_back = findViewById(R.id.btn_back)

        btn_send_code.setOnClickListener {
            if (!validateNum()) {
                return@setOnClickListener
            }
                val i = Intent(this, PhoneVerificationActivity::class.java)
                i.putExtra("ph_number", et_phone.text.toString())
                startActivity(i)
        }

    }

    private fun validateNum(): Boolean {
        if (et_phone.text.toString().isEmpty()) {
            et_phone.error = "Please enter the Ph number."
            et_phone.requestFocus()
            return false
        } else if (et_phone.text.toString().length != 10) {
            et_phone.error = "Please enter valid Ph number."
            et_phone.requestFocus()
            return false
        } else {
            til_phone.isErrorEnabled = false
        }
        return true
    }

    fun btn_back(view: View) {
        onBackPressed()
    }
}