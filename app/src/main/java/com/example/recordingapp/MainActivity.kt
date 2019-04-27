package com.example.recordingapp

import android.media.MediaPlayer
import android.media.MediaRecorder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException
import java.lang.Exception
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recordStartButton.setOnClickListener {
            startMediaRecord()
        }

        recordStopButton.setOnClickListener {
            stopMediaRecord()
        }

        playStartButton.setOnClickListener {
            startPlay()
        }

        playStopButton.setOnClickListener {
            stopPlay()
        }
    }

    private var mp : MediaPlayer? = null

    private fun startPlay(){
      //  mp = MediaPlayer.create(this , R.raw.sample)
        try {
            mp = MediaPlayer()
            mp?.setDataSource(filePath)
            mp?.prepare()
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

    /*
    録音処理
     */
    private var mr : MediaRecorder? = null
    private val filePath : String = "${Environment.getExternalStorageDirectory()}/sample.wav"

    fun startMediaRecord(){
        try {
            var mediaFile : File? = File(filePath)
            if(mediaFile!!.exists()){
                mediaFile?.delete()
            }
            mediaFile = null

            mr = MediaRecorder()
            mr?.setAudioSource(MediaRecorder.AudioSource.MIC)
            mr?.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT)
            mr?.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT)
            mr?.setOutputFile(filePath)
            mr?.prepare()
            mr?.start()
        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    fun stopMediaRecord(){
        try {
            mr?.stop()
            mr?.reset()
            mr?.release()
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}
