package com.konatsup.timelineview;

public class AudioComposition implements Composition {
    private int duration;

    public AudioComposition(int duration){
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
