package com.gamecodeschool.logicsimulator;


import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

import static android.content.Context.MODE_PRIVATE;

public class NestedCircuitLogic {
    Context context;
    // head is used to find the output and to keep track of the starting point of the circuit
    LogicNode head;
    // this list is used to save and load the tree without excessive logic
    List<LightNode> tree;
    // this vector is used to keep track of the open input slots
    Vector<AbstractGridCell> inputs;

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This takes in a save name and loads the correct circuit
    public NestedCircuitLogic(String saveName) {
        loadLogicCircuit(saveName);
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This creates a copy of a circuits logic. Then is removes the switches and LED nodes, and
    // creates a vector of the avaibable inputs.
    private void createCopyFromCircuitHead(LogicNode oldHead) {

    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This save the circuit to a file using a string
    // function that saves tree to a file as a List. This will work since the Logic nodes keep
    // track of their own tree.
    private void saveLogicCurcuit(Context context, Vector Cells, String fileName) {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Cells);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This loads a previously saved CircuitTree and sets head to the head of the tree
    public void loadLogicCircuit(String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            inputs = (Vector<AbstractGridCell>) ois.readObject();
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
    // create a function to keep track of the the tree on loads

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // Starts the eval of the logic tree
    public boolean eval() {
        return head.eval();
    }
}

