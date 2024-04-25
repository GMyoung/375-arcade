package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameObjType;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class LittleBoss2Bullet extends GameObj{
	int health=2;
	public LittleBoss2Bullet() {
		super();
	}

	public LittleBoss2Bullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public LittleBoss2Bullet(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public LittleBoss2Bullet(int x, int y) {
		super(x, y);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		this.y+=speed;
		this.x-=(this.x-GameUtils.masterList.get(GameObjType.PLANEOBJ).get(GameWin.planeindex).getX())/60;
		checkBulletHitByType();
		if(this.y>800){
			GameUtils.masterList.get(GameObjType.LITTLEBOSS2BULLET).remove(this);
		}
	}

	@Override
	public void damage(Integer dmg, GameObj bullet) {
		health -= dmg;
		if (health <= 0) {
			//No gifts from bullets
			explode(bullet);
		}
	}
	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
