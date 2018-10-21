package com.konatsup.timelineview;

public class MidiComposition implements Composition {
    private int duration;

    public MidiComposition(int duration){
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

}