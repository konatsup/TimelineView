package com.konatsup.timelineview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private LinearLayout mCell;
    private ImageView mImageView;
    private View mStartBar;
    private View mEndBar;
    private CellViewAdapter mAdapter;

    public CellViewHolder(View itemView, CellViewAdapter adapter) {
        super(itemView);
        itemView.setOnClickListener(this);

        mAdapter = adapter;
        mCell = (LinearLayout) itemView.findViewById(R.id.cell);
        mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        mStartBar = (View) itemView.findViewById(R.id.startBar);
        mEndBar = (View) itemView.findViewById(R.id.endBar);
    }

    @Override
    public void onClick(View v) {
        mAdapter.onItemHolderClick(this);
    }

    public void setCellColor(int color) {
        mCell.setBackgroundColor(color);
    }

    public void setText(int position) {
        ((TextView) mCell.findViewById(R.id.text)).setText(String.valueOf(position));
    }

    public void setImage(int resId) {
        if (resId == -1) {
            mImageView.setImageDrawable(null);
        } else {
            mImageView.setImageResource(resId);
        }
    }

    public void setVisibility(boolean isStart, boolean isEnd) {
        if (isStart) {
            mStartBar.setVisibility(View.VISIBLE);
        } else {
            mStartBar.setVisibility(View.GONE);
        }

        if (isEnd) {
            mEndBar.setVisibility(View.VISIBLE);
        } else {
            mEndBar.setVisibility(View.GONE);
        }

    }

}