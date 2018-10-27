package com.konatsup.timelineview

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.FrameLayout
import android.widget.Toast

import java.util.ArrayList
import java.util.HashMap

class TimelineView : FrameLayout, AdapterView.OnItemClickListener {

    var timelineType: TimelineType? = null
    var trackList: ArrayList<Track>? = null
    var currentPosition: Int = 0
    var columnCount: Int = 0
        set(columnCount) {
            field = columnCount
            fglm.setTotalColumnCount(this.columnCount)
        }


    private lateinit var recyclerView: RecyclerView
    private val adapter = CellViewAdapter()
    private val fglm = FixedGridLayoutManager()

    val trackCount: Int
        get() = requireNotNull(trackList).size

    constructor(context: Context) : super(context) {}

    @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {


        val inflater = LayoutInflater.from(context)
        val rootView = inflater.inflate(R.layout.timeline_view, this, true)

        recyclerView = rootView.findViewById(R.id.recycler_view)

        adapter.setOnItemClickListener(this)

        fglm.setTotalColumnCount(0)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = fglm
        recyclerView.adapter = adapter

    }


    /* functions */
    fun addTrack(track: Track) {
        trackList!!.add(track)
        adapter.update(trackList, this.columnCount)
        adapter.notifyDataSetChanged()
    }

    fun addEmptyTrack() {
        @SuppressLint("UseSparseArrays")
        val map = HashMap<Int, Composition>()
        val track = Track(map)
        trackList!!.add(track)
        adapter.update(trackList, this.columnCount)
        adapter.notifyDataSetChanged()
    }

    fun updateTrack(index: Int, track: Track) {
        trackList!![index] = track
        adapter.update(trackList, this.columnCount)
        adapter.notifyDataSetChanged()
    }

    fun deleteTrackForPosition(pos: Int) {
        trackList!!.removeAt(pos)
        adapter.update(trackList, this.columnCount)
        adapter.notifyDataSetChanged()
    }

    fun getTrack(position: Int): Track {
        return trackList!![position]
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        // do Click Action

    }
}