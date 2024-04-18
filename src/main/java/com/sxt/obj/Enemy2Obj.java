package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameObjType;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class Enemy2Obj extends GameObj{
	int health=3;
	public Enemy2Obj() {
		super();
	}

	public Enemy2Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public Enemy2Obj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y+=speed;
		checkBulletHitByType();
		if(this.y>800){
			GameUtils.masterList.get(GameObjType.ENEMY2).remove(this);
		}
	}

	@Override
	public void damage(Integer dmg, GameObj bullet) {
		health -= dmg;
		if (health <= 0) {
			//No gifts!
			explode(bullet);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
