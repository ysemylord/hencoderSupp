package com.netease.coverage.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created  on 2017/8/10.
 *
 * @author xyb
 */

public class TestSkewView  extends View{
    private final Bitmap bitmap;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Point point1 = new Point(200, 100);
    Point point2 = new Point(200, 500);
    Point point3 = new Point(200, 900);
    Point point4 = new Point(200, 1300);
    public TestSkewView(Context context) {
        super(context);
    }

    public TestSkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Matrix matrix=new Matrix();
        canvas.save();
        matrix.reset();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();



        canvas.save();
        matrix.reset();
        matrix.setSkew(0.5f,0);//默认的错切中心
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

        canvas.save();
        matrix.reset();
        matrix.setSkew(0.5f,0,0,0);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y+200, paint);//坐标原点为多且中心
        canvas.restore();

        canvas.save();
        matrix.reset();
        matrix.setSkew(0.5f,0,point3.x, point3.y);//错切中心左上角
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point3.x, point3.y, paint);
        canvas.restore();

        canvas.save();
        matrix.reset();
        matrix.setSkew(0.5f,0,point4.x+bitmap.getWidth()/2,point4.y+bitmap.getHeight()/2);//错切中心图形中心
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point4.x, point4.y, paint);
        canvas.restore();
    }


}
