package com.perfectpixel.android.tdba;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Enemy {

	private String direction = "";
	private boolean moving = false;
	private int padding;
	private int x, y, x1, y1;
	private int speed = 10;
	private int level = 0;
	private int laziness = 70;
	private int awareness = 3;
	private int life = 20;
	private int damage = 10;

	public Enemy(RPGView _view, int _x, int _y) {
		x1 = _x;
		y1 = _y;
		x = _x;
		y = _y;
		padding = Global.tile_size / 5;
		awareness = (int) (awareness + Math.ceil(Math.random() * 3));
		laziness = (int) Math.ceil(Math.random() * laziness);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getGridX() {
		return (int) Math.floor(x / Global.tile_size);
	}

	public int getGridY() {
		return (int) Math.floor(y / Global.tile_size);
	}

	public int getLevel() {
		return level;
	}

	public void setLaziness(int _input) {
		laziness = _input;
	}

	public void setDirection(String _direction) {
		if (!moving && !_direction.equals("") && Global.map != null) {
			if (Global.map.getWalk(_direction, x, y, level)
					&& Global.map.getWalk(_direction, x, y, level + 1)) {
				direction = _direction;
				moving = true;
			}
		}
	}

	public void moveEnemy() {

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

	public void explode() {
		Global.player.damage(damage);
		Global.view.addEffect(Global.map.getCenterTile()[0], Global.map.getCenterTile()[1], Color.argb(100, 255, 50 ,50), 3, level);
		Global.view.removeEnemy(x, y);
	}

	public String chooseMove() {
		if (Math.abs(x - Global.player.getX()) / Global.tile_size == 0	&& Math.abs(y - Global.player.getY()) / Global.tile_size == 0) {
			explode();
			return "";
		}

		if (Math.abs(x - Global.player.getX()) / Global.tile_size < awareness && Math.abs(y - Global.player.getY()) / Global.tile_size < awareness) {
			if (Global.player.getX() > x) {
				if (Global.map.getWalk("right", x, y, Global.player.getLevel()) && Global.map.getWalk("right", x, y, Global.player.getLevel() + 1)) {
					return "right";
				}
			}
			if (Global.player.getX() < x) {
				if (Global.map.getWalk("left", x, y, Global.player.getLevel())	&& Global.map.getWalk("left", x, y, Global.player.getLevel() + 1)) {
					return "left";
				}
			}
			if (Global.player.getY() > y) {
				if (Global.map.getWalk("down", x, y, Global.player.getLevel())	&& Global.map.getWalk("down", x, y, Global.player.getLevel() + 1)) {
					return "down";
				}
			}
			if (Global.player.getY() < y) {
				if (Global.map.getWalk("up", x, y, Global.player.getLevel()) && Global.map.getWalk("up", x, y, Global.player.getLevel() + 1)) {
					return "up";
				}
			}
		} else {
			int r = (int) Math.ceil(Math.random() * laziness);
			switch (r) {
			case 1:
				return "up";
			case 2:
				return "right";
			case 3:
				return "down";
			case 4:
				return "left";
			}
		}
		return "";
	}

	public void onDraw(Canvas c) {

		setDirection(chooseMove());

		if (Global.map != null)
			moveEnemy();

		Global.paint.setColor(Color.BLACK);
		int draw_x = Global.player.getDrawX() + x - Global.player.getX();
		int draw_y = Global.player.getDrawY() + y - Global.player.getY();
		c.drawRect(draw_x + padding, draw_y + padding, draw_x + Global.tile_size - padding,	draw_y + Global.tile_size - padding, Global.paint);

		// paint.setStyle(Paint.Style.STROKE);
		// c.drawRect(draw_x, draw_y, draw_x + size, draw_y + size, paint);
		// paint.setStyle(Paint.Style.FILL);
	}
}
