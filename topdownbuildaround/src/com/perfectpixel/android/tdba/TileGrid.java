package com.perfectpixel.android.tdba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class TileGrid {

	private boolean walk, wall;
	private int color, grid_x, grid_y;
	private String id;
	private Bitmap img = null;

	public TileGrid(String _id, boolean _walk, 	boolean _wall, int _color) {
		id = _id;
		walk = _walk;
		wall = _wall;
		color = _color;
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

	public int getGridX() {
		return grid_x;
	}

	public int getGridY() {
		return grid_y;
	}

	public void setGridX(int _x) {
		grid_x = _x;
	}

	public void setGridY(int _y) {
		grid_y = _y;
	}

	public void onDraw(Canvas c, int _level) {
		
		int _x = Global.map.gridToPixel(grid_x, grid_y, _level)[0];
		int _y = Global.map.gridToPixel(grid_x, grid_y, _level)[1];
		
		if (_level > 1) {
			_y -= ((_level-1)/2.0)*Global.tile_size;
		}

		if (img != null) {
			c.drawBitmap(img, _x, _y, null);
		} else {
			
			Global.paint.setColor(color);
			c.drawRect(_x, _y, _x + Global.tile_size, _y + Global.tile_size, Global.paint);
			
			Global.paint.setColor(Color.YELLOW);
			Global.paint.setStyle(Paint.Style.STROKE);
			c.drawRect(_x, _y, _x + Global.tile_size, _y + Global.tile_size, Global.paint);
			Global.paint.setStyle(Paint.Style.FILL);
			
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
