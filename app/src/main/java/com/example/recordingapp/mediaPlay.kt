package com.example.recordingapp


import java.io.IOException
import java.lang.IllegalStateException
import android.media.MediaPlayer

   private var mp : MediaPlayer? = null

    fun startPlay(){
        try {
            mp = MediaPlayer()
            mp?.setDataSource(filePath)
            mp?.prepare()
            mp?.start()
        }catch (e : IOException){
            e.printStackTrace()
        }
    }
    fun stopPlay(){
        try {
            mp?.stop()
            mp?.prepare()
            mp?.release()
        }catch (e : IllegalStateException){
            e.printStackTrace()
        }catch (e : IOException){
            e.printStackTrace()
        }
    }

