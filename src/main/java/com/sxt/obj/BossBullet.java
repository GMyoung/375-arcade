package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameObjType;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class BossBullet extends GameObj{
	public BossBullet() {
		super();
	}

	public BossBullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public BossBullet(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public BossBullet(int x, int y) {
		super(x, y);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y+=speed;
		if(this.y>800){
			GameUtils.masterList.get(GameObjType.BOSSBULLET).remove(this);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}

	@Override
	public void damage(Integer dmg, GameObj bullet) {
		//Don't care about damage, rmeove them
		this.explode(bullet);
		GameUtils.masterList.get(GameObjType.BOSSBULLET).remove(this);
	}
}
