package com.konatsup.timelineview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.MotionEvent
import android.view.ViewGroup

class PositionBarView : View {

    var weight: Float = 10f
    var position: Int = 0
        set(value) {
            field = value
            mlp.leftMargin = value
            layoutParams = mlp
        }

    private var listener: View.OnClickListener? = null
    private val mlp by lazy {
        layoutParams as ViewGroup.MarginLayoutParams
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {}

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        layoutParams.width = weight.toInt()
    }

    override fun setOnClickListener(l: View.OnClickListener?) {
        this.listener = l
    }

    /* call back touch event */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (listener != null) {
            post { listener!!.onClick(this) }

        }
        return super.dispatchTouchEvent(ev)
    }
}

