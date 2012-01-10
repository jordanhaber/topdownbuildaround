package com.perfectpixel.android.tdba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Tile {

	private boolean walk, wall;
	private int color, life;
	private String id;
	private Bitmap img = null;

	public Tile(String _id, int _life, boolean _walk, boolean _wall, int _color) {
		id = _id;
		walk = _walk;
		wall = _wall;
		color = _color;
		life = _life;
	}

	public void setIMG(Bitmap _img) {
		img = _img;
	}

	public void setWall(boolean _input) {
		wall = _input;
	}

	public void setColor(int _color) {
		color = _color;
	}

	public void setID(String _id) {
		id = _id;
	}

	public boolean getWall() {
		return wall;
	}

	public boolean getWalk() {
		return walk;
	}

	public String getID() {
		return id;
	}

	public int getColor() {
		return color;
	}

	public int getLife() {
		return life;
	}

	public void onDraw(Canvas c, int _x, int _y, int _grid_x,	int _grid_y, int _level) {

		if (img != null) {
			c.drawBitmap(img, _x, _y, null);
		} else {
			Global.paint.setColor(color);
			if (wall && !Global.map.getTile(_grid_x, _grid_y + 1, _level).getWall()) {
				Global.paint.setColor(Color.BLACK);
				c.drawRect(_x, _y, _x + Global.tile_size, _y + Global.tile_size, Global.paint);
				Global.paint.setColor(color);
				c.drawRect(_x, _y, _x + Global.tile_size, _y + (Global.tile_size / 2), Global.paint);
				Global.paint.setAlpha(Global.paint.getAlpha() - 80);
				c.drawRect(_x, _y + (Global.tile_size / 2), _x + Global.tile_size, _y + Global.tile_size, Global.paint);
			} else {
				c.drawRect(_x, _y, _x + Global.tile_size, _y + Global.tile_size, Global.paint);
			}
			Global.paint.setAlpha(255);
		}
	}

	public void drawInventory(Canvas c, int _x, int _y, int _size) {

		if (img != null) {
			c.drawBitmap(img, _x, _y, null);
		} else {
			Global.paint.setColor(color);
			c.drawRect(_x, _y, _x + _size, _y + _size, Global.paint);
		}
	}
}
