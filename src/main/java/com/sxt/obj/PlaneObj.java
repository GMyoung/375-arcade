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
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
