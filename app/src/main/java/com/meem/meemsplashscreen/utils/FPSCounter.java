package com.meem.meemsplashscreen.utils;

import android.util.Log;

/**
 * Created by scs on 7/28/2015.
 */
public class FPSCounter {

    long startTime = System.nanoTime();
    int frames = 0;

    public int logFrame() {
        frames++;
        if(System.nanoTime() - startTime >= 1000000000) {
            Log.d("FPSCounter", "fps: " + frames);
            frames = 0;
            startTime = System.nanoTime();
        }
        return frames;
    }
}
