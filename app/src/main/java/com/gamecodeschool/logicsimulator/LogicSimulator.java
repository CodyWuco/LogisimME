package com.gamecodeschool.logicsimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.widget.ImageView;

class LogicSimulator{
    // Here are all the objects(instances)
    // of classes that we need to do some drawing
    ImageView gameView;
    private Bitmap blankBitmap,blankBitmap2;
    private Canvas canvas, canvas2;
    private Paint paint;
    private Grid grid;
    private Context context;
    Point size;

    public LogicSimulator(Context context, Point size){
        this.context = context;
        this.size = size;

        initCanvas(this.context, this.size);
        initGrid(size);
        newGame();
        draw();
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    void initCanvas(Context context, Point size){
        // Initialize all the objects ready for drawing
        blankBitmap = Bitmap.createBitmap(size.x, size.y, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(blankBitmap);
        paint = new Paint();
        gameView = new ImageView(context);
        blankBitmap2 = Bitmap.createBitmap(size.x,size.y,Bitmap.Config.ARGB_8888);
        canvas2 = new Canvas(blankBitmap2);
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    void initGrid(Point size){grid = new Grid(size.x, size.y, this.context);}

    //``````````````````````````````````````````````````````````````````````````````````````````````
    void newGame(){
        draw();
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    void draw(){
        gameView.setImageBitmap(blankBitmap);
        //ImageView imageView = new ImageView(context);
        grid.drawGrid(canvas, paint);//,gameView);
        //gameView.setImageBitmap(blankBitmap2);
        //grid.drawGrid(canvas2, paint);

    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    void touchGrid(float touchX, float touchY){
        grid.touchGrid(touchX, touchY);
        draw();
    }

    void Save(String fileName)              { grid.Save(fileName);}
    void Load(String fileName)              { grid.Load(fileName); draw();}
}
