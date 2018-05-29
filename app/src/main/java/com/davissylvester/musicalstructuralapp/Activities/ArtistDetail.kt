package com.davissylvester.musicalstructuralapp.Activities


import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.davissylvester.musicalstructuralapp.Adapters.ArtistProfileAdapter
import com.davissylvester.musicalstructuralapp.DataService.Artist
import com.davissylvester.musicalstructuralapp.DataService.MusicListingService
import com.davissylvester.musicalstructuralapp.DataService.Song
import com.davissylvester.musicalstructuralapp.R
import kotlinx.android.synthetic.main.activity_artist_detail.*


class ArtistDetail : AppCompatActivity() {

    private lateinit var mRecycleView: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<*>
    private lateinit var mlayoutManager: RecyclerView.LayoutManager

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

        mRecycleView = findViewById(R.id.rvSongs)

        mAdapter = ArtistProfileAdapter(this, data)  {

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.Url))
            startActivity(intent)

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
}
