package net.qpaysolutions.mywallet.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.qpaysolutions.mywallet.R

class MainActivity : AppCompatActivity() {
    lateinit var tv_signup: TextView
    lateinit var btn_signin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_signup = findViewById(R.id.activity_main_tv_signup);
        btn_signin = findViewById(R.id.activity_main_btn_signin)

        tv_signup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        btn_signin.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

    }

}