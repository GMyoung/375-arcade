package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj {
	public PlaneObj() {
		super();
	}
	public static int times=1;

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
		for (Enemy1Obj enemy1Obj : GameUtils.enemy1ObjList) {
			if (this.getRec().intersects(enemy1Obj.getRec())) {
				// Explosion animation appears after collision
				explode(enemy1Obj);
			}
		}
		// Both disappear after collision between our plane and enemy big planes
		for (Enemy2Obj enemy2Obj : GameUtils.enemy2ObjList) {
			if (this.getRec().intersects(enemy2Obj.getRec())) {
				// Explosion animation appears after collision
				explode(enemy2Obj);
			}
		}
		// Both disappear after collision between our plane and enemy big plane bullets
		for (Enemy2BulletObj enemy2BulletObj : GameUtils.enemy2BulletObjList) {
			if (this.getRec().intersects(enemy2BulletObj.getRec())) {
				// Explosion animation appears after collision
				explode(enemy2BulletObj);
			}
		}
		if(this.getRec().intersects(littleBoss1.getRec())){

			ExplodeObj explodeObj=new ExplodeObj(x,y);
			GameUtils.explodeObjList.add(explodeObj);
			GameUtils.removeList.add(explodeObj);
			this.x=-200;
			this.y=-200;
			GameUtils.removeList.add(this);
			GameWin.state=3;
		}

		if(this.getRec().intersects(littleBoss2.getRec())){
			//绘制爆炸
			ExplodeObj explodeObj=new ExplodeObj(x,y);
			GameUtils.explodeObjList.add(explodeObj);
			GameUtils.removeList.add(explodeObj);
			this.x=-200;
			this.y=-200;
			GameUtils.removeList.add(this);
			GameWin.state=3;
		}

		for (LittleBoss1Bullet littleBoss1Bullet:GameUtils.littleBoss1BulletList) {
			if(this.getRec().intersects(littleBoss1Bullet.getRec())){

				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				littleBoss1Bullet.setX(-100);
				littleBoss1Bullet.setY(-100);
				GameUtils.removeList.add(littleBoss1Bullet);
				this.x=-200;
				this.y=-200;
				GameUtils.removeList.add(this);
				GameWin.state=3;
			}
		}

		for (LittleBoss2Bullet littleBoss2Bullet:GameUtils.littleBoss2BulletList) {
			if(this.getRec().intersects(littleBoss2Bullet.getRec())){

				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				littleBoss2Bullet.setX(-100);
				littleBoss2Bullet.setY(-100);
				GameUtils.removeList.add(littleBoss2Bullet);
				this.x=-200;
				this.y=-200;
				GameUtils.removeList.add(this);
				GameWin.state=3;
			}
		}

		for (GiftObj giftObj: GameUtils.giftObjList) {
			if(this.getRec().intersects(giftObj.getRec())){
				giftObj.setX(-100);
				giftObj.setY(-100);
				GameUtils.removeList.add(giftObj);
				times++;
			}
		}

		for(BossBullet bossBullet:GameUtils.bossBulletList){
			if(this.getRec().intersects(bossBullet.getRec())){
				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				bossBullet.setX(-100);
				bossBullet.setY(-100);
				this.x=-200;
				this.y=-200;
				GameUtils.removeList.add(bossBullet);
				GameUtils.removeList.add(this);
				GameWin.state=3;
			}
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
