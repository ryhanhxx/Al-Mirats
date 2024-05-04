package com.ch.al_mirats.presentation.feedback

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.databinding.ActivityFeedbackBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FeedbackActivity : AppCompatActivity() {
    private val binding: ActivityFeedbackBinding by lazy{
        ActivityFeedbackBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setOnClickBack()

        binding.btnKirimMasukan.setOnClickListener {

            val subject = binding.etSubject.text.toString().trim()
            val comment = binding.etComment.text.toString().trim()

            if (subject.isBlank()) {
                binding.etSubject.error = "Subject harus diisi!"
                binding.etSubject.requestFocus()
                return@setOnClickListener
            }
            if (comment.isBlank()) {
                Toast.makeText(this, "Komentar anda belum terisi!", Toast.LENGTH_SHORT).show()
                binding.etComment.requestFocus()
                return@setOnClickListener
            }

            binding.progressBar.visibility = View.VISIBLE

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("almiratsdev@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, comment)

            try{
                startActivity(intent)
            }catch (e: Exception){
                Toast.makeText(this, "Required app is not installed", Toast.LENGTH_SHORT).show()
            }
        }
    }



    private fun setOnClickBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }


}