# TimelineView

![Imgur](https://i.imgur.com/q1l5czv.gif)

## OverView
TimelineView is view of timeline.
You can swipe and scroll view.

This library is developed for creating music or movie edit App on Android. 

## Usage
### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```.gradle
allprojects {
   		repositories {
   			...
   			maven { url 'https://jitpack.io' }
   		}
}
```
if you have some error, add this build.gradle:
```
buildscript {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```


### Step 2. Add the dependency
```kotlin
dependencies {
        implementation 'com.github.konatsup:timelineview:-SNAPSHOT'
}
```

DONE!


### Step 3. Use the library


*.xml: 
```xml
<com.konatsup.timelineview.TimelineView
        android:id="@+id/timelineView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
     
```

*kt: 
```kotlin

val tv : TimelineView = findViewById(R.id.timelineView)
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
