package com.gamecodeschool.logicsimulator;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// AbstractGridCell represents a single grid cell in the Logic Simulator. It is the bass class for
// each of the different stat classes that each grid cell can represent.
//

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

import static android.content.Context.MODE_PRIVATE;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
class Grid implements Serializable {
    int gridWidth, gridHeight, blockSize;
    int xOffset, yOffset;
    Random rand;
    int gridSize;
    AbstractGridCell selected, previousSelection, wireSource;
    Context context;
    AbstractGridCellSaves saves;

    private class GridPosition{
        int x,y;
        public GridPosition(int x, int y)               {this.x=x; this.y=y;}
    }


    public Vector<AbstractGridCell> gridCells;
    public Vector<AbstractGridCell> hudCells;

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public Grid(int x, int y, Context context){
        // Forcing context to be set, so there aren't any errors in context related functions, like
        // saving and loading
        setContext(context);

        saves = new AbstractGridCellSaves();

        if (x > y){ gridSize = 6; }
        else { gridSize = 10; }

        blockSize = y / gridSize;
        gridWidth =  10;
        gridHeight = 10;
        xOffset = 0;
        yOffset = 0;
        rand = new Random();
        selected = null;
        previousSelection = null;
        wireSource = null;
        reset();
        setUpHud();
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public void reset(){
        hudCells = new Vector<>(10*10); // set all to null to force hud touch priority to work
        hudCells.clear();
        for(int h=0; h<gridWidth*gridHeight; h++)
            for(int v=0; v<gridHeight; v++)
                hudCells.add((new NullGridCell(h*blockSize,v*blockSize, blockSize,
                        blockSize)));

        gridCells = new Vector<>(10*10);
        for(int h=0; h<gridWidth*gridHeight; h++)
            for(int v=0; v<gridHeight; v++)
                gridCells.add((new EmptyGridCell(h*blockSize,v*blockSize, blockSize,
                        blockSize)));


        setUpHud();//remove this. this is only needed if the hud is on the grid
    }


    public void setContext(Context context){this.context = context;}

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // Save and Load need to be separated into a saves class to be reused in Nested circuit
    public void Save(String fileName) {
        saves.Save(context, gridCells, fileName);
    }

    public void Load(String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            gridCells = (Vector<AbstractGridCell>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````

    public void setUpHud(){
        Log.i("hud", "BlockSize: " + blockSize);
        int row = 0, column = 0;
        addIconToHud(new SwitchIcon(new EmptyGridCell(0 * blockSize,0 * blockSize,blockSize, blockSize)),row,column);
        row = 1; column = 0;
        addIconToHud(new AndIcon(gridCells.get(iconLocation(row,column))),row,column);
        row = 2 ; column = 0;
        addIconToHud(new OrIcon(gridCells.get(iconLocation(row,column))),row,column);
        row = 3 ; column = 0;
        addIconToHud(new NotIcon(gridCells.get(iconLocation(row,column))),row,column);
        row = 4 ; column = 0;
        addIconToHud(new LightIcon(gridCells.get(iconLocation(row,column))),row,column);
        row = 5 ; column = 0;
        addIconToHud(new DeleteIcon(gridCells.get(iconLocation(row,column))),row,column);
        row = 0 ; column = 1;
        addIconToHud(new WireSourceIcon(gridCells.get(iconLocation(row,column))),row,column);
        row = 1 ; column = 1;
        addIconToHud(new WireInputIcon(gridCells.get(iconLocation(row,column))),row,column);
        row = 2 ; column = 1;
        addIconToHud(new ClearInputIcon(gridCells.get(iconLocation(row,column))),row,column);
        row = 3 ; column = 1;
        addIconToHud(new ClearScreenIcon(gridCells.get(iconLocation(row,column))),row,column);
        row = 4 ; column = 1;
        addIconToHud(new CreateSaveIcon(gridCells.get(iconLocation(row,column))),row,column);
        row = 0 ; column = 2;
        addIconToHud(new SavesIcon(gridCells.get(iconLocation(row,column)), "A"),row,column);
        row = 1 ; column = 2;
        addIconToHud(new SavesIcon(gridCells.get(iconLocation(row,column)), "B"),row,column);
        row = 2 ; column = 2;
        addIconToHud(new SavesIcon(gridCells.get(iconLocation(row,column)), "C"),row,column);
        row = 3 ; column = 2;
        addIconToHud(new SavesIcon(gridCells.get(iconLocation(row,column)), "D"),row,column);
        row = 4 ; column = 2;
        addIconToHud(new SavesIcon(gridCells.get(iconLocation(row,column)), "E"),row,column);
        row = 5 ; column = 2;
        addIconToHud(new SavesIcon(gridCells.get(iconLocation(row,column)), "F"),row,column);
    }

    public void addIconToHud(AbstractGridCell Icon, int row, int column){
        //hudCells.add(iconLocation(row,column), Icon); // used to take hud off of the grid
        gridCells.set(iconLocation(row,column), Icon); //remove this. it puts the hud on the grid
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public int gridColumn(int column)            { return 10 * (column );}

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public int gridRow(int row)                  { return (row);}

    // gives the grid vector number
    public int iconLocation(int row, int column){return gridRow(row) + gridColumn(column);}

    //``````````````````````````````````````````````````````````````````````````````````````````````
    private int gridCellN(GridPosition p){return (gridHeight*p.x+p.y);}

    //``````````````````````````````````````````````````````````````````````````````````````````````
    private int distanceToClosestFrom(GridPosition shotP, Vector<AbstractGridCell> cells){
        int subD=gridWidth*gridHeight;

        for(int i=0; i < cells.size(); i++){
            AbstractGridCell agc = cells.get(1);
            if(agc instanceof LogicNode){
                // set subD to existing min, or distance from agc to shotP
            }
        }
        return subD;
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public int touchGrid(float touchX, float touchY){
        // reserves 3 grid blocks worth of space on the left for Ui logic
        int reservedUISpace = 3 * blockSize;

        // this "if" checks if the click was a block size away from the edge of the screen
        // this is done to get screen space to the hud layout
        GridPosition tP = getGridTouchPosition(touchX, touchY);
        int currGridNum = gridCellN(tP);

        // checks if the hud has a button in that location before choosing which grid to proceed with
        if ( hudCells.get(currGridNum) instanceof NullGridCell) {
            AbstractGridCell clickedCell = onClick(currGridNum, gridCells);
            CellClickEvent(clickedCell, currGridNum);
            return distanceToClosestFrom(tP, gridCells);
        }
        // this is the hud layout logic
        else {
            AbstractGridCell clickedCell = onClick(currGridNum, hudCells);
            CellClickEvent(clickedCell, currGridNum);
            return distanceToClosestFrom(tP, hudCells);
        }
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public GridPosition getGridTouchPosition(float touchX, float touchY){
        GridPosition tp = new GridPosition(((int)touchX + xOffset)/ blockSize,
                ((int)touchY + yOffset)/ blockSize);
        return tp;
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public AbstractGridCell onClick(int cellNumber, Vector<AbstractGridCell> cells){
        return cells.get(cellNumber);
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public void CellClickEvent(AbstractGridCell clickedCell, int currGridNum){
        if (isEmptyCell(clickedCell)){ doEmptyCellEvent(clickedCell, currGridNum); }
        else if (isLogicNode(clickedCell)){ doLogicNodeEvent(clickedCell, currGridNum);}
        else if (isSavesIcon(clickedCell)){ doSavesIconEvent(clickedCell, currGridNum);}
        else if (isClearScreenIconEvent(clickedCell)){doClearIconEvent(clickedCell, currGridNum);}
        else{ doSelectEvent(clickedCell);}
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean isEmptyCell(AbstractGridCell cell){ return (cell instanceof EmptyGridCell); }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public void doEmptyCellEvent(AbstractGridCell clickedCell, int currGridNum){
        if(isLogicIcon(selected)){gridCells.set(currGridNum, selected.changeCellType(clickedCell));}
        else { gridCells.set(currGridNum, clickedCell.selectObject()); }

        doSelectEvent(clickedCell);
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public void doLogicNodeEvent(AbstractGridCell clickedCell, int currGridNum){
        if(isDeleteIcon(selected)){ gridCells.set(currGridNum, clickedCell.clearShot()); }
        else if(isWireInputIcon(selected)){
            LogicNode tempNode = (LogicNode) clickedCell;
            tempNode.setInput((LogicNode) wireSource);
            gridCells.set(currGridNum, tempNode);
        }
        else if(isWireSourceIcon(selected)){
            wireSource = clickedCell; }
        else if(isSwitch(clickedCell)){ clickedCell.selectObject();}
        else if(isClearInputIcon(selected)){
            LogicNode tempNode = (LogicNode) clickedCell;
            tempNode.clearInput();
            gridCells.set(currGridNum, tempNode);
            Log.d("Wire Source", "source");
        }

        previousSelection = selected;
        selected = null;
    }

    public void doSavesIconEvent(AbstractGridCell clickedCell, int currGridNum){
        if (isCreateSaveIcon(selected)){
            SavesIcon currSave = (SavesIcon)clickedCell;
            Save("save" + currSave.save);
        }else {
            SavesIcon currSave = (SavesIcon)clickedCell;
            Load("save" + currSave.save);
        }
        previousSelection = selected;
        selected = null;
    }

    public void doClearIconEvent(AbstractGridCell clickedCell, int currGridNum) {
        if(previousSelection instanceof ClearScreenIcon)
        { reset();  previousSelection = null; }
        else { previousSelection = clickedCell;}
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public void doSelectEvent(AbstractGridCell clickedCell){ selected = clickedCell; }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean isLogicIcon(AbstractGridCell cell){ return (cell instanceof LogicIcon); }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean isDeleteIcon(AbstractGridCell cell){ return (cell instanceof DeleteIcon); }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean isLogicNode(AbstractGridCell cell)     {return (cell instanceof LogicNode);}

    public boolean isWireInputIcon(AbstractGridCell cell) {return (cell instanceof WireInputIcon);}

    public boolean isWireSourceIcon(AbstractGridCell cell){return (cell instanceof WireSourceIcon);}

    public boolean isSwitch(AbstractGridCell cell)        {return (cell instanceof SwitchNode);}

    public boolean isClearInputIcon(AbstractGridCell cell){return (cell instanceof ClearInputIcon);}

    public boolean isSavesIcon(AbstractGridCell cell)     {return (cell instanceof SavesIcon);}

    public boolean isCreateSaveIcon(AbstractGridCell cell){return (cell instanceof CreateSaveIcon);}

    public boolean isClearScreenIconEvent(AbstractGridCell cell){return (cell instanceof ClearScreenIcon);}

    //``````````````````````````````````````````````````````````````````````````````````````````````
    public void drawGrid(Canvas canvas, Paint paint){
        for(AbstractGridCell agc:gridCells) {
            agc.drawGrid(canvas, paint);
        }
        drawHud(canvas, paint);
    }
    public void drawHud(Canvas canvas, Paint paint){
        for(AbstractGridCell agc:hudCells) {
            agc.drawGrid(canvas, paint);
        }
    }

}
