package com.gamecodeschool.logicsimulator;

import java.lang.Math;

public class Wire {
    private int x0,y0,x1,y1,strokeWidth;

    public Wire(int x0, int y0, int x1, int y1) { this.x0=x0; this.y0=y0; this.x1=x1; this.y1=y1;
                                                  strokeWidth=1;}

    public int midPointInitialComponentX(float x) {
        float X;
        X = Math.round(x);
        x0 = (int)X;

        return (int)X;
    }
    public float midPointInitialComponentY(float y) {
        float Y;
        Y = Math.round(y);
        y0 = (int)Y;

        return Y;
    }
    public float midPointFinalComponentX(float x) {
        float X;
        X = Math.round(x);
        x1 = (int)x;

        return X;
    }
    public float midPointFinalComponentY(float y) {
        float Y;
        Y = Math.round(y);
        y1 = (int)Y;

        return Y;
    }
    public int midPointX(){
        int x;
        x = (x0+x1) / 2;
        return x;
    }
    public int midPointY(){
        int y;
        y = (y0+y1) / 2;
        return y;
    }
    //true midpoint
    public int midPointXY(){
        return 0; //not sure if needed
    }

    public float moveEventX(float x) {return x;}
    public float moveEventY(float y) {return y;}

    public int hypotenuse(){
        //empty going back to later. This is to acquire right-angle lines
    }

}
