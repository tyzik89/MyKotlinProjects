package com.work.vladimirs

import java.io.File
import javax.sound.sampled.AudioSystem
import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        playBeats("--------------x-x--------------x-x---------------x-x-x", "src\\main\\resources\\audio\\toms.aiff", "-T-")
    }
    GlobalScope.launch {
        playBeats("-----x----------------x-----------------x------", "src\\main\\resources\\audio\\crash_cymbal.aiff", "-C-")
    }
        playBeats("x--x----x-x-x-----x-x----x-x-x-----x-x----x-x-x-------", "src\\main\\resources\\audio\\snare.aiff", "-S-")

}

fun playBeats (beats: String, file: String, typeLog: String ) {
    val parts = beats.split("x");
    var count = 0
    for (part in parts) {
        count += part.length + 1
        if (part == "") {
            playSound(file, typeLog)
        } else {
            Thread.sleep(100 * (part.length + 1L))
            if (count < beats.length) {
                playSound(file, typeLog)
            }
        }
    }
}

fun playSound(file: String, typeLog: String) {
    val clip = AudioSystem.getClip()
    val audioInputStream = AudioSystem.getAudioInputStream(File(file))
    clip.open(audioInputStream)
    print(typeLog)
    clip.start()
}