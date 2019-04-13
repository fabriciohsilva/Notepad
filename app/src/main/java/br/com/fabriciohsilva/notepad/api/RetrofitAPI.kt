package br.com.fabriciohsilva.notepad.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.facebook.stetho.okhttp3.StethoInterceptor


class RetrofitAPI<T> {

    fun getClient(c: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://blocodenotasmeunome.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOKhttpClient())
            .build()
        return retrofit.create(c)
    }//end fun getClient

}//end class RetrofitAPI<T>

fun getOKhttpClient(): OkHttpClient {

    return OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()

}//end fun getOKhttpClient

fun getNoteAPI(): NoteAPI {
    return  RetrofitAPI<NoteAPI>().getClient(NoteAPI::class.java)
}//end fun getNoteAPI