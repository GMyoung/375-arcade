package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameObjType;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class Enemy1Obj extends GameObj{
	private int health = 1;
	public Enemy1Obj() {
		super();
	}

	public Enemy1Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public Enemy1Obj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y+=speed;
		if(this.y>800){
			GameUtils.masterList.get(GameObjType.ENEMY1).remove(this);
		}
		checkBulletHitByType();

	}

	@Override
	public void damage(Integer dmg, GameObj bullet) {
		health -= dmg;
		if (health <= 0) {
			//no gifts!
			explode(bullet);
			GameUtils.masterList.get(GameObjType.ENEMY1).remove(this);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
