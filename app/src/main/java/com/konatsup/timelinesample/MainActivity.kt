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

        val track1 = Track(map1)
        val track2 = Track(map2)
        val track3 = Track(map3)

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

        tv.addTrack(track1)
        tv.addTrack(track2)
        tv.addTrack(track3)

        tv.addEmptyTrack()
        tv.addEmptyTrack()
        tv.addEmptyTrack()
        tv.addEmptyTrack()
        tv.addEmptyTrack()
        tv.addEmptyTrack()

    }

}
