package `in`.nitin.supersub.ui

import `in`.nitin.supersub.api.ApiHelper
import `in`.nitin.supersub.api.RetrofitBuilder
import `in`.nitin.supersub.databinding.ActivityMainBinding
import `in`.nitin.supersub.model.ApiResponse
import `in`.nitin.supersub.ui.base.ViewModelFactory
import `in`.nitin.supersub.utils.Status.*
import `in`.nitin.supersub.utils.toVideoId
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var viewModel: MainViewModel
    private val TAG = "MAIN ACTIVITY"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel =
            ViewModelProviders.of(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
                .get(MainViewModel::class.java)
        lifecycle.addObserver(binding.youtubePlayerView)
//        progressBar = ProgressBar(this,null, R.attr.progressBarStyle)
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.getDrill().observe(this, Observer {
            it.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
//                        progressBar.visibility = View.GONE
                        binding.mainLayout.visibility = View.VISIBLE
                        resource.data?.let { data ->
                            updateUI(data)
                        }
                    }
                    ERROR -> {
                        Log.d(TAG, "setUpObservers: ${resource.message}")
                    }
                    LOADING -> {
                        Toast.makeText(this, "Loading......", Toast.LENGTH_LONG).show()
                    }
                }

            }
        })
    }

    private fun updateUI(data: ApiResponse) {
        binding.apply {
            toolbar.title = data.category.capitalize()
            textViewTitle.text = data.title
            textViewDescription.text = data.description
            textViewSets.text = "${data.exercise.sets} Sets ${data.exercise.reps} Reps"
            textWagonDescription.text = data.illustrations[0].description

            Glide.with(this@MainActivity)
                .load(data.illustrations[0].imageUrl)
                .into(binding.imageViewInfographics)

            binding.youtubePlayerView.addYouTubePlayerListener(object :
                AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.loadVideo(data.video.url.toVideoId(), 0F)
                }
            })
        }
    }

}