package com.perfectpixel.android.tdba;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Map {

	public ArrayList <int[][]> maps = new ArrayList <int[][]>();
	
	int[][] map0 = new int[][] {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	int[][] map1 = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 4, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 4, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	
	int[][] map2 = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	
	int[][] map3 = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	private int player_x, player_y;
	private int center_x, center_y;
	private ArrayList<int[]> damaged_tiles = new ArrayList<int[]>();
	private int[] player_tile;
	private int counter = 0;
	private int spawn_counter = 30 * 5;

	public Map() {
		
		maps.add(map0);
		maps.add(map1);
		maps.add(map2);
		maps.add(map3);
		
		updatePlayer();
		player_tile = getCenterTile();
	}

	public int[] pixelToGrid(int _x, int _y, int _level) {
		_y += levelDelta(_level);
		int tmp_x, tmp_y;
		tmp_x = (int) Math.floor((_x - center_x) / (float) Global.tile_size);
		tmp_y = (int) Math.floor((_y - center_y) / (float) Global.tile_size);
		tmp_x = getCenterTile()[0] + tmp_x;
		tmp_y = getCenterTile()[1] + tmp_y;
		return new int[] { tmp_x, tmp_y };
	}

	public int[] gridToPixel(int _x, int _y, int _level) {
		int tmp_x = center_x + (_x * Global.tile_size) - player_x;
		int tmp_y = center_y + (_y * Global.tile_size) - player_y;
		return new int[] { tmp_x, tmp_y };
	}

	public int levelDelta(int _level) {
		int tmp_y = 0;
		if (_level > 1)
			tmp_y = (int) (((_level-1)/2.0)*Global.tile_size);
		return tmp_y;
	}
	
	public boolean getPlace(int _x, int _y, int _level) {
		if (maps.get(_level)[_y][_x] == 0) {
			return true;
		}
		return false;
	}

	public void placeTile(int _x, int _y, int _level, int _input) {
		maps.get(_level)[_y][_x] = _input;
	}

	public boolean getWalk(String _direction, int _x, int _y, int _level) {
		try {
			if (_direction.equals("up")) {
				return Global.tiles.get(maps.get(_level)[(_y / Global.tile_size) - 1][_x / Global.tile_size]).getWalk();
			} else if (_direction.equals("right")) {
				return Global.tiles.get(maps.get(_level)[_y / Global.tile_size][(_x / Global.tile_size) + 1]).getWalk();
			} else if (_direction.equals("down")) {
				return Global.tiles.get(maps.get(_level)[(_y / Global.tile_size) + 1][_x / Global.tile_size]).getWalk();
			} else if (_direction.equals("left")) {
				return Global.tiles.get(maps.get(_level)[_y / Global.tile_size][(_x / Global.tile_size) - 1]).getWalk();
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public int[] getCenterTile() {
		int tmp_x = (int) Math.round(player_x / Global.tile_size);
		int tmp_y = (int) Math.round(player_y / Global.tile_size);
		int[] tmp = { tmp_x, tmp_y };
		return tmp;
	}

	public Tile getTile(int _x, int _y, int _level) {
		return Global.tiles.get(maps.get(_level)[_y][_x]);
	}

	public void setDamage(String _direction) {
		
		int[] tmp = getCenterTile();
		
		for (int i = 0; i < Global.player.getLevel()+Global.player.getReach(); i++) {
		
			if (Global.player.getLevel()+i < maps.size()) {
			
				if (_direction.equals("up")) {
					if (!getPlace(tmp[0], tmp[1] - 1, Global.player.getLevel()+i)) {
						damage(tmp[0], tmp[1] - 1, Global.player.getLevel()+i, Global.player.getDamage());
						break;
					}
				}	
				if (_direction.equals("down")) {
					if (!getPlace(tmp[0], tmp[1] + 1, Global.player.getLevel()+i)) {
						damage(tmp[0], tmp[1] + 1, Global.player.getLevel()+i, Global.player.getDamage());
						break;
					}
				}
				if (_direction.equals("left")) {
					if (!getPlace(tmp[0] - 1, tmp[1], Global.player.getLevel()+i)) {
						damage(tmp[0] - 1, tmp[1], Global.player.getLevel()+i, Global.player.getDamage());
						break;
					}
				}
				if (_direction.equals("right")) {
					if (!getPlace(tmp[0] + 1, tmp[1], Global.player.getLevel()+i)) {
						damage(tmp[0] + 1, tmp[1], Global.player.getLevel()+i, Global.player.getDamage());
						break;
					}
				}
			}
		}
	}

	public void damage(int _x, int _y, int _level, int _damage) {
		int damage = _damage;
		int curr_dmg = 0;
		int index = 0;
		boolean existing = false;
		for (int i = damaged_tiles.size()-1; i > 0; i--) {
			int[] tmp = damaged_tiles.get(i);
			if (tmp[0] == _x && tmp[1] == _y && tmp[2] == _level) {
				tmp[3] = damage + tmp[3];
				curr_dmg = tmp[3];
				damaged_tiles.remove(i);
				damaged_tiles.add(tmp);
				index = i;
				existing = true;
				break;
			}
		}
		if (!existing) {
			int[] tmp = new int[] { _x, _y, _level, damage };
			damaged_tiles.add(tmp);
		}

		if (curr_dmg >= Global.tiles.get(maps.get(_level)[_y][_x]).getLife()) {
			Global.player.getInventory().addTile(maps.get(_level)[_y][_x], 1);
			placeTile(_x, _y, _level, 0);
			damaged_tiles.remove(index);
		}
				
		Global.view.addEffect(_x, _y, Color.argb(100, 255, 255, 255), 2, _level);
	}

	public void updatePlayer() {
		player_x = Global.player.getX();
		player_y = Global.player.getY();
		center_x = Global.player.getDrawX();
		center_y = Global.player.getDrawY();
	}

	public int[] getDrawRestrict() {

		int safe = 3;

		int min_x = (int) (getCenterTile()[0] - Math.floor((Global.width / 2) / Global.tile_size) - safe);
		int max_x = (int) (getCenterTile()[0] + Math.ceil((Global.width / 2) / Global.tile_size) + safe);
		int min_y = (int) (getCenterTile()[1] - Math.floor((Global.height / 2) / Global.tile_size) - safe);
		int max_y = (int) (getCenterTile()[1] + Math.ceil((Global.height / 2) / Global.tile_size) + safe);

		int[] tmp = new int[] { min_x, max_x, min_y, max_y };
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] < 0)
				tmp[i] = 0;
			if (tmp[i] > map0[0].length && i < 2)
				tmp[i] = map0[0].length;
			if (tmp[i] > map0.length && i > 1)
				tmp[i] = map0.length;
		}
		return tmp;
	}

	public void onDraw(Canvas c) {

		counter++;
		updatePlayer();

		placeTile(player_tile[0], player_tile[1], Global.player.getLevel(), 0);
		player_tile = getCenterTile();
		placeTile(player_tile[0], player_tile[1], Global.player.getLevel(), 6);

		for (int y = 0; y < map1.length; y++) {
			for (int x = 0; x < map1[y].length; x++) {
				if (Global.tiles.get(map1[y][x]).getID().equals("spawner")) {
					if (counter % spawn_counter == 0) {
						Global.view.spawnEnemy(x, y, 0);
					}
				}
			}
		}
	}
	
	public void drawLevel(Canvas c, int _level) {
		
		int[] restrict = getDrawRestrict();
		
		for (int y = restrict[2]; y < restrict[3]; y++) {
			for (int x = restrict[0]; x < restrict[1]; x++) {
				
				int draw_x = center_x + (x * Global.tile_size) - player_x;
				int draw_y = center_y + (y * Global.tile_size) - player_y;

				draw_y -= levelDelta(_level);
				
				Tile tmp = Global.tiles.get(maps.get(_level)[y][x]);
				tmp.onDraw(c, draw_x, draw_y, x, y, _level);
			}
		}
	}

	public void drawGrid(Canvas c) {
		
		int[] restrict = getDrawRestrict();

		for (int y = restrict[2]; y < restrict[3]; y++) {
			for (int x = restrict[0]; x < restrict[1]; x++) {
				
				int tmp_y = levelDelta(Global.grid_level);

				int draw_x = center_x + (x * Global.tile_size) - player_x;
				int draw_y = center_y + (y * Global.tile_size) - player_y-tmp_y;

				Global.paint.setColor(Color.argb(150, 255, 255, 255));
				c.drawRect(draw_x, draw_y, draw_x + Global.tile_size, draw_y + Global.tile_size, Global.paint);

				Global.paint.setStyle(Paint.Style.STROKE);
				Global.paint.setColor(Color.argb(80, 0, 0, 0));
				c.drawRect(draw_x, draw_y, draw_x + Global.tile_size, draw_y + Global.tile_size, Global.paint);

				Global.paint.setStyle(Paint.Style.FILL);
				Global.paint.setColor(Color.WHITE);
			}
		}
	}
}
