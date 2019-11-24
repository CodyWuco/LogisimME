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

        int midx = midPointX();
        int midy = midPointY();
    //------------------INITIAL------------------------\\
    //converts X and Y coordinates into integer for grid
    //layout compatibility

    public int midPointInitialComponentX() {
        int x0 = (int)this.x0;
        return x0;
    }
    public int midPointInitialComponentY() {
        int y0 = (int)this.y0;
        return y0;
    }
    //---------------FINAL-------------------------\\
    public int midPointFinalComponentX() {
        int x1 = (int)this.x1;
        return x1;
    }
    public int midPointFinalComponentY() {
        int y1 = (int)this.y1;
        return y1;
    }
    //CAN USE MIDPOINT TO DO (X,NULL), (NULL,Y)
    //---------------MIDPOINT----------------------\\   //can use
    public int midPointX(){
        int x = ((midPointInitialComponentX()+midPointFinalComponentX())/2);
        return x;
    }

    public int midPointY(){
        int y = ((midPointInitialComponentY()+midPointFinalComponentY())/2);
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
    public int hypotenuse(int hyp){
        //a^2 + b^2 = c^2
        //have values of each X/Y

        return 0; //change later
    }
//------------------------------------------------------\\
}
