package com.konatsup.timelineview;

import android.graphics.Color;

public class Cell {
    private int color;
    private boolean isStart;
    private boolean isEnd;

    Cell(Composition composition) {
        if (composition instanceof AudioComposition) {
            color = Color.BLUE;
        } else if (composition instanceof MidiComposition) {
            color = Color.GREEN;
        }
        isStart = false;
        isEnd = false;
    }

    Cell(int color) {
        this.color = color;
        isStart = false;
        isEnd = false;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
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
