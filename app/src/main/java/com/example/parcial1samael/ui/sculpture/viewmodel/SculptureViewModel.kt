package com.example.parcial1samael.ui.sculpture.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial1samael.SculptureReviewerApplication
import com.example.parcial1samael.data.models.SculptureModel
import com.example.parcial1samael.data.sculptures
import com.example.parcial1samael.repository.SculptureRepository

class SculptureViewModel (private val repository: SculptureRepository) : ViewModel() {
    var name = MutableLiveData("")
    var material = MutableLiveData("")
    var status = MutableLiveData("")

    fun getSculptures() = repository.getSculptures()

    private fun addSculptures(sculpture: SculptureModel) = repository.addSculptures(sculpture)

    fun createSculpture(){
        if (!validateData()){
            status.value = WRONG_DATA
            return
        }
        val newSculpture = SculptureModel(
            name.value.toString(),
            material.value.toString()
        )

        addSculptures(newSculpture)
        clearData()
        status.value = SCULPTURE_CREATED
    }

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty()-> return false
            material.value.isNullOrEmpty()-> return false
        }
        return true
    }

    fun clearData(){
        name.value = ""
        material.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun setSelectedSculpture(sculpture: SculptureModel){
        name.value = sculpture.name
        material.value = sculpture.material
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as SculptureReviewerApplication
                SculptureViewModel(app.sculptureRepository)
            }
        }

        const val SCULPTURE_CREATED = "Sculpture created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
}
