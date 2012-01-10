package com.perfectpixel.android.tdba;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Effect {

	private RPGView view;
	private Player player;
	private int x, y, size, counter, color, life;

	public Effect(RPGView _view, Player _player, int _x, int _y, int _size, int _color, int _life) {
		view = _view;
		player = _player;
		x = _x;
		y = _y;
		size = _size;
		color = _color;
		life = _life;
		counter = 0;
	}
	
	public void setSize(int _size) {
		size = _size;
	}
	
	public int getColor() {
		return color;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void onDraw(Canvas c, Paint paint) {
		
		counter++;
		
		paint.setColor(color);

		int draw_x = player.getDrawX() + x - player.getX();
		int draw_y = player.getDrawY() + y - player.getY();
		c.drawRect(draw_x, draw_y, draw_x + size, draw_y + size, paint);
		
		if(counter >= life) {
			view.removeEffect(x,y,color);
		}
	}
}
