package com.example.curvyvectors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
    Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
    }

    @Override
    public void onDraw(Canvas canvas) {
    	int initialx = 50; int initialy = 50;
    	int finalx = 200; int finaly = 200;
    	int initialhandlex = 50; int initialhandley = 200;
    	int finalhandlex = 200; int finalhandley = 200;
    	for (int i = initialx; i < 20; i++) {
    		canvas.drawPoint(i, j, paint);
    		j++;
    	}
    }

}