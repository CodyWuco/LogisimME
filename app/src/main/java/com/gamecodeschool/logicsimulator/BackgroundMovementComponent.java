package com.gamecodeschool.logicsimulator;

public class BackgroundMovementComponent implements MovementComponent {

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
}
