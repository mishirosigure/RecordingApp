package com.example.recordingapp


import android.media.MediaRecorder
import java.lang.Exception
import java.io.File
import android.os.Environment

    /*
    録音処理
     */

    private var mr : MediaRecorder?  = null
    var filePath : String = "${Environment.getExternalStorageDirectory()}/sample.wav"

    fun startMediaRecord(){
        try {
            var mediaFile : File? = File(filePath)
            if(mediaFile!!.exists()){
                mediaFile?.delete()
            }
            //mediaFile = null

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