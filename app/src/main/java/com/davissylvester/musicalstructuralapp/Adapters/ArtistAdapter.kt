package com.davissylvester.musicalstructuralapp.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.davissylvester.musicalstructuralapp.DataService.Artist
import com.davissylvester.musicalstructuralapp.R

class ArtistAdapter(val context: Context?,
                    private var data: MutableList<Artist>,
                    private val itemClicked: (Artist) -> Unit) :
        RecyclerView.Adapter<ArtistAdapter.Companion.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.artist_list_item, parent, false)
        return ViewHolder(view, itemClicked)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindArtist(data[position], context)
    }


    companion object {
        class ViewHolder(itemView: View?,
                         private val itemClicked: (Artist) -> Unit):
                RecyclerView.ViewHolder(itemView) {

            private val artistImage = itemView?.findViewById<ImageView>(R.id.imgArtistPicture)
            private val txtName = itemView?.findViewById<TextView>(R.id.imgArtistName)

            fun bindArtist(artist: Artist, context: Context?) {

                val resourceId = context?.resources?.getIdentifier(artist.photo,
                        "drawable",
                        context.packageName)

                artistImage?.setImageResource(resourceId!!)

                txtName?.text = "${artist.StageName}"

                itemView.setOnClickListener { itemClicked(artist) }
            }
        }
    }


}

