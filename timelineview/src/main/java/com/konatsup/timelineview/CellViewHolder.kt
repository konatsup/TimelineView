package com.konatsup.timelineview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class CellViewHolder(itemView: View, private val adapter: CellViewAdapter) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private val cell: LinearLayout
    private val imageView: ImageView
    private val startBar: View
    private val endBar: View

    init {
        itemView.setOnClickListener(this)
        cell = itemView.findViewById<View>(R.id.cell) as LinearLayout
        imageView = itemView.findViewById<View>(R.id.imageView) as ImageView
        startBar = itemView.findViewById(R.id.startBar) as View
        endBar = itemView.findViewById(R.id.endBar) as View
    }

    override fun onClick(v: View) {
        adapter.onItemHolderClick(this)
    }

    fun setCellColor(color: Int) {
        cell.setBackgroundColor(color)
    }

    fun setText(position: Int) {
        (cell.findViewById<View>(R.id.text) as TextView).text = position.toString()
    }

    fun setImage(resId: Int) {
        if (resId == -1) {
            imageView.setImageDrawable(null)
        } else {
            imageView.setImageResource(resId)
        }
    }

    fun setVisibility(isStart: Boolean, isEnd: Boolean) {
        if (isStart) {
            startBar.visibility = View.VISIBLE
        } else {
            startBar.visibility = View.GONE
        }

        if (isEnd) {
            endBar.visibility = View.VISIBLE
        } else {
            endBar.visibility = View.GONE
        }

    }

}