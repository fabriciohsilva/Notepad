package br.com.fabriciohsilva.notepad.model

import com.google.gson.annotations.SerializedName

data class Note (
    val id: String,
    @SerializedName("titulo") val title: String,
    @SerializedName("descricao") val description: String
)