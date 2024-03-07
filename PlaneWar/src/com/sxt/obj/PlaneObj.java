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
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				enemy1Obj.setX(-100);
				enemy1Obj.setY(-100);
				this.x = -200;
				this.y = -200;
				GameUtils.removeList.add(enemy1Obj);
				GameUtils.removeList.add(this);
			}
		}
		// Both disappear after collision between our plane and enemy big planes
		for (Enemy2Obj enemy2Obj : GameUtils.enemy2ObjList) {
			if (this.getRec().intersects(enemy2Obj.getRec())) {
				// Explosion animation appears after collision
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				enemy2Obj.setX(-100);
				enemy2Obj.setY(-100);
				this.x = -200;
				this.y = -200;
				GameUtils.removeList.add(enemy2Obj);
				GameUtils.removeList.add(this);
			}
		}
		// Both disappear after collision between our plane and enemy big plane bullets
		for (Enemy2BulletObj enemy2BulletObj : GameUtils.enemy2BulletObjList) {
			if (this.getRec().intersects(enemy2BulletObj.getRec())) {
				// Explosion animation appears after collision
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				enemy2BulletObj.setX(-100);
				enemy2BulletObj.setY(-100);
				this.x = -200;
				this.y = -200;
				GameUtils.removeList.add(enemy2BulletObj);
				GameUtils.removeList.add(this);
			}
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
