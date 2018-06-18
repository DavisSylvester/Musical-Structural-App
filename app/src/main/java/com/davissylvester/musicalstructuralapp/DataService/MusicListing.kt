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

        result.add(Song("Little Red Corvette", Artist("Prince", "", "prince", "Prince"), "R&B", "v0KpfrJE4zw"))
        result.add(Song("Diamonds and Pearls", Artist("Prince", "", "prince", "Prince"), "R&B", "hwUKR_9Xdns" ))
        result.add(Song("Take Me With U", Artist("Prince", "", "prince", "Prince"), "R&B", "c80mYF6dR7s" ))
        result.add(Song("1999", Artist("Prince", "", "prince", "Prince"), "R&B", "rblt2EtFfC4" ))
        result.add(Song("Raspberry Beret", Artist("Prince", "", "prince", "Prince"), "R&B", "l7vRSu_wsNc" ))
        result.add(Song("International Lover", Artist("Prince", "", "prince", "Prince"), "R&B", "vuaj8ExTYOM" ))

        result.addAll(populateJayZSongs())
        result.addAll(populateDMXSongs())
        result.addAll(populateNASSongs())


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

    private fun populateJayZSongs(): MutableList<Song> {

        var result = mutableListOf<Song>()

        result.add(Song("Dead Presidents", Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "6BCsxQg3NE4" ))
        result.add(Song("Big Pimpin", Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "Cgoqrgc_0cM" ))
        result.add(Song("Girls, Girls, Girls", Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "XhpVo23zC6Q" ))
        result.add(Song("Holy Grail", Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "a6T5azW4qEA" ))
        result.add(Song("03 Bunny and Clyde", Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "xm0Xba8eFTg" ))
        result.add(Song("Jigga What, Jigga Who", Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "frIA7tuBqqY" ))
        result.add(Song("Hard Knock Life", Artist("Shawn", "Carter", "jayz", "Jay Z"), "R&B", "VF-5uZ4krHE" ))

        return result
    }

    private fun populateDMXSongs(): MutableList<Song> {

        var result = mutableListOf<Song>()

        result.add(Song("X Gon Give it to Ya", Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "fGx6K90TmCI" ))
        result.add(Song("Where the Hood at", Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "6CqXgs-7ico" ))
        result.add(Song("Get At me Dawg", Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "oM_lFtEFidA" ))
        result.add(Song("Dog", Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "X_GT1MREo18"))
        result.add(Song("What these Bitches Want", Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "nEwc29VaUYg" ))
        result.add(Song("No Sunshine", Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "TEejWL5OVcM" ))
        result.add(Song("X-Is COming", Artist("Earl", "Simmons", "dmx", "DMX"), "R&B", "_4q-TFd5SfU"))

        return result
    }

    private fun populateNASSongs(): MutableList<Song> {

        var result = mutableListOf<Song>()

        result.add(Song("One Mic", Artist("Nasir", "Jones", "nas", "NAS"), "R&B", "JCOURZ-yx4E"))
        result.add(Song("The Whole is Yours", Artist("Nasir", "Jones", "nas", "NAS"), "R&B", "_srvHOu75vM"))
        result.add(Song("Hate me Now", Artist("Nasir", "Jones", "nas", "NAS"), "R&B", "n2-rN-98kFQ"))
        result.add(Song("One Love", Artist("Nasir", "Jones", "nas", "NAS"), "R&B", "hxce_qvhi5I"))
        result.add(Song("Get Down", Artist("Nasir", "Jones", "nas", "NAS"), "R&B", "cS_bDnxCnkc"))

        return result
    }
}

