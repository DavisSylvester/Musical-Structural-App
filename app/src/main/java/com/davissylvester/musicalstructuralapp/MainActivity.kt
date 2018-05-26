package com.davissylvester.musicalstructuralapp



import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.davissylvester.musicalstructuralapp.Adapters.SongAdapter
import com.davissylvester.musicalstructuralapp.DataService.MusicListingService
import kotlinx.android.synthetic.main.fragment_artist.*
import kotlinx.android.synthetic.main.fragment_blank.*


class MainActivity : AppCompatActivity() {

    private var gls: FragmentManager = getSupportFragmentManager()
    private lateinit var mRecycleView: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<*>
    private lateinit var mlayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var fragMenu: LayoutInflater.inflate(R.layout.fragment_blank, null)

        var navMenu: BottomNavigationView = fragBottomNav

        Log.d("Helper", navMenu.toString())


        navMenu.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_artist -> {
                    Log.d("Helper", item.itemId.toString())
                    val act = ArtistFragment()
                    startArtistFragment(act)
                }

                R.id.nav_tracks -> {
                    Log.d("Helper", item.itemId.toString())
                    val act = TracksFragment()
                    startTracksFragment(act)
                }

                R.id.nav_home -> {
                    Log.d("Helper", item.itemId.toString())
                    val act = MainActivity()
                    startHomeFragment(act)
                }
                else -> {

                    Log.d("Helper", "Can't find anything")

                }


            }
            return@setOnNavigationItemSelectedListener true
        }

        // setDefaults()
    }



    private fun setDefaults() {

        mRecycleView = rvArtist

        mRecycleView.apply {
            setHasFixedSize(true)
            adapter = mAdapter
        }

        mlayoutManager = LinearLayoutManager(this)
        mAdapter = SongAdapter(this, MusicListingService().data)

    }

    private fun startHomeFragment(act: MainActivity) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    private fun startArtistFragment(act: ArtistFragment) {

        gls.beginTransaction()
                .replace(R.id.csMainContainer, act)
                .commit()
    }

    private fun startTracksFragment(act: TracksFragment) {

        gls.beginTransaction()
                .replace(R.id.csMainContainer, act)
                .commit()
    }



}


