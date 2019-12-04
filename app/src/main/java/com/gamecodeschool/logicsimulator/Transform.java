package com.gamecodeschool.logicsimulator;

import android.graphics.PointF;

class Transform {
    // for scrolling background
    private int mXClip;
    private boolean mReversedFirst = false;

    private PointF location;
    private static PointF screenSize;

    Transform(PointF startingLocation, PointF screenSize) {
        location = startingLocation;
        this.screenSize = screenSize;
    }
}

