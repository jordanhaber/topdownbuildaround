package com.perfectpixel.android.tdba;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Effect {

	private int x, y, counter, color, life;

	public Effect(int _x, int _y, int _color, int _life) {
		x = _x;
		y = _y;
		color = _color;
		life = _life;
		counter = 0;
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

	public void onDraw(Canvas c) {
		
		counter++;
		
		Global.paint.setColor(color);

		int draw_x = Global.player.getDrawX() + x - Global.player.getX();// + (player.getX()%size);
		int draw_y = Global.player.getDrawY() + y - Global.player.getY();// - (player.getY()%size);
		c.drawRect(draw_x, draw_y, draw_x + Global.tile_size, draw_y + Global.tile_size, Global.paint);
		
		if(counter >= life) {
			Global.view.removeEffect(x,y,color);
		}
	}
}
