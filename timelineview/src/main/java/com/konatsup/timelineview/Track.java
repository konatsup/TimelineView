package com.konatsup.timelineview;

import java.util.ArrayList;
import java.util.Map;

public class Track {
    private Map<Integer, Composition> compositionMap;

    /* constructor */
    public Track(Map<Integer, Composition> compositionMap){
        this.compositionMap = compositionMap;
    }

    /* getter and setter */
    public Map<Integer, Composition> getCompositionMap() {
        return compositionMap;
    }

    public void setCompositionMap(Map<Integer, Composition> compositionMap) {
        this.compositionMap = compositionMap;
    }

    /* functions */
    public ArrayList<Composition> getCompositionList() {
        return  (ArrayList<Composition>) this.compositionMap.values();
    }

    public void createComposition(int pos) {
        // TODO: select default composition
         Composition composition = new AudioComposition(0);
         this.compositionMap.put(pos, composition);
    }

    public void addComposition(int position, Composition composition) {
        this.compositionMap.put(position, composition);
    }

}
