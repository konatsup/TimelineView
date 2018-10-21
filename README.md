# TimelineView
<img src="https://github.com/Konatsup/TimelineView/blob/master/arts/screenshot.png" alt="alt text" style="width:200;height:200">

## OverView
TimelineView is view of timeline.
You can swipe and scroll view.

This library is developed for creating music or movie edit App on Android. 

## Usage

```xml
<com.konatsup.timelineview.TimelineView
        android:id="@+id/timelineView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
     
```

```kotlin

val tv = findViewById(R.id.timelineView)
        tv.timelineType = TimelineType.TIME
        tv.trackList = ArrayList<Track>()
        tv.currentPosition = 0
        tv.columnCount = 30
        
        
    val map1 = HashMap<Int, Composition>()
    val track1 = Track(map1)
    
    val comp1 = AudioComposition(3)
    val comp2 = MidiComposition(5)
    track1.addComposition(3, comp1)
    track1.addComposition(7, comp2)     
    
    tv.addTrack(track1) 
                      
```
