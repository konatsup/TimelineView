package com.konatsup.timelineview;

import android.graphics.Color;

public class Cell {
    private int color;
    private int resId;
    private boolean isStart;
    private boolean isEnd;

    Cell(Composition composition) {
        if (composition instanceof AudioComposition) {
            color = Color.BLUE;
            resId  = R.drawable.audio_image_sample;
        } else if (composition instanceof MidiComposition) {
            color = Color.GREEN;
            resId = R.drawable.midi_image_sample;
        }
        isStart = false;
        isEnd = false;
    }

    Cell(int color) {
        this.color = color;
        resId = -1;
        isStart = false;
        isEnd = false;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
