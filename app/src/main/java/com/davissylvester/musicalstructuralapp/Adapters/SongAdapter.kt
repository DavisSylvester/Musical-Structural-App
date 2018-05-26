package com.davissylvester.musicalstructuralapp.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.davissylvester.musicalstructuralapp.DataService.Song
import com.davissylvester.musicalstructuralapp.R


class SongAdapter(val context: Context, private var data: MutableList<Song>) : RecyclerView.Adapter<SongAdapter.Companion.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.artist_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindSong(data[position], context)
    }


    companion object {
        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

            private val artistImage = itemView?.findViewById<ImageView>(R.id.artistPic)
            private val txtSongTitle = itemView?.findViewById<TextView>(R.id.txtSongName)
            private val txtSongArtistName = itemView?.findViewById<TextView>(R.id.txtArtistName)

            fun bindSong(song: Song, context: Context) {

                val resourceId = context.resources.getIdentifier(song.Artist.photo, "drawable", context.packageName)

                artistImage?.setImageResource(resourceId)
                txtSongArtistName?.text = "${song.Artist.FirstName} ${song.Artist.LastName}"
                txtSongTitle?.text = song.Name

            }
        }
    }


}
