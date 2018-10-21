package com.konatsup.timelineview;

import android.graphics.Color;

public  class Cell {
    int color;

    Cell(Composition composition) {
        if (composition instanceof  AudioComposition) {
            color = Color.BLUE;
        }else if (composition instanceof  MidiComposition) {
            color = Color.GREEN;
        }
    }

    Cell(int color){
        this.color = color;
    }
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
