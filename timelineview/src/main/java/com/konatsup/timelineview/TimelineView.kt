package com.konatsup.timelineview

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.FrameLayout

import android.widget.Toast
import java.util.*

class TimelineView : FrameLayout, AdapterView.OnItemClickListener {

    var timelineType: TimelineType = TimelineType.TIME
    var trackList: ArrayList<Track> = ArrayList()
    var currentPosition: Long = 0
    var columnCount: Int = 0
        set(columnCount) {
            field = columnCount
            fglm.totalColumnCount = this.columnCount
        }

    var rhythm: Rhythm = Rhythm(4, 4)
    var tempo: Int = 120

    val trackCount: Int
        get() = trackList.size

    private lateinit var recyclerView: RecyclerView
    private lateinit var positionBarView: PositionBarView
    private var timer: Timer = Timer()

    private val adapter = CellViewAdapter()
    private val fglm = FixedGridLayoutManager()
    private val delay: Long = 0
    private val period: Long = 100

    constructor(context: Context) : super(context) {}

    @JvmOverloads constructor(cont: Context, attrs: AttributeSet, defStyleAttr: Int = 0) : super(cont, attrs, defStyleAttr) {

        val inflater = LayoutInflater.from(context)
        val rootView = inflater.inflate(R.layout.timeline_view, this, true)

        recyclerView = rootView.findViewById(R.id.recycler_view)
        positionBarView = rootView.findViewById(R.id.position_bar_view)

        positionBarView.setOnClickListener(OnClickListener {
            Toast.makeText(context, "Click!!!", Toast.LENGTH_LONG).show()
        })

        adapter.setOnItemClickListener(this)

        fglm.totalColumnCount = 0

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = fglm
        recyclerView.adapter = adapter

    }


    /* functions */
    fun addTrack(track: Track) {
        trackList.add(track)
        adapter.update(trackList, this.columnCount)
        adapter.notifyDataSetChanged()
    }

    fun addEmptyTrack() {
        @SuppressLint("UseSparseArrays")
        val map = HashMap<Int, Composition>()
        val track = Track(map)
        trackList.add(track)
        adapter.update(trackList, this.columnCount)
        adapter.notifyDataSetChanged()
    }

    fun updateTrack(index: Int, track: Track) {
        trackList[index] = track
        adapter.update(trackList, this.columnCount)
        adapter.notifyDataSetChanged()
    }

    fun deleteTrackForPosition(pos: Int) {
        trackList.removeAt(pos)
        adapter.update(trackList, this.columnCount)
        adapter.notifyDataSetChanged()
    }

    fun getTrack(position: Int): Track {
        return trackList[position]
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        // do Click Action

    }

    fun play() {
        timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                handler.post {
                    currentPosition += 5
                    positionBarView.position = currentPosition.toInt()
                }
            }
        }, delay, period)
    }

    fun stop() {
        timer.cancel()
    }

    fun backToTop() {
        currentPosition = 0
        positionBarView.position = 0
    }

    fun setRhythmNumerator(numerator: Int) {
        rhythm = Rhythm(numerator, rhythm.denominator)
    }

    fun setRhythmDenominator(denominator: Int) {
        rhythm = Rhythm(rhythm.numerator, denominator)
    }

    fun setRhythm(numerator: Int, denominator: Int) {
        rhythm = Rhythm(numerator, denominator)
    }

    companion object {
        const val DEFAULT_RESOLUTION = 480
    }
}
