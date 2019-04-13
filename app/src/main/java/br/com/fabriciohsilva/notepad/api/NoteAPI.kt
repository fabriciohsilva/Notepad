package br.com.fabriciohsilva.notepad.api

import br.com.fabriciohsilva.notepad.model.Note
import retrofit2.Call
import retrofit2.http.GET

interface NoteAPI {

    /*@GET("/nota/{id}")
    fun getNotes(@Path("id") id:String)*/

    @GET("/nota")
    fun getNotes() : Call<List<Note>>
}