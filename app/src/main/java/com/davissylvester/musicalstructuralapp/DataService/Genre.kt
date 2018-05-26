package com.davissylvester.musicalstructuralapp.DataService


data class Genre(var Id: String?, var Name: String?) {

    init {
        Genre.id++
    }
    companion object {
        var id = 0

    }
}


