package com.davissylvester.musicalstructuralapp.DataService

class MusicListingService {

    lateinit var Artists: MutableList<Artist>
    lateinit var Songs: MutableList<Song>

    constructor() {
        this.Songs = populateSongList()
        this.Artists = populateArtistList()
    }

    private fun populateSongList(): MutableList<Song> {

        var result = mutableListOf<Song>()

        result.add(Song("Little Red Corvette", Artist("Prince", "", "prince", "Prince"), "R&B" ))
        result.add(Song("Diamonds and Pearls", Artist("Prince", "", "prince", "Prince"), "R&B" ))
        result.add(Song("Take Me With U", Artist("Prince", "", "prince", "Prince"), "R&B" ))
        result.add(Song("1999", Artist("Prince", "", "prince", "Prince"), "R&B" ))
        result.add(Song("Raspberry Beret", Artist("Prince", "", "prince", "Prince"), "R&B" ))
        result.add(Song("International Lover", Artist("Prince", "", "prince", "Prince"), "R&B" ))

        return result
    }

    private fun populateArtistList(): MutableList<Artist> {

        var result = mutableListOf<Artist>()

        result.add(Artist("Prince", "Nelson", "prince", "Prince"))
        result.add(Artist("Earl", "Simmons", "dmx", "DMX"))
        result.add(Artist("Nasir", "Jones", "nas", "NAS"))
        result.add(Artist("Shawn", "Carter", "jayz", "Jay Z"))

        return result
    }
}

