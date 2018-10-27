# TimelineView

![Imgur](https://i.imgur.com/q1l5czv.gif)

## OverView
TimelineView is view of timeline.
You can swipe and scroll view.

This library is developed for creating music or movie edit App on Android. 

## Usage
### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```
allprojects {
   repositories {
        ...
   	    maven { url 'https://jitpack.io' }
   }
}
```
if you have some error, add this in same build.gradle:
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
        implementation 'com.github.konatsup:timelineview:v0.3'
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

*.kt: 
```kotlin

val tv : TimelineView = findViewById(R.id.timelineView)
        tv.timelineType = TimelineType.TIME
        tv.trackList = ArrayList()
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

## LICENSE
```
MIT License

Copyright (c) 2018 konatsup

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
