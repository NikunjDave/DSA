package lowleveldesign

import java.util.LinkedList
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Given a list of songs, write a shuffler such any song played once
 * can only played after kth time
 * E.g. if songs [s1,s2,s3,s4,s5], if i play s1 first and k is 2
 * s1 should not be played until next k time
 *
 */
enum class Genre{
    POP,HIPHOP,JAZZ,ROCK,FOLK
}
class Song(val id:String, val songName : String, val singer: String, val genre : Genre)

class MusicPlayer {
    val musicList =  mutableListOf<Song>()
    val musicQueue = LinkedList<Song>()
    var totalSongCount = 0 // this is very crucial var, it will increase as songs added and decrease when song played
    // add song to list
    fun addSong(song: Song){
        musicList.add(song)
        totalSongCount ++
    }

    fun playSong(songId: String, addToQ : Boolean){
        val song = musicList.find { it.id == songId}
        // remove song from list
        musicList.remove(song)
        println("playing song : ${song?.songName}")
        totalSongCount --
        // add song to the end of the list
        musicList.add(song!!)
        if(addToQ)
            musicQueue.addLast(song)
    }

    /**
     * Here we pick random song
     * imp thing here is that
     */
    fun playRandomSong(){
        // this will give the random index till index of totalSongCount, after totalSongCount index
        // we are having list of songs which are already played, so it will return unique song always
        val randomIndex = Random.nextInt(totalSongCount)
        // now as per our req. if we allow to play same after k times or lets say k = 2 time than
        // we will exclude the last 2 song
        val maxIndex = if(musicList.size - totalSongCount > 2 ) musicList.size - 2 else totalSongCount
        val random2 = Random.nextInt(maxIndex)

         val song = musicList.removeAt(random2)
         println("playing song : ${song.songName}")
         totalSongCount--
         // add song to the back of the list
        musicList.add(song)
    }

    fun playSongFromQueue(){
        val song = musicQueue.peekFirst()
        println("playing song ${song.songName}")
    }

    fun closeMusicPlayer(){
        println("closing music player")
        musicQueue.clear()
        totalSongCount = musicList.size
    }

}

