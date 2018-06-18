package com.davissylvester.musicalstructuralapp.Activities


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.davissylvester.musicalstructuralapp.Adapters.ArtistProfileAdapter
import com.davissylvester.musicalstructuralapp.DataService.Artist
import com.davissylvester.musicalstructuralapp.DataService.MusicListingService
import com.davissylvester.musicalstructuralapp.DataService.Song
import com.davissylvester.musicalstructuralapp.DomainClasses.API_KEY
import com.davissylvester.musicalstructuralapp.R
import com.davissylvester.musicalstructuralapp.R.id.vPlayer
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import kotlinx.android.synthetic.main.activity_artist_detail.*


class ArtistDetail : AppCompatActivity() {

    private lateinit var mRecycleView: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<*>
    private lateinit var mlayoutManager: RecyclerView.LayoutManager

    private lateinit var vv: YouTubePlayerSupportFragment
    private lateinit var youTubeListener: OnInitializedListener
    private lateinit var player: YouTubePlayer
    private var artistDetail = this

    private lateinit var data: MutableList<Song>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_detail)

        val intent = intent
        val artist: Artist = intent.getParcelableExtra("Artist")

        data = getListOfSongByStageName(artist.StageName)

        setDefaults(artist.StageName)


    }

    private fun setDefaults(stageName: String) {

        vv = vPlayer as YouTubePlayerSupportFragment

        youTubePlayerInit()

        vv.initialize(API_KEY, youTubeListener);

        mRecycleView = findViewById(R.id.rvSongs)

        mAdapter = ArtistProfileAdapter(this, data)  {

            PlayVideo(it.Url)

        }

        mlayoutManager = LinearLayoutManager(this)

        mRecycleView.apply {
            setHasFixedSize(true)
            adapter = mAdapter
            layoutManager = mlayoutManager
        }

        setProfilePicture(stageName)
    }

    private fun setProfilePicture(stageName: String) {

        var img = imgArtist

        val resourceId =this.resources?.getIdentifier(stageName.toLowerCase().replace(" ", ""),
                "drawable",
                this.packageName)

        img.setImageResource(resourceId!!)

    }

    private fun getListOfSongByStageName(stageName: String): MutableList<Song> {

        return MusicListingService().Songs.filter {
            song ->
            song.Artist.StageName == stageName

        }.toMutableList()
    }

    private fun youTubePlayerInit() {

        youTubeListener = object: OnInitializedListener {
            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {

            }

            override fun onInitializationSuccess(provider: YouTubePlayer.Provider,
                                                 youTubePlayer: YouTubePlayer, b: Boolean) {
                player = youTubePlayer

                PlayVideo(data[0].Url)


            }

        }

    }

    fun PlayVideo(songUrl: String?) {

        player.loadVideo(songUrl)
    }

    fun goBack(view: View) {
        this.finish()
    }
}
