package com.perfectpixel.android.tdba;

public class Inventory {

	final private int TILE_NUM = 100;
	private int[] tiles = new int[TILE_NUM];

	public Inventory() {

	}
	
	public int[] getTiles() {
		return tiles;
	}

	public void addTile(int _tile_id, int _num) {
		tiles[_tile_id] = tiles[_tile_id]+_num;
	}
	
	public void removeTile(int _tile_id, int _num) {
		tiles[_tile_id] = tiles[_tile_id]-_num;
	}

}
