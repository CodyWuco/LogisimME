package com.gamecodeschool.logicsimulator;

public class BackgroundMovementComponent implements MovementComponent {

    Grid grid1;
    AbstractGridCell ag;

    @Override
    public boolean move(long fps, Transform t){

        int currentXClip = t.getXClip();

        if (currentXClip >= t.getScreenSize ().x) {
            t.setXClip(0);
            t.flipReversedFirst(); }

        else if (currentXClip <= 0) {
            t.setXClip((int)t.getScreenSize().x);
            t.flipReversedFirst();
        }

        return true;

    }

    public void spawn(Transform t) {
        // Place the background in the top left corner
         t.setLocation(0f,0f); }
}
