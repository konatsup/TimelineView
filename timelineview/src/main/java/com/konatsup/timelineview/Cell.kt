package com.konatsup.timelineview

import android.graphics.Color

class Cell {
    var color: Int = 0
    var resId: Int = 0
    var isStart: Boolean = false
    var isEnd: Boolean = false

    internal constructor(composition: Composition) {
        if (composition is AudioComposition) {
            color = Color.BLUE
            resId = R.drawable.audio_image_sample
        } else if (composition is MidiComposition) {
            color = Color.GREEN
            resId = R.drawable.midi_image_sample
        }
        isStart = false
        isEnd = false
    }

    internal constructor(color: Int) {
        this.color = color
        resId = -1
        isStart = false
        isEnd = false
    }
}
