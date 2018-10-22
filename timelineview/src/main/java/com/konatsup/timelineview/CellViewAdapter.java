package com.konatsup.timelineview;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

public class CellViewAdapter extends RecyclerView.Adapter<CellViewHolder> {

    private ArrayList<Cell> mCellList;

    private AdapterView.OnItemClickListener mOnItemClickListener;

    public CellViewAdapter() {
        mCellList = new ArrayList<>();
    }

    public void setCellList(ArrayList list) {
        mCellList = list;
    }

    public void addItemCount(int count) {
        mCellList.addAll(generateBlankData(count));

        notifyDataSetChanged();
    }

    /* .forEach() will perform when API level is higher than 24 */
    public void update(List<Track> trackList, final int coloumCount) {
        mCellList = new ArrayList<>(Collections.nCopies(coloumCount * trackList.size(), new Cell(Color.DKGRAY)));
        for (int i = 0; i < trackList.size(); i++) {
            final int finalI = i;
            trackList.get(i).getCompositionMap().forEach(new BiConsumer<Integer, Composition>() {
                final int startPosition = finalI * coloumCount;
                @Override
                public void accept(Integer position, Composition composition) {
                    for (int j = 0; j < composition.getDuration(); j++) {
                        Cell cell = new Cell(composition);
                        if (j == 0) cell.setStart(true);
                        if (j == composition.getDuration() - 1) cell.setEnd(true);
                        mCellList.set(startPosition + position + j, cell);
                    }
                }
            });
        }
        notifyDataSetChanged();
    }

    public void addItem(int position) {
        if (position > mCellList.size()) return;
//        mCellList.add(position, generateDummyItem());
        notifyItemInserted(mCellList.size());
    }

    /*
     * Inserting a new item at the head of the list. This uses a specialized
     * RecyclerView method, notifyItemRemoved(), to trigger any enabled item
     * animations in addition to updating the view.
     */
    public void removeItem(int position) {
        if (position >= mCellList.size()) return;

        mCellList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public CellViewHolder onCreateViewHolder(@NonNull ViewGroup container, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View root = inflater.inflate(R.layout.cell, container, false);

        return new CellViewHolder(root, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CellViewHolder itemHolder, int position) {
        Cell item = mCellList.get(position);
        itemHolder.setCellColor(item.getColor());
        itemHolder.setImage(item.getResId());
        itemHolder.setVisibility(item.isStart(), item.isEnd());
    }

    @Override
    public int getItemCount() {
        return mCellList.size();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void onItemHolderClick(CellViewHolder itemHolder) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        }
    }

    @SuppressLint("UseSparseArrays")
    public static List<Cell> generateBlankData(int count) {
        ArrayList<Cell> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(new Cell(Color.RED));
        }
        return items;
    }

}
