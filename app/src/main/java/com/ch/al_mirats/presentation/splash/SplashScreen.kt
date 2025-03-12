package com.ch.al_mirats.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityFeedbackBinding
import com.ch.al_mirats.databinding.ActivitySplashScreenBinding
import com.ch.al_mirats.presentation.about.AboutActivity
import com.ch.al_mirats.presentation.home.HomeFragment
import com.ch.al_mirats.presentation.main.MainActivity
import com.ch.al_mirats.presentation.settings.SettingsDialogFragment

class SplashScreen : AppCompatActivity() {
    private val binding: ActivitySplashScreenBinding by lazy{
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

//    private val SPLASH_TIME_OUT: Long = 1000 // Durasi splash screen dalam milidetik (3 detik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        Handler().postDelayed({
//            // Aksi yang akan dilakukan setelah splash screen selesai
//            val intent = Intent(
//                this,
//                MainActivity::class.java
//            ) // Ganti dengan activity tujuan setelah splash screen
//            startActivity(intent)
//            finish()
//        }, SPLASH_TIME_OUT)

        navigateToHome()

    }

    private fun navigateToHome(){
        binding.btnStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}