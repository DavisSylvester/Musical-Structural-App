package com.davissylvester.musicalstructuralapp.DataService

class MusicListingService {

    constructor() {
        this._data = populateList()
    }

    private var _data: MutableList<Song>


    var data: MutableList<Song>
        get() {
            return this._data
        }
        set(value) {
            this._data = value
        }


    fun populateList(): MutableList<Song> {

        var result = mutableListOf<Song>()

        result.add(Song("Little Red Corvette", Artist("Prince", "", "prince.jpg"), "R&B" ))
        result.add(Song("Diamonds and Pearls", Artist("Prince", "", "prince.jpg"), "R&B" ))
        result.add(Song("Take Me With U", Artist("Prince", "", "prince.jpg"), "R&B" ))
        result.add(Song("1999", Artist("Prince", "", "prince.jpg"), "R&B" ))
        result.add(Song("Raspberry Beret", Artist("Prince", "", "prince.jpg"), "R&B" ))
        result.add(Song("International Lover", Artist("Prince", "", "prince.jpg"), "R&B" ))

        return result

    }
}

