package com.gamecodeschool.logicsimulator;

import java.lang.Math;

public class Wire {
    private int x0,y0,x1,y1,strokeWidth;

    public Wire(int x0, int y0, int x1, int y1) { this.x0=x0; this.y0=y0; this.x1=x1; this.y1=y1;
                                                  strokeWidth=1;}

    public float midPointInitialComponentX(float x) {
        float X;
        X = Math.round(x);

        return X;
    }
    public float midPointInitialComponentY(float y) {
        float Y;
        Y = Math.round(y);

        return Y;
    }
    public float midPointFinalComponentX(float x) {
        float X;
        X = Math.round(x);

        return X;
    }
    public float midPointFinalComponentY(float y) {
        float Y;
        Y = Math.round(y);

        return Y;
    }
    public int midPointX(){}
    public int midPointY(){}

    public float moveEventX(float x) {return x;}
    public float moveEventY(float y) {return y;}

}
