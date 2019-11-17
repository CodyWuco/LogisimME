package com.gamecodeschool.logicsimulator;


import java.util.List;
import java.util.Vector;

public class NestedCircuitLogic {
    // head is used to find the output and to keep track of the starting point of the circuit
    LogicNode head;
    // this list is used to save and load the tree without excessive logic
    List<LightNode> tree;
    // this vector is used to keep track of the open input slots
    Vector<LogicNode> inputs;

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This takes in a save name and loads the correct circuit
    public NestedCircuitLogic(String saveName){
        loadLogicCircuit(saveName);
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This save the circuit to a file using a string
    // function that saves tree to a file as a List. This will work since the Logic nodes keep
    // track of their own tree.
    private void saveLogicCurcuit(String saveName){}

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This loads a previously saved CircuitTree and sets head to the head of the tree
    public void loadLogicCircuit(String saveName){}
    // create a function to keep track of the the tree on loads

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // Starts the eval of the logic tree
    public boolean eval(){ return head.eval();}

}
