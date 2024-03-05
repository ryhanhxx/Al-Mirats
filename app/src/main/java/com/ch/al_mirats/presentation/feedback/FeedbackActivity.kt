package com.ch.al_mirats.presentation.feedback

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityFeedbackBinding
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FeedbackActivity : AppCompatActivity() {
    private val binding: ActivityFeedbackBinding by lazy{
        ActivityFeedbackBinding.inflate(layoutInflater)
    }

    private var db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setOnClickBack()


        binding.btnKirimMasukan.setOnClickListener {

            val sInputEmail = binding.etInputEmail.text.toString().trim()
            val sInputKomen = binding.etInputKomen.text.toString().trim()

            if (sInputEmail.isBlank()) {
                binding.etInputEmail.error = "Email harus diisi"
                binding.etInputEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(sInputEmail).matches()) {
                binding.etInputEmail.error = "Format email tidak valid"
                binding.etInputEmail.requestFocus()
                return@setOnClickListener
            }
            if (sInputKomen.isBlank()) {
                Toast.makeText(this, "Komentar anda belum terisi", Toast.LENGTH_SHORT).show()
                binding.etInputKomen.requestFocus()
                return@setOnClickListener
            }

            val userMap = hashMapOf(
                "email" to sInputEmail,
                "komen" to sInputKomen
            )

            binding.progressBar.visibility = View.VISIBLE

            db.collection("user").document().set(userMap)
                .addOnSuccessListener {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, "Berhasil mengirim feedback", Toast.LENGTH_SHORT).show()
                    binding.etInputEmail.text?.clear()
                    binding.etInputKomen.text?.clear()
                }
                .addOnFailureListener {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, "Gagal mengirim feedback", Toast.LENGTH_SHORT).show()
                }
        }
    }



    private fun setOnClickBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }


}