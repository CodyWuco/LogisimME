package com.gamecodeschool.logicsimulator;

import java.lang.Math;
/*
 * In Wire, the logic for producing a taxicab route is made.
 *
 */
public class Wire {
    private float x0,y0,x1,y1;
    private int strokeWidth;

    public Wire(float x0, float y0, float x1, float y1)
               {this.x0=x0; this.y0=y0; this.x1=x1; this.y1=y1; strokeWidth=1;}

    //------------------INITIAL------------------------\\
    //converts X and Y coordinates into integer for grid
    //layout compatibility

    public float midPointInitialComponentX(float x) {
        return x;
    }
    public float midPointInitialComponentY(float y) {
        return y;
    }
    //---------------FINAL-------------------------\\
    public float midPointFinalComponentX(float x) {
        return x;
    }
    public float midPointFinalComponentY(float y) {
        return y;
    }
    //CAN USE MIDPOINT TO DO (X,NULL), (NULL,Y)
    //---------------MIDPOINT----------------------\\   //can use
    public int midPointX(){
        int x = (int)((midPointInitialComponentX()+midPointFinalComponentX())/2);
        return x;
    }

    public int midPointY(){
        int y = (int)((midPointInitialComponentY()+midPointFinalComponentY())/2);
        return y;
    }
    //------------------------------------------------------\\
    //true midpoint
    public int midPointXY(){
    int x = midPointX()*midPointY();
        return x; //not sure if needed
    }
    //---------------MOVE--------------------------\\
    public float moveEventX(float x) {return x;}
    public float moveEventY(float y) {return y;}
    //---------------HYPOTENUSE--------------------\\
    public int hypotenuseX(){
        //a^2 + b^2 = c^2
        //have values of each X/Y
        int hyp = (int)Math.sqrt((midPointX()*midPointX()));
        return hyp; //change later
    }
    public int hypotenuseY(){
        int hyp = (int)Math.sqrt((midPointY()*midPointY()));
        return hyp;
    }
    public int hypotenuseXY(){
        //a^2 + b^2 = c^2
        //have values of each X/Y
        int hyp = (int)Math.sqrt((midPointXY()*midPointXY()));
        return hyp;
    }
//------------------------------------------------------\\
}
