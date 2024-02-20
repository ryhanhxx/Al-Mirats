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
    private lateinit var inputEmail: EditText
    private lateinit var inputKomen: EditText
    private lateinit var btnKirim: Button
    private lateinit var progressBar: ProgressBar

    private var db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setOnClickBack()

        inputEmail = findViewById(R.id.et_inputEmail)
        inputKomen = findViewById(R.id.et_inputKomen)
        btnKirim = findViewById(R.id.btn_kirimMasukan)
        progressBar = findViewById(R.id.progressBar)


        btnKirim.setOnClickListener {

            val sInputEmail = inputEmail.text.toString().trim()
            val sInputKomen = inputKomen.text.toString().trim()

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

            progressBar.visibility = View.VISIBLE

            db.collection("user").document().set(userMap)
                .addOnSuccessListener {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, "Berhasil mengirim feedback", Toast.LENGTH_SHORT).show()
                    inputEmail.text.clear()
                    inputKomen.text.clear()
                }
                .addOnFailureListener {
                    progressBar.visibility = View.GONE
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