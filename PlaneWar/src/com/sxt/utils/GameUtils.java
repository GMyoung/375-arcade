package com.sxt.utils;

import com.sxt.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// This class serves as the parent class for game elements
public class GameUtils {
	// Load background image
	public static Image bdImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
	// Load boss image
	public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
	// Load explosion image
	public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
	// Load our plane image
	public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
	// Load our plane bullet image
	public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
	// Load enemy small plane image
	public static Image enemy1Img = Toolkit.getDefaultToolkit().getImage("imgs/enemy1.png");
	// Load enemy big plane image
	public static Image enemy2Img = Toolkit.getDefaultToolkit().getImage("imgs/enemy2.png");
	// Load enemy big plane bullet image
	public static Image enemy2BulletImg = Toolkit.getDefaultToolkit().getImage("imgs/enemy2bullet.png");

	// Create a collection for our plane bullets
	public static List<ShellObj> shellObjList = new ArrayList<>();
	// Create a collection for enemy small planes
	public static List<Enemy1Obj> enemy1ObjList = new ArrayList<>();
	// Create a collection for enemy big planes
	public static List<Enemy2Obj> enemy2ObjList = new ArrayList<>();
	// Collection for all elements
	public static List<GameObj> gameObjList = new ArrayList<>();
	// Collection for enemy big plane bullets
	public static List<Enemy2BulletObj> enemy2BulletObjList = new ArrayList<>();
	// Collection to remove elements from the game window
	public static List<GameObj> removeList = new ArrayList<>();
	// Collection for explosions
	public static List<ExplodeObj> explodeObjList = new ArrayList<>();
}
