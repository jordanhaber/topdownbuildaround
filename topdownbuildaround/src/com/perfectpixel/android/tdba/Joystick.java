package com.perfectpixel.android.tdba;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick {

	final int TOP_SIZE = 60;
	private int x1, x2, y1, y2, size, pointer_id;
	int base_color, top_color;
	boolean dragging;
	double angle = 0;
	String direction = "";

	public Joystick(int _x, int _y, int _size) {
		x1 = _x;
		y1 = _y;
		size = _size;
		x2 = getX();
		y2 = getY();
		pointer_id = 999;
		base_color = Color.argb(50, 255, 255, 255);
		top_color = Color.argb(130, 0, 0, 0);
	}

	public int getX() {
		return x1 + (size / 2);
	}

	public int getY() {
		return y1 + (size / 2);
	}

	public int getR() {
		return size / 2;
	}

	public String getDirection() {
		return direction;
	}

	public void resolveTouch(float _x, float _y) {
		float tmp_x = _x - getX();
		float tmp_y = _y - getY();
		angle = Math.atan2(tmp_y, tmp_x) * 180 / Math.PI;
		if (angle > -135 && angle < -45) {
			direction = "up";
		} else if (angle > -45 && angle < 45) {
			direction = "right";
		} else if (angle > 45 && angle < 135) {
			direction = "down";
		} else if (angle > 135 || angle < -135) {
			direction = "left";
		}
	}
	
	public void pointerMove(int _id, float _x, float _y) {
		if (pointer_id == _id) {
			if(dragging) {
				double a = Math.pow((_x - getX()), 2);
				double b = Math.pow((_y - getY()), 2);
				double d = Math.sqrt(a + b);
				if (d < getR() && d > TOP_SIZE / 3) {
					dragging = true;
					x2 = (int) _x;
					y2 = (int) _y;
				}
				if (d > TOP_SIZE / 3)
					resolveTouch(_x, _y);
			}
		}
	}
	
	public void pointerDown(int _id, float _x, float _y) {
		if (pointer_id == 999) {
			double a = Math.pow((_x - getX()), 2);
			double b = Math.pow((_y - getY()), 2);
			double d = Math.sqrt(a + b);
			if (d < getR()) {
				pointer_id = _id;
				dragging = true;
				x2 = (int) _x;
				y2 = (int) _y;
				if (d > TOP_SIZE / 3)
					resolveTouch(_x, _y);
			}
		}
	}
	
	public void pointerUp(int _id, float _x, float _y) {
		if (_id == pointer_id) {
			pointer_id = 999;
			dragging = false;
			direction = "";
			x2 = getX();
			y2 = getY();
		}
	}

	public void onDraw(Canvas c, Paint paint) {

		paint.setStyle(Paint.Style.FILL);

		paint.setColor(base_color);
		c.drawCircle(x1 + (size / 2), y1 + (size / 2), size / 2, paint);

		paint.setColor(top_color);
		c.drawCircle(x2, y2, TOP_SIZE / 2, paint);
		
		/*paint.setColor(Color.RED);
		paint.setTextAlign(Paint.Align.CENTER);
		c.drawText(Integer.toString(pointer_id), (int) getX(), (int) getY(), paint);*/
	}

}
