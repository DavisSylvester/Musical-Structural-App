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


class ArtistProfileAdapter(val context: Context?,
                           private var data: MutableList<Song>,
                           val itemClicked: (Song) -> Unit) : RecyclerView.Adapter<ArtistProfileAdapter.Companion.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.profile_artist_song_item, parent, false)
        return ViewHolder(view, itemClicked)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindSong(data[position], context)
    }

    companion object {
        class ViewHolder(itemView: View?, private val itemClicked: (Song) -> Unit) : RecyclerView.ViewHolder(itemView) {

            private val artistImage = itemView?.findViewById<ImageView>(R.id.imgArtist)
            private val txtSongTitle = itemView?.findViewById<TextView>(R.id.txtSongName)

            fun bindSong(song: Song, context: Context?) {

                val resourceId = context?.resources?.getIdentifier(song.Artist.photo.toLowerCase(),
                        "drawable",
                        context.packageName)

                artistImage?.setImageResource(resourceId!!)

                txtSongTitle?.text = song.Name

                itemView.setOnClickListener { itemClicked(song) }

            }
        }
    }


}
