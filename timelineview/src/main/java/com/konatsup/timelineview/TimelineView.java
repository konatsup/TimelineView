package com.konatsup.timelineview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimelineView extends FrameLayout implements AdapterView.OnItemClickListener {

    private TimelineType timelineType;
    private ArrayList<Track> trackList;
    private int currentPosition;
    private int columnCount;

    private Context mContext;
    private RecyclerView mRecyclerView;
    private CellViewAdapter mAdapter;
    private FixedGridLayoutManager fglm;

    /* constructor */
    public TimelineView(Context context){
        super(context);
    }

    public TimelineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimelineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rootView = inflater.inflate(R.layout.timeline_view, this, true);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);

        mAdapter = new CellViewAdapter();
        mAdapter.setOnItemClickListener(this);

        fglm = new FixedGridLayoutManager();
        fglm.setTotalColumnCount(0);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(fglm);
        mRecyclerView.setAdapter(mAdapter);

    }

    /* getter and setter */
    public TimelineType getTimelineType() {
        return timelineType;
    }

    public void setTimelineType(TimelineType timelineType) {
        this.timelineType = timelineType;
    }

    public ArrayList<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<Track> trackList) {
        this.trackList = trackList;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
        fglm.setTotalColumnCount(this.columnCount);
    }


    /* functions */
    public void addTrack(Track track) {
        trackList.add(track);
        mAdapter.update(trackList, columnCount);
        mAdapter.notifyDataSetChanged();
    }

    public void addEmptyTrack() {
        @SuppressLint("UseSparseArrays")
        Map<Integer, Composition> map = new HashMap<>();
        Track track = new Track(map);
        trackList.add(track);
        mAdapter.update(trackList, columnCount);
        mAdapter.notifyDataSetChanged();
    }

    public void updateTrack(int index, Track track) {
        trackList.set(index, track);
        mAdapter.update(trackList, columnCount);
        mAdapter.notifyDataSetChanged();
    }

    public void deleteTrackForPosition(int pos) {
        trackList.remove(pos);
        mAdapter.update(trackList, columnCount);
        mAdapter.notifyDataSetChanged();
    }

    public int getTrackCount() {
        return trackList.size();
    }

    public Track getTrack(int position) {
        return trackList.get(position);
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext, "Clicked", Toast.LENGTH_SHORT).show();
    }
}
