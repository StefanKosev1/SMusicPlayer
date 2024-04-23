package com.example.smusicplayer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SplashActivity: AppCompatActivity() {


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //use to hide action bar
        supportActionBar?.hide()

        auth = Firebase.auth

        //use to put delay
        Handler(Looper.getMainLooper()).postDelayed({

            val user = auth.currentUser
            if (user != null ) {
                //use to start an activity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

                //use to destroy current activity
                finish()
            }else {
                //use to start an activity
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)

                //use to destroy current activity
                finish()
            }
        },3000) //300 millis = 3 seconds
    }

    override fun onResume() {
        super.onResume()
    }
}