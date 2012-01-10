package com.perfectpixel.android.tdba;

import java.util.ArrayList;

import android.graphics.Paint;

public class Global {
	
	public static String test = "recieved";
	
	public static int tile_size = 50;
	
	public static int width;
	public static int height;
	
	public static RPGView view;
	
	public static Player player;
	public static Map map;
	public static Bag bag;
	public static Health health;
	
	public static int bag_x;
	public static int health_x;
	
	public static ArrayList<Tile> tiles = new ArrayList<Tile>();
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static ArrayList<Effect> effects = new ArrayList<Effect>();
	
	public static Paint paint = new Paint();
	
	public static int enemy_max  = 20;
	
	public static int grid_level = 1;
	public static boolean grid = false;
	
}
