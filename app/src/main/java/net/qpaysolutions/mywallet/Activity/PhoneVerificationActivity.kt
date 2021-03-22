package net.qpaysolutions.mywallet.Activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.qpaysolutions.mywallet.R

class PhoneVerificationActivity : AppCompatActivity() {
    lateinit var tv_phone : TextView
    lateinit var btn_back : ImageButton
    lateinit var et_otp_code1 : EditText
    lateinit var et_otp_code2: EditText
    lateinit var et_otp_code3: EditText
    lateinit var et_otp_code4: EditText
    lateinit var et_otp_code5: EditText
    lateinit var et_otp_code6: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_verification)

        tv_phone = findViewById(R.id.activity_phone_verification_tv_phone)
        btn_back = findViewById(R.id.btn_back)
        et_otp_code1 = findViewById(R.id.activity_phone_verification_et_otp1)
        et_otp_code2 = findViewById(R.id.activity_phone_verification_et_otp2)
        et_otp_code3 = findViewById(R.id.activity_phone_verification_et_otp3)
        et_otp_code4 = findViewById(R.id.activity_phone_verification_et_otp4)
        et_otp_code5 = findViewById(R.id.activity_phone_verification_et_otp5)
        et_otp_code6 = findViewById(R.id.activity_phone_verification_et_otp6)

        val phone :String = intent.getStringExtra("ph_number").toString()
        tv_phone.setText(phone)

        optTextChangedListener()
    }

    fun optTextChangedListener(){
        et_otp_code1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length == 1) {
                    et_otp_code2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        et_otp_code2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length == 1) {
                    et_otp_code3.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        et_otp_code3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length == 1) {
                    et_otp_code4.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        et_otp_code4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length == 1) {
                    et_otp_code5.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        et_otp_code5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length == 1) {
                    et_otp_code6.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    fun btn_back(view: View){
        onBackPressed()
    }
}