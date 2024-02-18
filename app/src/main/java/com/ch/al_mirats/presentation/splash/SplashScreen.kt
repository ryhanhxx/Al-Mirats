package com.ch.al_mirats.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityMainBinding
import com.ch.al_mirats.databinding.ActivitySplashScreenBinding
import com.ch.al_mirats.presentation.main.MainActivity

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    private val SPLASH_TIME_OUT: Long = 3000 // Durasi splash screen dalam milidetik (3 detik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            // Aksi yang akan dilakukan setelah splash screen selesai
            val intent = Intent(this, MainActivity::class.java) // Ganti dengan activity tujuan setelah splash screen
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}