package com.example.smusicplayer

import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.smusicplayer.models.SongModel
import com.google.firebase.firestore.FirebaseFirestore
import io.grpc.Context

object MyExoplayer {

    private var exoPlayer : ExoPlayer? = null
    private var currentSong : SongModel? = null

    fun getCurrentSong() : SongModel? {
        return currentSong
    }

    fun getInstance(): ExoPlayer?{
        return exoPlayer
    }

    fun startPlaying(context : android.content.Context, song : SongModel){
        if (exoPlayer == null)
        exoPlayer = ExoPlayer.Builder(context).build()

        if (currentSong!=song){
            currentSong = song
            currentSong?.url?.apply {
                val mediaItem = MediaItem.fromUri(this)
                exoPlayer?.setMediaItem(mediaItem)
                exoPlayer?.prepare()
                exoPlayer?.play()
            }
        }


    }


}