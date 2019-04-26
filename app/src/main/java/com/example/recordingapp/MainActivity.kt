package com.example.recordingapp

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            startPlay()
        }

        stopButton.setOnClickListener {
            stopPlay()
        }
    }

    private var mp : MediaPlayer? = null

    private fun startPlay(){
        mp = MediaPlayer.create(this , R.raw.sample)
        try {
            mp?.start()
        }catch (e : IOException){
            e.printStackTrace()
        }
    }
    private fun stopPlay(){
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
}
