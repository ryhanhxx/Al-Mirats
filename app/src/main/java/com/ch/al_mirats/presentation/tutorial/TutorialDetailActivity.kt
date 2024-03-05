package com.ch.al_mirats.presentation.tutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.ch.al_mirats.databinding.ActivityTutorialDetailBinding
import com.ch.al_mirats.model.Tutorial
import com.ch.al_mirats.utils.GenericViewModelFactory

class TutorialDetailActivity : AppCompatActivity() {

    private val binding: ActivityTutorialDetailBinding by lazy {
        ActivityTutorialDetailBinding.inflate(layoutInflater)
    }

    private val viewModel: TutorialViewModel by viewModels {
        GenericViewModelFactory.create(TutorialViewModel(intent?.extras))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        showTutorialData(viewModel.tutorial)

        setOnClickBack()
    }

    private fun showTutorialData(tutorial: Tutorial?) {
        tutorial?.apply {
            binding.ivImg.load(this.imgUrl) {
                crossfade(true)
            }
            binding.tvTitle.text = this.title
            binding.tvTutorial1.text = this.descOne
            binding.tvTutorial2.text = this.descTwo
            binding.tvTutorial3.text = this.descThree
        }
    }

    private fun setOnClickBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val TUTORIAL_KEY = "TUTORIAL_KEY"
        fun startActivity(context: Context, tutorial: Tutorial?) {
            val intent = Intent(context, TutorialDetailActivity::class.java)
            intent.putExtra(TUTORIAL_KEY, tutorial)
            context.startActivity(intent)
        }
    }
}