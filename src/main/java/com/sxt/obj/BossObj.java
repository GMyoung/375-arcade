package com.sxt.obj;


import com.sxt.GameWin;
import com.sxt.utils.GameObjType;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class BossObj extends GameObj{
	int health=30;
	public BossObj() {
		super();
	}

	public BossObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public BossObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public BossObj(int x, int y) {
		super(x, y);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		if(y<40){
			y+=speed;
		}else {
			x+=speed;
			if(x<0||x>360){
				speed=-speed;
			}
		}

		checkBulletHitByType();

		g.setColor(Color.WHITE);
		g.fillRect(200,40,200,10);

		g.setColor(Color.RED);
		g.fillRect(200,40,health*200/30,10);
	}

	@Override
	public void damage(Integer dmg, GameObj bullet) {
		health--; //ignore dmg for boss
		if (health <= 0) {
			explode(bullet);
			GameUtils.masterList.get(GameObjType.BOSS).remove(this);
			GameWin.state=4;
			GameWin.score+=10;
		}
	}


	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
