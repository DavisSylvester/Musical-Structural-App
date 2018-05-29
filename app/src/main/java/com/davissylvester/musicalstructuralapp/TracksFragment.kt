package com.davissylvester.musicalstructuralapp


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davissylvester.musicalstructuralapp.Activities.ArtistDetail
import com.davissylvester.musicalstructuralapp.Adapters.ArtistAdapter
import com.davissylvester.musicalstructuralapp.DataService.MusicListingService


class TracksFragment : Fragment() {

    private lateinit var mRecycleView: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<*>
    private lateinit var mlayoutManager: RecyclerView.LayoutManager

    private val data = MusicListingService().Artists

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_tracks, container, false)
        setDefaults(view)
        return view

    }

    private fun setDefaults(view: View) {

        mRecycleView = view.findViewById(R.id.rvTracks)

        mAdapter = ArtistAdapter(context, data) { artist ->
            run {

                val intent = Intent(context, ArtistDetail::class.java).apply {
                    putExtra("Artist", artist)
                }
                startActivity(intent)
            }
        }

        mlayoutManager = GridLayoutManager(context, 3)

        mRecycleView.apply {
            setHasFixedSize(true)
            adapter = mAdapter
            layoutManager = mlayoutManager
        }
    }


}
