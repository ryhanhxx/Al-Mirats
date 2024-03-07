package com.ch.al_mirats.presentation.fatwa

import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ch.al_mirats.databinding.ActivityFatwaBinding
import com.ch.al_mirats.model.Fatwa
import com.ch.al_mirats.utils.GenericViewModelFactory
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import java.util.regex.Pattern


class FatwaActivity : AppCompatActivity() {
    private val binding: ActivityFatwaBinding by lazy {
        ActivityFatwaBinding.inflate(layoutInflater)
    }

    private val viewModel: FatwaViewModel by viewModels {
        GenericViewModelFactory.create(FatwaViewModel(intent?.extras))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        showFatwaData(viewModel.fatwa)

        setOnClickBack()
        viewModel.fatwa?.videoUrl?.let { playVideo(it) }

    }

    private fun setOnClickBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun showFatwaData(fatwa: Fatwa?) {
        fatwa?.apply {
//            binding.ivImg.load(this.imgUrl) {
//                crossfade(true)
//            }
            binding.tvTitle.text = this.title
            binding.tvDesc.text = this.desc
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