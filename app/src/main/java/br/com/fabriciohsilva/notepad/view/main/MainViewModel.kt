package br.com.fabriciohsilva.notepad.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.fabriciohsilva.notepad.model.Note
import br.com.fabriciohsilva.notepad.repository.NoteRepository

class MainViewModel: ViewModel() {

    val noteRepository = NoteRepository()

    val notes : MutableLiveData<List<Note>> = MutableLiveData()
    val msgError : MutableLiveData<String> = MutableLiveData()
    val isLoading : MutableLiveData<Boolean> = MutableLiveData()

    fun searchAll() {
        isLoading.value = true

        noteRepository.searchAll(
            onComplete = {
                isLoading.value = false
                notes.value = it

            }, //end onComplete
            onError = {
                isLoading.value = false
                msgError.value = it?.message
            })//end onError

    }//end fun searchAll()

}//end class MainViewModel: ViewModel()