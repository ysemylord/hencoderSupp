package com.netease.coverage.myapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class Practice14FlipboardView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Camera camera = new Camera();
    int xDegree;
    int yDegree;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "xDegree", 0, 180);
    int step=10;

    public Practice14FlipboardView(Context context) {
        super(context);
    }

    public Practice14FlipboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        animator.setDuration(2500);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
       // animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    @SuppressWarnings("unused")
    public void setXDegree(int degree) {
        this.xDegree = degree;
        invalidate();
    }

    public int getyDegree() {
        return yDegree;
    }

    public void setyDegree(int yDegree) {
        this.yDegree = yDegree;
        invalidate();
    }

    public void setXDegreeAdd() {
        xDegree = xDegree +step;
        invalidate();
    }
    public void setYDegreeAdd() {
        yDegree = yDegree +step;
        invalidate();
    }

    public void setXDegreeReduce() {
        xDegree = xDegree -step;
        invalidate();
    }

    public void setYDegreeReduce() {
        yDegree = yDegree -step;
        invalidate();
    }

    public int getxDegree() {
        return xDegree;
    }

   public void resetRotateX(){
       setXDegree(0);
   }

   public void resetRotateY(){
       setyDegree(0);
   }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

       // camera.setLocation(0,0,-400);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;

        canvas.save();
        camera.save();
        camera.rotateX(xDegree);
        canvas.translate(centerX, centerY);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        camera.restore();


        canvas.save();
        camera.save();
        camera.rotateY(yDegree);
        canvas.translate(centerX, centerY);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        camera.restore();

        canvas.scale(0.3f,0.3f,centerX,centerY);
        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();

        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        canvas.drawPoint(x, y, paint);

        paint.setColor(Color.RED);
        canvas.drawPoint(centerX, centerY, paint);
    }
}
