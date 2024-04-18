package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameObjType;
import com.sxt.utils.GameUtils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj {
	public PlaneObj() {
		super();
	}
	public static int times=0;

	LittleBoss1 littleBoss1=new LittleBoss1();
	LittleBoss2 littleBoss2=new LittleBoss2();

	public PlaneObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
		// Add mouse movement event
		this.frame.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				PlaneObj.super.x = e.getX() - 19;
				PlaneObj.super.y = e.getY() - 20;
			}
		});
	}

	public PlaneObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		// Perform collision detection
		// After collision between our plane and enemy small planes, both disappear
		for (GameObj enemy1Obj : GameUtils.masterList.get(GameObjType.ENEMY1)) {
			if (this.getRec().intersects(enemy1Obj.getRec())) {
				// Explosion animation appears after collision
				explode(enemy1Obj);
				GameWin.state=3;
			}
		}
		// Both disappear after collision between our plane and enemy big planes
		for (GameObj enemy2Obj : GameUtils.masterList.get(GameObjType.ENEMY2)) {
			if (this.getRec().intersects(enemy2Obj.getRec())) {
				// Explosion animation appears after collision
				explode(enemy2Obj);
				GameWin.state=3;
			}
		}
		// Both disappear after collision between our plane and enemy big plane bullets
		for (GameObj enemy2BulletObj : GameUtils.masterList.get(GameObjType.ENEMY2BULLETOBJECT)) {
			if (this.getRec().intersects(enemy2BulletObj.getRec())) {
				// Explosion animation appears after collision
				explode(enemy2BulletObj);
				GameWin.state=3;
			}
		}
		if(this.getRec().intersects(littleBoss1.getRec())){

//			ExplodeObj explodeObj=new ExplodeObj(x,y);
//			GameUtils.explodeObjList.add(explodeObj);
//			GameUtils.removeList.add(explodeObj);
//			this.x=-200;
//			this.y=-200;
//			GameUtils.removeList.add(this);
			explode(null);
			GameWin.state=3;
		}

		if(this.getRec().intersects(littleBoss2.getRec())){
			//绘制爆炸
//			ExplodeObj explodeObj=new ExplodeObj(x,y);
//			GameUtils.explodeObjList.add(explodeObj);
//			GameUtils.removeList.add(explodeObj);
//			this.x=-200;
//			this.y=-200;
//			GameUtils.removeList.add(this);
			explode(null);
			GameWin.state=3;
		}

		for (GameObj littleBoss1Bullet:GameUtils.masterList.get(GameObjType.LITTLEBOSS1BULLET)) {
			if(this.getRec().intersects(littleBoss1Bullet.getRec())){

				explode(littleBoss1Bullet);
				GameWin.state=3;
			}
		}

		for (GameObj littleBoss2Bullet:GameUtils.masterList.get(GameObjType.LITTLEBOSS2BULLET)) {
			if(this.getRec().intersects(littleBoss2Bullet.getRec())){

				explode(littleBoss2Bullet);
				GameWin.state=3;
			}
		}

		for (GameObj giftObj: GameUtils.masterList.get(GameObjType.GIFT)) {
			if(this.getRec().intersects(giftObj.getRec())){
				giftObj.setX(-100);
				giftObj.setY(-100);
				GameUtils.masterList.get(GameObjType.GIFT).remove(giftObj);
				times++;
			}
		}

		for(GameObj bossBullet:GameUtils.masterList.get(GameObjType.BOSSBULLET)){
			if(this.getRec().intersects(bossBullet.getRec())){
				explode(bossBullet);
				GameWin.state=3;
			}
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
