package br.com.fabriciohsilva.notepad.repository

import br.com.fabriciohsilva.notepad.api.getNoteAPI
import br.com.fabriciohsilva.notepad.model.Note
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoteRepository {

    fun searchAll(
        onComplete:(List<Note>?) -> Unit,
        onError:(Throwable?) -> Unit
    ) {
        getNoteAPI()
            .getNotes()
            .enqueue(object : Callback<List<Note>>{
                override fun onFailure(call: Call<List<Note>>, t: Throwable) {
                    onError(t)
                }//end override fun onFailure

                override fun onResponse(call: Call<List<Note>>, response: Response<List<Note>>) {
                    if(response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Error on fetch data."))
                    }//end if(response.isSuccessful)

                }//end override fun onResponse

            })//end .enqueue

    }//end fun searchAll

}//end class NoteRepository