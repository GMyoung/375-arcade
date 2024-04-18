package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameObjType;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class LittleBoss2 extends GameObj{
	int health=10;
	public LittleBoss2() {
		super();
	}

	public LittleBoss2(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public LittleBoss2(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public LittleBoss2(int x, int y) {
		super(x, y);
	}
// some other nasty code
	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		if(y<150){
			y+=2;
		}else{
			x+=speed;
			if(x>400||x<10){
				speed=-speed;
			}
		}
		checkBulletHitByType();
	}

	public void damage(Integer dmg, GameObj bullet) {
		health -= dmg;
		if (health <= 0) {
			GiftObj giftObj=new GiftObj(this.x,this.y);
			GameUtils.masterList.get(GameObjType.GIFT).add(giftObj);
	//		GameUtils.masterList.get(GameObjType.GIFT).addAll(GameUtils.giftObjList);
			explode(bullet);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
