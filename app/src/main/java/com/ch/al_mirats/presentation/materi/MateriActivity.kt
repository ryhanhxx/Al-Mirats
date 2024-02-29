package com.ch.al_mirats.presentation.materi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityMateriBinding
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.utils.GenericViewModelFactory

class MateriActivity : AppCompatActivity() {

    private val binding: ActivityMateriBinding by lazy {
        ActivityMateriBinding.inflate(layoutInflater)
    }

    private val viewModel: MateriViewModel by viewModels {
        GenericViewModelFactory.create(MateriViewModel(intent?.extras))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        showProductData(viewModel.product)

        setOnClickBack()
    }

    private fun showProductData(materi: Materi?) {
        materi?.apply {
            binding.ivImg.load(this.imgUrl) {
                crossfade(true)
            }
            binding.tvTitle.text = this.title
            binding.tvHeading.text = this.heading
            binding.tvDesc.text = this.desc
            binding.tvSubHeading.text = this.subHeading
            binding.tvSubDesc.text = this.subDesc
            binding.tvSource.text = this.source
        }
    }

    private fun setOnClickBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val MATERIAL_KEY = "MATERIAL_KEY"
        fun startActivity(context: Context, materi: Materi?) {
            val intent = Intent(context, MateriActivity::class.java)
            intent.putExtra(MATERIAL_KEY, materi)
            context.startActivity(intent)
        }
    }
}