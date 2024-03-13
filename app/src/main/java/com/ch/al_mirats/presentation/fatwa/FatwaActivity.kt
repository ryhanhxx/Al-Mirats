package com.ch.al_mirats.presentation.fatwa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.databinding.ActivityFatwaBinding
import com.ch.al_mirats.dummy.DummyFatwaRecommendDataSource
import com.ch.al_mirats.dummy.DummyFatwaRecommendDataSourceImpl
import com.ch.al_mirats.dummy.DummyTopMateriDataSourceImpl
import com.ch.al_mirats.model.Fatwa
import com.ch.al_mirats.model.Materi
import com.ch.al_mirats.presentation.fatwa.adapter.FatwaRecommendAdapter
import com.ch.al_mirats.presentation.main.MainActivity
import com.ch.al_mirats.presentation.materi.MateriActivity
import com.ch.al_mirats.presentation.materi.adapter.MateriRecommendAdapter
import com.ch.al_mirats.utils.GenericViewModelFactory
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class FatwaActivity : AppCompatActivity() {
    private val binding: ActivityFatwaBinding by lazy {
        ActivityFatwaBinding.inflate(layoutInflater)
    }

    private val viewModel: FatwaViewModel by viewModels {
        GenericViewModelFactory.create(FatwaViewModel(intent?.extras))
    }

    private val adapterFatwa: FatwaRecommendAdapter by lazy {
        FatwaRecommendAdapter { fatwa: Fatwa ->
            navigateToDetailFragment(fatwa)
        }
    }

    private fun navigateToDetailFragment(fatwa: Fatwa) {
        FatwaActivity.startActivity(this, fatwa)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        showFatwaData(viewModel.fatwa)
        setOnClickBack()
        viewModel.fatwa?.videoUrl?.let { playVideo(it) }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvFatwa.adapter = adapterFatwa
        adapterFatwa.setItems(DummyFatwaRecommendDataSourceImpl().getFatwaRecommendData(this))
    }

    private fun setOnClickBack() {
        binding.ivBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }

    private fun showFatwaData(fatwa: Fatwa?) {
        fatwa?.apply {
//            binding.ivImg.load(this.imgUrl) {
//                crossfade(true)
//            }
            binding.tvTitle.text = this.title
            binding.tvDesc.text = this.desc
            binding.tvSource.text = this.source
        }
    }

    private fun playVideo(videoId: String) {
        val youTubePlayerView: YouTubePlayerView = binding.youtubePlayerView
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(
            object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            }
        )
    }

    companion object {
        const val FATWA_KEY = "FATWA_KEY"
        fun startActivity(context: Context, fatwa: Fatwa?) {
            val intent = Intent(context, FatwaActivity::class.java)
            intent.putExtra(FATWA_KEY, fatwa)
            context.startActivity(intent)
        }
    }
}