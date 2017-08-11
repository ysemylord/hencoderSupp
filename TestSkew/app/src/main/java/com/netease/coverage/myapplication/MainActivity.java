package com.netease.coverage.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Practice14FlipboardView practice14FlipboardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        practice14FlipboardView = (Practice14FlipboardView) findViewById(R.id.flipboard_view);
        rotateX();
        rotateY();
    }

    private void rotateX() {
        final TextView xRotateTextView = (TextView) findViewById(R.id.x_rotate);
        findViewById(R.id.btn_x_cw).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    practice14FlipboardView.setXDegreeAdd();
                    xRotateTextView.setText(practice14FlipboardView.getxDegree() + "");
                }
                return false;
            }
        });

        findViewById(R.id.reset_rotate_x).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    practice14FlipboardView.resetRotateX();
                    xRotateTextView.setText(practice14FlipboardView.getxDegree() + "");
                }
                return false;
            }
        });

        findViewById(R.id.btn_x_cw_reduce).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    practice14FlipboardView.setXDegreeReduce();
                    xRotateTextView.setText(practice14FlipboardView.getxDegree() + "");
                }
                return false;
            }
        });
    }

    private void rotateY() {
        final TextView yRotateTextView = (TextView) findViewById(R.id.y_rotate);
        findViewById(R.id.btn_y_cw).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    practice14FlipboardView.setYDegreeAdd();
                    yRotateTextView.setText(practice14FlipboardView.getyDegree() + "");
                }
                return false;
            }
        });

        findViewById(R.id.reset_rotate_y).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    practice14FlipboardView.resetRotateY();
                    yRotateTextView.setText(practice14FlipboardView.getyDegree() + "");
                }
                return false;
            }
        });

        findViewById(R.id.btn_y_cw_reduce).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    practice14FlipboardView.setYDegreeReduce();
                    yRotateTextView.setText(practice14FlipboardView.getyDegree() + "");
                }
                return false;
            }
        });
    }

}
