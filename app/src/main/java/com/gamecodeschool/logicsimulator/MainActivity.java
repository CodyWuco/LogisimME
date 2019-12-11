//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// This code was created by modifying Doctor Posnett's SubHunter code                             //
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//


package com.gamecodeschool.logicsimulator;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.widget.ImageView;


/*
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class ClickEvent{
    public AbstractGridCell selected, previousSelection;

    public ClickEvent(ClickEvent clickEvent, AbstractGridCell clicked){
        determineEventType(clicked);
        previousSelection = clickEvent.selected;
    }

    public ClickEvent(){
        InitializeSelections();
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public void InitializeSelections(){
        selected = null;
        previousSelection = null;
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public void determineEventType(AbstractGridCell clicked){
        if(clicked instanceof EmptyGridCell){
            clicked.
        }else if(clicked instanceof LogicIcon){
            setSelected(clicked);
        }
        //instandof
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public void setSelected(AbstractGridCell clicked){
        if(selected != clicked) {
            selected = clicked;
        } else{ selected = clicked; }
    }
}

 */

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class MainActivity extends Activity {
    LogicSimulator game;
    Wire wire;
    WireMath wiremath;
    Display display;
    Point size;

    //private static int SPLASH_TIME_OUT = 3000;


    /*//@Override
    protected void onCreate1(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); }*/

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BackgroundGraphicsComponent bs;
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        game = new bs;//LogicSimulator(this, size);
        setContentView(game.gameView);
    }*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        getScreenRes();
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.rocky);
        mediaPlayer.start();

        game = new LogicSimulator(this, size);
        setContentView(game.gameView);

        //game.Load("Quick Save");
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent homeIntent = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);*/

    }

    // Get the current device's screen resolution
    void getScreenRes(){
        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
    }

    public boolean onTouchEvent(MotionEvent motionEvent){
        if((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
            //wiremath.midPointInitialComponentX();
            //wiremath.midPointInitialComponentY();
        }
        if((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_MOVE) {
            //wiremath.moveEventX();
            //wiremath.moveEventY();
        }
        if((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
            game.touchGrid(motionEvent.getX(), motionEvent.getY());
            //wiremath.midPointFinalComponentX();
            //wiremath.midPointFinalComponentY();
        }
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        game.Save("Quick Save");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        game.Load("Quick Save");
    }

}
