package com.perfectpixel.android.tdba;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Player {

	private String direction = "";
	private boolean moving = false;
	private int padding, draw_x, draw_y;
	private int x, y, x1, y1;
	private int speed = 5;
	private int level = 1;
	private Inventory inventory;
	private int max_life = 100;
	private int life = max_life;
	private int damage = 2;
	private int reach = 3;
	private int frame_count = 0;

	public Player(int _x, int _y) {
		draw_x = _x;
		draw_y = _y;
		x1 = 0;
		y1 = 0;
		x = Global.tile_size;
		y = Global.tile_size;
		padding = Global.tile_size / 8;
		inventory = new Inventory();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDrawX() {
		return draw_x;
	}

	public int getDrawY() {
		return draw_y;
	}

	public int getLevel() {
		return level;
	}
	
	public int getReach() {
		return reach;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void damage(int _input) {
		life -= _input;
	}

	public int getLife() {
		return life;
	}

	public int getMaxLife() {
		return max_life;
	}

	public int getDamage() {
		return damage;
	}
	
	public void setDirection(String _direction) {
		if (!moving && !_direction.equals("")) {
			if (level > 0 && Global.map.getWalk(_direction, getX(), getY(), level-1)) {
				if (Global.map.getWalk(_direction, getX(), getY(), level)) {
					if (level < Global.map.maps.size() && Global.map.getWalk(_direction, getX(), getY(), level + 1)) {
						direction = _direction;
						moving = true;
					}
				}
			}
		}
	}

	public void movePlayer() {

		if (moving && x1 == 0 && y1 == 0) {
			if (direction.equals("up")) {
				y1 = y - Global.tile_size;
			} else if (direction.equals("right")) {
				x1 = x + Global.tile_size;
			} else if (direction.equals("down")) {
				y1 = y + Global.tile_size;
			} else if (direction.equals("left")) {
				x1 = x - Global.tile_size;
			}
		}

		if (direction.equals("left") && x <= x1) {
			x = x1;
			x1 = 0;
			y1 = 0;
			direction = "";
			moving = false;
		} else if (direction.equals("right") && x >= x1) {
			x = x1;
			x1 = 0;
			y1 = 0;
			direction = "";
			moving = false;
		} else if (direction.equals("up") && y <= y1) {
			y = y1;
			x1 = 0;
			y1 = 0;
			direction = "";
			moving = false;
		} else if (direction.equals("down") && y >= y1) {
			y = y1;
			x1 = 0;
			y1 = 0;
			direction = "";
			moving = false;
		}

		if (moving) {
			if (direction.equals("up")) {
				y -= (Global.tile_size / speed);
			} else if (direction.equals("right")) {
				x += (Global.tile_size / speed);
			} else if (direction.equals("down")) {
				y += (Global.tile_size / speed);
			} else if (direction.equals("left")) {
				x -= (Global.tile_size / speed);
			}
		}
	}

	public void onDraw(Canvas c) {

		if (Global.map != null)
			movePlayer();
		
		frame_count++;

		Global.paint.setColor(Color.LTGRAY);
		// c.drawRect(draw_x + padding, draw_y + padding, draw_x + size - padding, draw_y + size - padding, paint);
		drawLegs(c, 0, 0);
		drawBody(c, 0, 0);
		drawHead(c, 0, 0);
		drawHands(c, 0,0);

		// paint.setStyle(Paint.Style.STROKE);
		// c.drawRect(draw_x, draw_y, draw_x + size, draw_y + size, paint);
		// paint.setStyle(Paint.Style.FILL);
	}
	
	public void drawHands(Canvas c, int _x, int _y) {
		int tmp_w = padding*2;
		int tmp_x = draw_x + padding;
		int tmp_y = draw_y + (Global.tile_size/2);

		Global.paint.setColor(Color.rgb(255, 204, 153));
		c.drawRect(tmp_x, tmp_y, tmp_x + tmp_w, tmp_y + tmp_w, Global.paint);
		c.drawRect(draw_x+Global.tile_size-padding-tmp_w, tmp_y, draw_x+Global.tile_size-padding, tmp_y + tmp_w, Global.paint);
	}

	public void drawHead(Canvas c, int _x, int _y) {
		int tmp_w = (int) (Global.tile_size*.4);
		int tmp_x = draw_x + ((Global.tile_size-tmp_w)/2) + _x;
		int tmp_y = (int) (draw_y - (padding*1.5) +_y);

		//Hood/hair/helmet
		Global.paint.setColor(Color.rgb(204, 0, 0));
		int tmp = padding/2;
		c.drawRect(tmp_x-tmp, tmp_y-tmp, tmp_x + tmp_w+tmp, tmp_y + tmp_w-tmp, Global.paint);
		
		Global.paint.setColor(Color.rgb(255, 204, 153));
		c.drawRect(tmp_x, tmp_y, tmp_x + tmp_w, tmp_y + tmp_w, Global.paint);
	}

	public void drawBody(Canvas c, int _x, int _y) {
		int tmp_w = Global.tile_size - (padding * 2);
		int tmp_x = draw_x + (padding) + _x;
		int tmp_y = draw_y + (Global.tile_size / 6) + _y;

		Global.paint.setColor(Color.rgb(204, 0, 0));

		c.drawRect(tmp_x + padding, tmp_y, tmp_x + tmp_w - padding, (int) (draw_y + (Global.tile_size * .7)), Global.paint);

		c.drawRect(tmp_x, tmp_y, tmp_x + tmp_w, (int) (draw_y + (Global.tile_size * .5)), Global.paint);
	}

	public void drawLegs(Canvas c, int _x, int _y) {
		int tmp_w = Global.tile_size - (padding * 4);
		int tmp_x = draw_x + padding * 2 + _x;
		int tmp_y = draw_y + (Global.tile_size / 2) + _y;

		Global.paint.setColor(Color.rgb(102, 51, 0));
		c.drawRect(tmp_x, tmp_y, tmp_x + tmp_w, draw_y + Global.tile_size - (padding / 2), Global.paint);
		Global.paint.setColor(Color.rgb(51, 0, 0));
		c.drawRect(tmp_x + (tmp_w / 2), tmp_y, tmp_x + tmp_w, draw_y + Global.tile_size	- (padding / 2), Global.paint);
	}
}
