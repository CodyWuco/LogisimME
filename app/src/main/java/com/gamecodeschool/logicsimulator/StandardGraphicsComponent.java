package com.gamecodeschool.logicsimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;

class StandardGraphicsComponent implements GraphicsComponent {

    private Bitmap bitmap;

    @Override
    public void initialize(Context context, ObjectSpecific spec, PointF objectSize) {
        // Make a resource id out of the string of the file name
        /*int resID = context.getResources()
                .getIdentifier(spec.getBitmapName(),
                        "drawable",
                        context.getPackageName());

        // Load the bitmap using the id
        bitmap = BitmapFactory.decodeResource(
                context.getResources(), resID);*/

        // Resize the bitmap
        bitmap = Bitmap
                .createScaledBitmap(bitmap, (int)objectSize.x,
                        (int)objectSize.y, false);

    }


    @Override
    public void draw(Canvas canvas, Paint paint, Transform t) {
            canvas.drawBitmap(bitmap, t.getScreenSize().x,
                    t.getScreenSize().y, paint);
    }
}
