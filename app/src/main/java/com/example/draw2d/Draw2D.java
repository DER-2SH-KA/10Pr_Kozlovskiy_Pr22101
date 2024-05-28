package com.example.draw2d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.view.View;

public class Draw2D extends View
{
    private Paint paint = new Paint();
    private Rect rect = new Rect();
    private Bitmap bitmap;

    public Draw2D(Context context)
    {
        super(context);

        Resources res = this.getResources();
        bitmap = BitmapFactory.decodeResource(res, R.mipmap.cat_foreground);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        paint.setAntiAlias(true);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(width - 30, 30, 25, paint);

        paint.setColor(Color.GREEN);
        canvas.drawRect(0, height - 30, width, height, paint);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setTextSize(32);
        canvas.drawText("Лужайка только для котов и меня", 30, height - 32, paint);

        int x = width - 170;
        int y = 190;
        paint.setColor(Color.GRAY);
        paint.setTextSize(28);
        String strRotate = "Солнце светит прямо в глаз...";
        canvas.save();
        canvas.rotate(-45, x + rect.exactCenterX() + 120, y + rect.exactCenterY() + 300);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(strRotate, x,  y, paint);

        canvas.restore();

        canvas.drawBitmap(bitmap, width - bitmap.getWidth(),
                height - bitmap.getHeight() - 30, paint);
    }
}
