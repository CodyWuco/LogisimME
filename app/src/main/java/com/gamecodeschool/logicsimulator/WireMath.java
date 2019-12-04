package com.gamecodeschool.logicsimulator;

import java.lang.Math;

public class WireMath {

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
        int x = -1;//(int)((midPointInitialComponentX()+midPointFinalComponentX())/2);
        return x;
    }

    public int midPointY(){
        int y = -1;//(int)((midPointInitialComponentY()+midPointFinalComponentY())/2);
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
