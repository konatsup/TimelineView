package com.konatsup.timelineview

import java.util.ArrayList

class Track(var compositionMap: MutableMap<Int, Composition>) {

    /* functions */
    val compositionList: ArrayList<Composition>
        get() = this.compositionMap.values as ArrayList<Composition>

    fun createComposition(pos: Int) {
        // TODO: select default composition
        val composition = AudioComposition(0)
        this.compositionMap[pos] = composition
    }

    fun addComposition(position: Int, composition: Composition) {
        this.compositionMap[position] = composition
    }

}
