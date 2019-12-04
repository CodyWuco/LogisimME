package com.gamecodeschool.logicsimulator;

import android.graphics.PointF;

public class ObjectSpecific {
    private String tag;
    private String bitmapName;
    private float speed; //won't need it
    private PointF sizeScale;
    private String[] components;

    ObjectSpecific(String tag, String bitmapName, PointF relativeScale,
                   String[] components) {
        this.tag = tag;
        this.bitmapName = bitmapName;
        this.sizeScale = relativeScale;
        this.components = components;
    }

    String getTag() {
        return tag;
    }

    String getBitmapName() {
        return bitmapName;
    }

    PointF getSizeScale() {
        return sizeScale;
    }

    String[] getComponents() {
        return components;
    }

}
