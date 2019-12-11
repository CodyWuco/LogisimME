package com.gamecodeschool.logicsimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

class BackgroundGraphicsComponent implements GraphicsComponent {

    private Bitmap bitmap;
    private Bitmap bitmap2;

    @Override
    public void initialize(Context c, ObjectSpecific s, PointF objectSize) {
        // Make a resource id out of the string of the file name
        int resID = c.getResources()
                .getIdentifier(s.getBitmapName(),
                        "background",
                        c.getPackageName());

        // Load the bitmap using the id
        bitmap = BitmapFactory.decodeResource(
                c.getResources(), resID);

        // Resize the bitmap
        bitmap = Bitmap.createScaledBitmap(bitmap, (int) objectSize.x,
                (int) objectSize.y, false);

        // Create a mirror image of the bitmap
        Matrix matrix = new Matrix();
        matrix.setScale(-1, 1);
        bitmap2 = Bitmap
                .createBitmap(bitmap,
                        0, 0,
                        bitmap.getWidth(),
                        bitmap.getHeight(),
                        matrix, true);
    }

    @Override
    public void draw(Canvas canvas, Paint paint, Transform t) {

        int xClip = t.getXClip();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int startY = 0;
        int endY = (int) t.getScreenSize().y + 20;

        // For the regular bitmap
        Rect fromRect1 = new Rect(0, 0, width - xClip, height);
        Rect toRect1 = new Rect(xClip, startY, width, endY);

        // For the reversed background/grid
        Rect fromRect2 = new Rect(width - xClip, 0, width, height);
        Rect toRect2 = new Rect(0, startY, xClip, endY);

        //draw the two background bitmaps

        if (!t.getReversedFirst()) {
            canvas.drawBitmap(bitmap, fromRect1, toRect1, paint);
            canvas.drawBitmap(bitmap2, fromRect2, toRect2, paint);
        } else {
            canvas.drawBitmap(bitmap, fromRect2, toRect2, paint);
            canvas.drawBitmap(bitmap2, fromRect1, toRect1, paint);
        }

    }
}
