package com.davissylvester.musicalstructuralapp.Fragmenets


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davissylvester.musicalstructuralapp.Adapters.SongAdapter
import com.davissylvester.musicalstructuralapp.DataService.MusicListingService
import com.davissylvester.musicalstructuralapp.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ArtistFragment : Fragment() {

    private lateinit var mRecycleView: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<*>
    private lateinit var mlayoutManager: RecyclerView.LayoutManager

    private val data = MusicListingService().Songs

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_artist, container, false)
        setDefaults(view)
        return view
    }

    private fun setDefaults(view: View) {

        mRecycleView = view.findViewById(R.id.rvArtist)

        mAdapter = SongAdapter(context, data) {
            song ->
            Log.d("Helper", song.Name)
        }

        mlayoutManager = LinearLayoutManager(context)

        mRecycleView.apply {
            setHasFixedSize(true)
            adapter = mAdapter
            layoutManager = mlayoutManager
        }
    }

}
