package com.perfectpixel.android.tdba;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class RPGView extends SurfaceView {

	private Joystick j1;
	private Joystick j2;
	private RPGLoop loop;
	private SurfaceHolder holder;
	private Zoom zoom;
	
	private TileGrid grid_tile;

	public RPGView(Context context) {
		super(context);
		
		loop = new RPGLoop(this);
		holder = getHolder();
		holder.addCallback(new SurfaceHolder.Callback() {

			public void surfaceChanged(SurfaceHolder holder, int format,
					int width, int height) {
			}

			public void surfaceCreated(SurfaceHolder holder) {
				setGame();
				loop.setRun(true);
				loop.start();
			}

			public void surfaceDestroyed(SurfaceHolder holder) {
				boolean retry = true;
				loop.setRun(false);
				while (retry) {
					try {
						loop.join();
						retry = false;
					}catch (InterruptedException e) {
					}
				}
			}
		});
	}

	public void setGame() {
		
		Global.view = this;
		
		setSize();
		
		Global.player = new Player((Global.width / 2) - (Global.tile_size / 2), (Global.height / 2) - (Global.tile_size / 2));
		Global.map = new Map();
		
		setUI();
		setTiles();
	}

	public void setSize() {
		Global.width = this.getWidth();
		Global.height = this.getHeight();
	}
	
	/*public void newSize(int _size) {
		TILE_SIZE = _size;
		setTiles();
		player.setSize(_size);
		map.setSize(_size);
		map.setTiles(tiles);
		for (int i = 0; i < effects.size(); i++) {
			effects.get(i).setSize(_size);
		}
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).setSize(_size);
		}
	}*/

	public void setUI() {
		
		//Joysticks
		int j_size = 150;
		int j_padding = 30;
		j1 = new Joystick(j_padding, Global.height - j_size - j_padding, j_size);
		j2 = new Joystick(Global.width - j_size - j_padding, Global.height - j_size - j_padding, j_size);
		
		//Inventory display
		Global.bag_x = Global.width - (j_size / 2) - j_padding;
		Global.bag = new Bag();
		
		//Health display
		Global.health_x = (j_size / 2) + j_padding;
		Global.health = new Health();
		
		//Zoom button
		zoom = new Zoom(Global.width - Global.tile_size, 0);
	}

	public void setTiles() {
		
		//Add tiles to arraylist
		Global.tiles.clear();

		Global.tiles.add(new Tile("blank", 999, true, false, Color.argb(0, 0, 0, 0)));
		Global.tiles.add(new Tile("water", 999, false, false, Color.rgb(0, 0, 200)));
		Global.tiles.add(new Tile("grass", 999, true, false, Color.rgb(50, 205, 50)));
		Global.tiles.add(new Tile("wall_brick", 30, false, true, Color.rgb(200, 0, 0)));
		Global.tiles.add(new Tile("wall_stone", 30, false, true, Color.GRAY));
		Global.tiles.add(new Tile("wall_wood", 15, false, true, Color.rgb(189, 183, 107)));
		Global.tiles.add(new Tile("wall_blank", 999, true, false,	Color.argb(0, 0, 0, 0)));
		Global.tiles.add(new Tile("spawner", 100, false, true, Color.argb(255, 50, 50, 50)));
		/*
		 * tiles.get(4).setIMG(
		 * BitmapFactory.decodeResource(view.getResources(), R.drawable.icon));
		 */

		grid_tile = new TileGrid( "grid_tile", false, false,	Color.argb(0, 0, 0, 0));
	}

	public void spawnEnemy(int _x, int _y, int _level) {
		
		if (Global.enemies.size() < Global.enemy_max) {
			int tmp_x = _x * Global.tile_size;
			int tmp_y = _y * Global.tile_size;
			if (Global.map.getWalk("right", tmp_x, _y, _level)) {
				tmp_x = _x + 1;
			} else if (Global.map.getWalk("left", _x, _y, _level)) {
				tmp_x = _x - 1;
			} else if (Global.map.getWalk("up", _x, _y, _level)) {
				tmp_y = _y - 1;
			} else if (Global.map.getWalk("down", _x, _y, _level)) {
				tmp_y = _y + 1;
			}

			Enemy tmp = new Enemy(this, tmp_x, tmp_y);
			Global.enemies.add(tmp);
		}
	}

	public void removeEnemy(int _x, int _y) {
		for (int i = 0; i < Global.enemies.size(); i++) {
			if (Global.enemies.get(i).getX() == _x) {
				if (Global.enemies.get(i).getY() == _y) {
					Global.enemies.remove(i);
				}
			}
		}
	}

	public void addEffect(int _x, int _y, int _color, int _life, int _level) {
		Global.effects.add(new Effect(_x * Global.tile_size, _y * Global.tile_size - Global.map.levelDelta(_level), _color, _life));
	}

	public void removeEffect(int _x, int _y, int _color) {
		for (int i = 0; i < Global.effects.size(); i++) {
			if (Global.effects.get(i).getX() == _x) {
				if (Global.effects.get(i).getY() == _y) {
					if (Global.effects.get(i).getColor() == _color) {
						Global.effects.remove(i);
					}
				}
			}
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {

		//Store current joystick positions
		String direction = "";
		String direction_secondary = "";
		
		//If not placing object, check joysticks
		if (!Global.grid) {
			direction = j1.getDirection();
			direction_secondary = j2.getDirection();
		}

		//Pass through results of joysticks
		Global.player.setDirection(direction);
		Global.map.setDamage(direction_secondary);

		//Draw black canvas
		Global.paint.setStyle(Paint.Style.FILL);
		canvas.drawColor(Color.BLACK);

		//Draw map
		for(int i = 0; i <= Global.player.getLevel(); i++) {
			
			if (Global.grid && Global.grid_level == i) {
				Global.map.drawGrid(canvas);
			}
			
			Global.map.drawLevel(canvas, i);
		}

		//Draw each enemy
		for (int i = 0; i < Global.enemies.size(); i++) {
			Global.enemies.get(i).onDraw(canvas);
		}

		//Draw player
		Global.player.onDraw(canvas);

		for(int i = Global.player.getLevel()+1; i < Global.map.maps.size(); i++) {
			
			if (Global.grid && Global.grid_level == i) {
				Global.map.drawGrid(canvas);
			}
			
			Global.map.drawLevel(canvas, i);
		}
		
		//Draw each effect
		for (int i = 0; i < Global.effects.size(); i++) {
			Global.effects.get(i).onDraw(canvas);
		}
		
		//Draw global map components
		Global.map.onDraw(canvas);
		
		//Draw zoom button
		zoom.onDraw(canvas);

		//Draw UI components
		Global.bag.onDraw(canvas);
		Global.health.onDraw(canvas);
		j1.onDraw(canvas, Global.paint);
		j2.onDraw(canvas, Global.paint);
		
		//Draw grid if active
		if (Global.grid)
			grid_tile.onDraw(canvas, Global.grid_level);
	
	}

	public void tileClick(int _type) {
		
		if (Global.bag.getPlacing()) {
			
			if (_type == 1) {
				Global.bag.setPlacing(false);
				Global.grid = false;
				grid_tile.setColor(Color.argb(0, 0, 0, 0));
			}
			
			if (_type == 2) {

				if (Global.map.getPlace(grid_tile.getGridX(), grid_tile.getGridY(), Global.grid_level)) {
					Global.map.placeTile(grid_tile.getGridX(), grid_tile.getGridY(), Global.grid_level, Integer.parseInt(grid_tile.getID()));
					Global.bag.setPlacing(false);
					Global.grid = false;
					grid_tile.setColor(Color.argb(0, 0, 0, 0));
					Global.player.getInventory().removeTile(Integer.parseInt(grid_tile.getID()), 1);
				}
			}
			
			if (_type == 3) {
				Global.grid_level += 1;
			}
			
			if (_type == 4) {
				Global.grid_level -= 1;
			}
			
			if (Global.grid_level > Global.map.maps.size()-1) {
				Global.grid_level = Global.map.maps.size()-1;
			}
			
			if (Global.grid_level < 1) {
				Global.grid_level = 1;
			}
			
		} else {
			Global.bag.setPlacing(true);
			Global.grid = true;
			int color = Global.tiles.get(_type).getColor();
			grid_tile.setColor(color);
			grid_tile.setID(Integer.toString(_type));
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		int id = 999;
		int tile = Global.bag.resolveTouch(event);
		
		zoom.resolveTouch(event);
		
		if (tile != 999)
			tileClick(tile);
		
		if (!Global.bag.getPlacing()) {
			
			int action = event.getAction();
			switch (action & MotionEvent.ACTION_MASK) {
			
				case MotionEvent.ACTION_DOWN:
					//id = action >> MotionEvent.ACTION_POINTER_ID_SHIFT;
					id = event.getPointerId(0);
					j1.pointerDown(id, event.getX(id), event.getY(id));
					j2.pointerDown(id, event.getX(id), event.getY(id));
					break;
					
				case MotionEvent.ACTION_POINTER_DOWN:
					id = action >> MotionEvent.ACTION_POINTER_ID_SHIFT;
					j1.pointerDown(id, event.getX(id), event.getY(id));
					j2.pointerDown(id, event.getX(id), event.getY(id));
					break;

				case MotionEvent.ACTION_UP:
					id = 999;
					//id = action >> MotionEvent.ACTION_POINTER_ID_SHIFT;
					id = event.getPointerId(0);
					j1.pointerUp(id, event.getX(id), event.getY(id));
					j2.pointerUp(id, event.getX(id), event.getY(id));
					break;
					
				case MotionEvent.ACTION_POINTER_UP:
					id = action >> MotionEvent.ACTION_POINTER_ID_SHIFT;
					j1.pointerUp(id, event.getX(id), event.getY(id));
					j2.pointerUp(id, event.getX(id), event.getY(id));
					break;
					
				case MotionEvent.ACTION_MOVE:
					for (int i = 0; i < event.getPointerCount(); i++) {
						j1.pointerMove(event.getPointerId(i), event.getX(i), event.getY(i));
						j2.pointerMove(event.getPointerId(i), event.getX(i), event.getY(i));
					}		
					break;
				
			}
		}

		else if (event.getAction() == MotionEvent.ACTION_UP && tile == 999) {
			
			int[] tmp = Global.map.pixelToGrid((int) event.getX(), (int) event.getY(), Global.grid_level);
			
			if (tmp[0] > 0 && tmp[1] >= 0) {
				if (Global.bag_x > Global.width / 2 && event.getX() < Global.bag_x) {
					grid_tile.setGridX(tmp[0]);
					grid_tile.setGridY(tmp[1]);
				}
				if (Global.bag_x < Global.width / 2 && event.getX() > Global.bag_x + Global.bag.getSize()) {
					grid_tile.setGridX(tmp[0]);
					grid_tile.setGridY(tmp[1]);
				}
			}
		}

		return true;
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
	}
}