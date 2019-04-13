package br.com.fabriciohsilva.notepad

import com.facebook.stetho.Stetho
import android.app.Application


class Notepad : Application() {

    @Override
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}