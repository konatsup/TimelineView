package com.konatsup.timelineview


import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView

import java.util.ArrayList
import java.util.Collections

class CellViewAdapter : RecyclerView.Adapter<CellViewHolder>() {

    private var cellList: ArrayList<Cell> = ArrayList()

    private var onItemClickListener: AdapterView.OnItemClickListener? = null

    fun addItemCount(count: Int) {
        cellList.addAll(generateBlankData(count))

        notifyDataSetChanged()
    }

    fun update(trackList: List<Track>, columnCount: Int) {
        cellList = ArrayList(Collections.nCopies(columnCount * trackList.size, Cell(Color.DKGRAY)))
        for (i in trackList.indices) {
            trackList[i].compositionMap.forEach {
                val startPosition = i * columnCount
                val position = it.key
                val composition = it.value
                for (j in 0 until composition.duration) {
                    val cell = Cell(composition)
                    if (j == 0) cell.isStart = true
                    if (j == composition.duration - 1) cell.isEnd = true
                    cellList[startPosition + position + j] = cell
                }
            }
        }
        notifyDataSetChanged()
    }

    fun addItem(position: Int) {
        if (position > cellList.size) return
        notifyItemInserted(cellList.size)
    }

    /*
     * Inserting a new item at the head of the list. This uses a specialized
     * RecyclerView method, notifyItemRemoved(), to trigger any enabled item
     * animations in addition to updating the view.
     */
    fun removeItem(position: Int) {
        if (position >= cellList.size) return

        cellList.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): CellViewHolder {
        val inflater = LayoutInflater.from(container.context)
        val root = inflater.inflate(R.layout.cell, container, false)

        return CellViewHolder(root, this)
    }

    override fun onBindViewHolder(itemHolder: CellViewHolder, position: Int) {
        val item = cellList[position]
        itemHolder.setCellColor(item.color)
        itemHolder.setImage(item.resId)
        itemHolder.setVisibility(item.isStart, item.isEnd)
    }

    override fun getItemCount(): Int {
        return cellList.size
    }

    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener) {
        onItemClickListener = listener
    }

    fun onItemHolderClick(itemHolder: CellViewHolder) {
        onItemClickListener?.onItemClick(null, itemHolder.itemView,
                itemHolder.adapterPosition, itemHolder.itemId)
    }

    companion object {

        @SuppressLint("UseSparseArrays")
        fun generateBlankData(count: Int): List<Cell> {
            val items = ArrayList<Cell>()
            for (i in 0 until count) {
                items.add(Cell(Color.RED))
            }
            return items
        }
    }

}
