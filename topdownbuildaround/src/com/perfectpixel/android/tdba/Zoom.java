package com.perfectpixel.android.tdba;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;


public class Zoom {

	private int x, y, width, zoom;

	public Zoom(int _x, int _y) {
			x = _x;
			y = _y;
			zoom = 10;
			width = Global.tile_size;
	}
	
	public boolean resolveBounds(float _x, float _y) {
		if (_x > x && _x < x + width && _y > y && _y < y + width) {
			return true;
		}
		return false;
	}

	public void resolveTouch(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_UP && resolveBounds(event.getX(), event.getY())) {
			if (Global.tile_size >= 50) {
				Global.tile_size = zoom;
			}
			else {
				Global.tile_size += zoom;
			}
		}
	}
	
	public void onDraw(Canvas c) {
			
			Global.paint.setColor(Color.YELLOW);

			c.drawRect(x, y, x + width, y + width, Global.paint);
	}
}
