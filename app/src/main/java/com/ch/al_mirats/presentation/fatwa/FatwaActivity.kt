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
        playVideo()

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

    private fun setOnClickBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun playVideo(){
        val youTubePlayerView: YouTubePlayerView = binding.youtubePlayerView
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "S0Q4gqBUs7c"
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

//        val webView = binding.webView
//        val video =
//            "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=oMfuX_bhrDw\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
//        webView.loadData(video, "text/html", "utf-8")
//        webView.settings.javaScriptEnabled = true
//        webView.webChromeClient = WebChromeClient()
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