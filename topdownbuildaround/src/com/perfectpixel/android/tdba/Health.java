package com.perfectpixel.android.tdba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class Health {

	final private int BAG_WIDTH = 60;
	private int padding, x;
	private int hearts = 4;

	public Health() {
		padding = BAG_WIDTH / 10;
		x = Global.health_x - (BAG_WIDTH / 2);
	}

	public int getSize() {
		return BAG_WIDTH;
	}

	public void onDraw(Canvas c) {

		int life_max = Global.player.getMaxLife();
		int life = Global.player.getLife();

		Global.paint.setColor(Color.argb(80, 0, 0, 0));
		c.drawRect(x, 0, x + BAG_WIDTH, Global.height, Global.paint);

		for (int i = 0; i < (int) Math.ceil(life / ((float) life_max / hearts)); i++) {

			int y = padding + ((BAG_WIDTH + padding) * i);
			int h = y + BAG_WIDTH - (padding * 2);

			Global.paint.setColor(Color.argb(150, 255, 0, 0));
			c.drawRect(x + padding, y, x + BAG_WIDTH - padding, h, Global.paint);

			Global.paint.setColor(Color.RED);
			c.drawRect(x + (padding * 3), y + (padding * 2), x + BAG_WIDTH
					- (padding * 3), h - (padding * 2), Global.paint);
		}

		Global.paint.setColor(Color.argb(255, 0, 0, 0));

	}
}
