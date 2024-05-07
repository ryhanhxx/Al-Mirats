package com.ch.al_mirats.presentation.materi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.ch.al_mirats.databinding.ActivityMateriBinding
import com.ch.al_mirats.dummy.DummyMateriRecommendDataSourceImpl
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.presentation.main.MainActivity
import com.ch.al_mirats.presentation.materi.adapter.MateriRecommendAdapter
import com.ch.al_mirats.utils.GenericViewModelFactory

class MateriActivity : AppCompatActivity() {

    private val binding: ActivityMateriBinding by lazy {
        ActivityMateriBinding.inflate(layoutInflater)
    }

    private val viewModel: MateriViewModel by viewModels {
        GenericViewModelFactory.create(MateriViewModel(intent?.extras))
    }

    private val adapterMateri: MateriRecommendAdapter by lazy {
        MateriRecommendAdapter { materi: Materi ->
            navigateToDetailFragment(materi)
        }
    }

    private fun navigateToDetailFragment(materi: Materi) {
        MateriActivity.startActivity(this, materi)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        showMateriData(viewModel.materi)

        setOnClickBack()
        setupRecyclerView()
    }

    private fun showMateriData(materi: Materi?) {
        materi?.apply {
            binding.ivImg.load(this.imgUrl) {
                crossfade(true)
            }
            binding.tvTitle.text = this.title
            binding.tvHeading.text = this.heading
            binding.tvDesc.text = this.desc
            binding.tvSubHeading.text = this.subHeading
            binding.tvSubDesc.text = this.subDesc
//            binding.tvSource.text = this.source
            binding.ivImg2.load(this.imgUrl2) {
                crossfade(true)
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvMateri.adapter = adapterMateri
        adapterMateri.setItems(DummyMateriRecommendDataSourceImpl().getMateriRecommendData(this))
    }

    private fun setOnClickBack() {
        binding.ivBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
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