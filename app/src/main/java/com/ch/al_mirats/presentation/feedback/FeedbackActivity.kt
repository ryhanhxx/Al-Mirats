package com.ch.al_mirats.presentation.feedback

import android.content.Context
import android.content.Intent
import android.net.Uri
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

//            val userMap = hashMapOf(
//                "email" to sInputEmail,
//                "komen" to sInputKomen
//            )

            binding.progressBar.visibility = View.VISIBLE

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:almiratsdev@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, comment)
            }

            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }else {
                Toast.makeText(this, "Required app is not installed", Toast.LENGTH_SHORT).show()
            }



//            db.collection("user").document().set(userMap)
//                .addOnSuccessListener {
//                    binding.progressBar.visibility = View.GONE
//                    Toast.makeText(this, "Berhasil mengirim feedback", Toast.LENGTH_SHORT).show()
//                    binding.etInputEmail.text?.clear()
//                    binding.etInputKomen.text?.clear()
//                }
//                .addOnFailureListener {
//                    binding.progressBar.visibility = View.GONE
//                    Toast.makeText(this, "Gagal mengirim feedback", Toast.LENGTH_SHORT).show()
//                }
        }
    }



    private fun setOnClickBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }


}