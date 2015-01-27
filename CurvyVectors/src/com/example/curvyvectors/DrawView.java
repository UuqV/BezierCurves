package com.example.curvyvectors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
	int factor = 10000;
    Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
    }
    
    public float slope(float x1, float y1, float x2, float y2) {
    	return (y2 - y1) / (x2 - x1);
    }
    
    public float diff(float x1, float y1, float percent) {
    	return x1 + ((y1 - x1) / factor) * percent;
    }
    public void draw()
    {
    	
    }
    @Override
    public void onDraw(Canvas canvas) {
    	int initialx = 200; int initialy = 200;
    	int finalx = 400; int finaly = 400;
    	int initialhandlex = 500; int initialhandley = 200;
    	int finalhandlex = 200; int finalhandley = 600;
    	for(int i = 0; i < factor; i++)
    	{
    		float t1x = diff(initialx, initialhandlex, i);
    		float t1y = diff(initialy, initialhandley, i);
    		float t2x = diff(initialhandlex, finalhandlex, i);
    		float t2y = diff(initialhandley, finalhandley, i);
    		float t3x = diff(finalhandlex, finalx, i);
    		float t3y = diff(finalhandley, finaly, i);
    		float s1x = diff(t1x, t2x, i);
    		float s1y = diff(t1y, t2y, i);
    		float s2x = diff(t2x, t3x, i);
    		float s2y = diff(t2y, t3y, i);
    		float drawx = diff(s1x, s2x, i);
    		float drawy = diff(s1y, s2y, i);
    		paint.setColor(Color.BLACK);
    		canvas.drawPoint(drawx, drawy, paint);
    		paint.setColor(Color.RED);
    		canvas.drawLine(initialx, initialy, finalx, finaly, paint);
    		paint.setColor(Color.BLUE);
    		canvas.drawLine(initialx, initialy, initialhandlex, initialhandley, paint);
    		canvas.drawLine(finalx, finaly, finalhandlex, finalhandley, paint);
    	}
    	/*
    	float initialhandles = slope(initialx, initialy, initialhandlex, initialhandley);
    	float intrahandles = slope(initialhandlex, initialhandley, finalhandlex, finalhandley);
    	float finalhandles = slope(finalhandlex, finalhandley, finalx, finaly);
    	for (float x = initialx, y = initialy, tri1x = initialx, tri1y = initialy,
    			tri2x = initialhandlex, tri2y = initialhandley,
    			tri3x = finalhandlex, tri3y = finalhandley;
    			x <= finalx && y <= finaly;
    			tri1x++, tri1y += initialhandles, tri2x++, tri2y += intrahandles, tri3x++, tri3y += finalhandles) {
    		
    	}*/
    }

}