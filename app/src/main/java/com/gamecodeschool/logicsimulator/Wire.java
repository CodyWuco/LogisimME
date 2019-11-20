package com.gamecodeschool.logicsimulator;

import java.lang.Math;
/*
 * In Wire, the logic for producing a taxicab route is made.
 *
 */
public class Wire {
    private int x0,y0,x1,y1,strokeWidth;

    public Wire(int x0, int y0, int x1, int y1) { this.x0=x0; this.y0=y0; this.x1=x1; this.y1=y1;
                                                  strokeWidth=1;}
//------------------INITIAL------------------------\\
    public int midPointInitialComponentX(float x) {
        float X;
        X = Math.round(x);
        x0 = (int)X;

        return x0;
    }

    public float midPointInitialComponentY(float y) {
        float Y;
        Y = Math.round(y);
        y0 = (int)Y;

        return y0;
    }
    //---------------FINAL-------------------------\\
    public float midPointFinalComponentX(float x) {
        float X;
        X = Math.round(x);
        x1 = (int)x;

        return x1;
    }

    public float midPointFinalComponentY(float y) {
        float Y;
        Y = Math.round(y);
        y1 = (int)Y;

        return y1;
    }
    //CAN USE MIDPOINT TO DO (X,NULL), (NULL,Y)
    //---------------MIDPOINT----------------------\\   //can use
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
    //------------------------------------------------------\\
    //true midpoint
    public int midPointXY(){

        return 0; //not sure if needed
    }
    //---------------MOVE--------------------------\\
    public float moveEventX(float x) {return x;}
    public float moveEventY(float y) {return y;}
    //---------------HYPOTENUSE--------------------\\
    public int hypotenuse(){
        //a^2 + b^2 = c^2
        //have values of each X/Y

        return 0; //change later
    }
//------------------------------------------------------\\
}
