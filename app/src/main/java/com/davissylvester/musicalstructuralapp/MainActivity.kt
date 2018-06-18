package com.davissylvester.musicalstructuralapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.util.Log
import com.davissylvester.musicalstructuralapp.Fragmenets.ArtistFragment
import com.davissylvester.musicalstructuralapp.Fragmenets.TracksFragment
import kotlinx.android.synthetic.main.fragment_blank.*


class MainActivity : AppCompatActivity() {

    private var gls: FragmentManager = getSupportFragmentManager()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var navMenu: BottomNavigationView = fragBottomNav

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

        val tracks = TracksFragment()
        startTracksFragment(tracks)


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


