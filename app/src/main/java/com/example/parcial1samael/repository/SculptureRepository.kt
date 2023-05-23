package com.example.parcial1samael.repository

import com.example.parcial1samael.data.models.SculptureModel

class SculptureRepository(private val sculptures: MutableList<SculptureModel>) {
    fun getSculptures() = sculptures

    fun addSculptures(newSculpture: SculptureModel) = sculptures.add(newSculpture)
}