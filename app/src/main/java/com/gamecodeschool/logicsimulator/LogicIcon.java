package com.gamecodeschool.logicsimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//  used in selection to determine action type
abstract class LogicIcon extends AbstractGridCell{
    public LogicIcon(AbstractGridCell myCell)           {super((myCell));}
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class SwitchIcon extends LogicIcon{
    boolean isSelected;
    Context context;

    public SwitchIcon(AbstractGridCell myCell)          {super((myCell)); isSelected = false;}

    public void drawGrid(Canvas canvas, Paint paint) {
        super.drawGrid(canvas,paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "Switch", "");
        //switchImage(canvas);
    }
    void switchImage(Canvas canvas) {
        //ImageView imageView = new ImageView(context);
        Bitmap bit1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.switchbutton);
        //ImageView iv = (ImageView)findViewById(R.id.image_view);

        //Bitmap bitmap = Bitmap.createBitmap(bit1.getWidth(), bit1.getHeight(), Bitmap.Config.RGB_565);

        //canvas = new Canvas(bitmap);
        canvas.drawBitmap(bit1,0,0 , null);
        //imageView.setImageBitmap(bitmap); //L
    }
    public AbstractGridCell changeCellType(AbstractGridCell myCell) {return new SwitchNode(myCell);}
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class AndIcon extends LogicIcon{
    public AndIcon(AbstractGridCell myCell)             {super((myCell));}
    public void drawGrid(Canvas canvas, Paint paint) {
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "AND", "GATE");
    }
    public AbstractGridCell changeCellType(AbstractGridCell myCell) {return new AndNode(myCell);}
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class OrIcon extends LogicIcon{
    public OrIcon(AbstractGridCell myCell)              {super((myCell));}
    public void drawGrid(Canvas canvas, Paint paint){
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "OR", "GATE");
    }
    public AbstractGridCell changeCellType(AbstractGridCell myCell) {return new OrNode(myCell);}
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class NotIcon extends LogicIcon{
    public NotIcon(AbstractGridCell myCell)             {super((myCell));}
    public void drawGrid(Canvas canvas, Paint paint){
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "NOT", "GATE");
    }
    public AbstractGridCell changeCellType(AbstractGridCell myCell) {return new NotNode(myCell);}
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class LightIcon extends LogicIcon{
    public LightIcon(AbstractGridCell myCell)           {super((myCell));}
    public void drawGrid(Canvas canvas, Paint paint){
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "Light", "");
    }
    public AbstractGridCell changeCellType(AbstractGridCell myCell) {return new LightNode(myCell);}
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class DeleteIcon extends AbstractGridCell{
    public DeleteIcon(AbstractGridCell myCell)           {super(((myCell)));}
    public void drawGrid(Canvas canvas, Paint paint){
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "Delete", "");
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class WireSourceIcon extends AbstractGridCell{
    public WireSourceIcon(AbstractGridCell myCell)           {super(((myCell)));}
    public void drawGrid(Canvas canvas, Paint paint){
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "Wire", "Source");
    }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class WireInputIcon extends AbstractGridCell{
    public WireInputIcon(AbstractGridCell myCell)           {super(((myCell)));}
    public void drawGrid(Canvas canvas, Paint paint){
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "Wire", "Input");
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class ClearInputIcon extends AbstractGridCell{
    public ClearInputIcon(AbstractGridCell myCell)           {super(((myCell)));}
    public void drawGrid(Canvas canvas, Paint paint){
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "Clear", "Input");
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class CreateSaveIcon extends AbstractGridCell{
    public CreateSaveIcon(AbstractGridCell myCell)           {super(((myCell)));}
    public void drawGrid(Canvas canvas, Paint paint){
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "Create", "Save");
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class SavesIcon extends AbstractGridCell{
    String save;
    public SavesIcon(AbstractGridCell myCell)                {super(((myCell)));}
    public SavesIcon(AbstractGridCell myCell, String save)   {super(((myCell)));
        this.save = save;}
    public void drawGrid(Canvas canvas, Paint paint){
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "Save", save);
    }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class ClearScreenIcon extends AbstractGridCell{
    public ClearScreenIcon(AbstractGridCell myCell)          {super(((myCell)));}
    public void drawGrid(Canvas canvas, Paint paint){
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "Clear", "Screen");
    }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class OffsetIcon extends AbstractGridCell{
    public OffsetIcon(AbstractGridCell myCell)               {super(((myCell)));}
}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class OffsetRightIcon extends OffsetIcon {
    public OffsetRightIcon(AbstractGridCell myCell)          {super(((myCell)));}
    public void drawGrid(Canvas canvas, Paint paint) {
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "-->", "Right");
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class OffsetLeftIcon extends OffsetIcon {
    public OffsetLeftIcon(AbstractGridCell myCell)          {super(((myCell)));}
    public void drawGrid(Canvas canvas, Paint paint) {
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "<--", "Left");
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class OffsetUpIcon extends OffsetIcon {
    public OffsetUpIcon(AbstractGridCell myCell)          {super(((myCell)));}
    public void drawGrid(Canvas canvas, Paint paint) {
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "^", "Up");
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class OffsetDownIcon extends OffsetIcon {
    public OffsetDownIcon(AbstractGridCell myCell)          {super(((myCell)));}
    public void drawGrid(Canvas canvas, Paint paint) {
        super.drawGrid(canvas, paint, Color.DKGRAY);
        paint.setColor(Color.GREEN);
        drawText(canvas, paint, "V", "Down");
    }
}