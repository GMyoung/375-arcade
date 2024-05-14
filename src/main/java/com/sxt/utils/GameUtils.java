package com.sxt.utils;

import com.sxt.obj.*;

import java.awt.*;
import java.util.*;
import java.util.List;

// This class serves as the parent class for game elements
public class GameUtils {
	// Load background image
	public static Image bdImg = Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/bg.jpg"));
	// Load boss image
	public static Image bossImg = Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/boss.png"));
	// Load explosion image
	public static Image explodeImg = Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/explode/e6.gif"));
	// Load our plane image
	public static Image planeImg = Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/plane.png"));
	// Load our plane bullet image
	public static Image shellImg = Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/shell.png"));
	// Load enemy small plane image
	public static Image enemy1Img = Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/enemy1.png"));
	// Load enemy big plane image
	public static Image enemy2Img = Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/enemy2.png"));
	// Load enemy big plane bullet image
	public static Image enemy2BulletImg = Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/enemy2bullet.png"));


	public static Image littleboss1Img= Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/littleboss1.png"));
	public static Image littleboss2Img= Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/littleboss2.png"));
	public static Image littleBoss1BulletImg= Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/littleboss1bullet.png"));
	public static Image littleBoss2BulletImg= Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/littleboss2bullet.png"));
	public static Image giftImg= Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/gift.png"));

	public static Image doubleShellImg= Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/doubleshell.png"));

	public static Image tripleShellImg= Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/tripleshell.png"));

	public static Image bossBulletImg= Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/bossbullet.png"));

	public static Image warningImg= Toolkit.getDefaultToolkit().createImage(GameUtils.class.getResource("/imgs/warning.gif"));


	//All commented lists are consolidated to this master list at runtime.
	public static SortedMap<GameObjType, List<GameObj>> masterList = new TreeMap<>();

//	// Create a collection for our plane bullets
//	public static List<ShellObj> shellObjList = new ArrayList<>();
//
//
//
//	// Create a collection for enemy small planes
//	public static List<Enemy1Obj> enemy1ObjList = new ArrayList<>();
//	// Create a collection for enemy big planes
//	public static List<Enemy2Obj> enemy2ObjList = new ArrayList<>();
//	// Collection for all elements
//	//public static List<GameObj> gameObjList = new ArrayList<>();
//	// Collection for enemy big plane bullets
//	public static List<Enemy2BulletObj> enemy2BulletObjList = new ArrayList<>();
//	// Collection to remove elements from the game window
//	//public static List<GameObj> removeList = new ArrayList<>();
//
//
//
//
//	public static List<LittleBoss1Bullet> littleBoss1BulletList=new ArrayList<>();
//
//	public static List<LittleBoss2Bullet> littleBoss2BulletList=new ArrayList<>();
//
//	// Collection for explosions
//	public static List<ExplodeObj> explodeObjList = new ArrayList<>();
//
//	public static List<GiftObj> giftObjList=new ArrayList<>();
//
//	public static List<DoubleShellObj> doubleShellObjList=new ArrayList<>();
//
//	public static List<TripleShellObj> tripleShellObjList=new ArrayList<>();
//
//	public static List<BossBullet> bossBulletList=new ArrayList<>();

	public static void drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
		gImage.setColor(color);

		gImage.drawString(str,x,y);
	}

}
