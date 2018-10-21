package com.konatsup.timelinesample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.konatsup.timelineview.*

class MainActivity : AppCompatActivity() {

    private lateinit var tv: TimelineView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.timelineView)

        tv.timelineType = TimelineType.TIME
        tv.trackList = ArrayList<Track>()
        tv.currentPosition = 0
        tv.columnCount = 30

        val map1 = HashMap<Int, Composition>()
        val map2 = HashMap<Int, Composition>()
        val map3 = HashMap<Int, Composition>()
        val map4 = HashMap<Int, Composition>()
        val map5 = HashMap<Int, Composition>()
        val map6 = HashMap<Int, Composition>()

        val track1 = Track(map1)
        val track2 = Track(map2)
        val track3 = Track(map3)
        val track4 = Track(map4)
        val track5 = Track(map5)
        val track6 = Track(map6)

        val comp1 = AudioComposition(3)
        val comp2 = MidiComposition(5)
        track1.addComposition(3, comp1)
        track1.addComposition(7, comp2)

        val comp3 = AudioComposition(3)
        val comp4 = MidiComposition(12)
        track2.addComposition(0, comp3)
        track2.addComposition(5, comp4)

        val comp5 = AudioComposition(3)
        val comp6 = MidiComposition(5)
        track3.addComposition(14, comp5)
        track3.addComposition(23, comp6)

        val comp7 = AudioComposition(6)
        val comp8 = MidiComposition(5)
        track4.addComposition(4, comp7)
        track4.addComposition(13, comp8)

        val comp9 = AudioComposition(8)
        val comp10 = MidiComposition(5)
        track5.addComposition(2, comp9)
        track5.addComposition(13, comp10)

        val comp11 = AudioComposition(3)
        val comp12 = MidiComposition(2)
        track6.addComposition(0, comp11)
        track6.addComposition(10, comp12)

        tv.addTrack(track1)
        tv.addTrack(track2)
        tv.addTrack(track3)
        tv.addTrack(track4)
        tv.addTrack(track5)
        tv.addTrack(track6)

        tv.addEmptyTrack()
        tv.addEmptyTrack()
        tv.addEmptyTrack()

    }

}
