package com.konatsup.timelineview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private FrameLayout mCell;
    private CellViewAdapter mAdapter;

    public CellViewHolder(View itemView, CellViewAdapter adapter) {
        super(itemView);
        itemView.setOnClickListener(this);

        mAdapter = adapter;
        mCell = (FrameLayout) itemView.findViewById(R.id.cell);
    }

    @Override
    public void onClick(View v) {
        mAdapter.onItemHolderClick(this);
    }

    public void setCellColor(int color) {
        mCell.setBackgroundColor(color);
    }

    public void setText(int position ) {
        ((TextView) mCell.findViewById(R.id.text)).setText(String.valueOf(position));
    }

}