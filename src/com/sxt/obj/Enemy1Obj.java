package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class Enemy1Obj extends GameObj{
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
		for (ShellObj shellObj: GameUtils.shellObjList) {
			if(this.getRec().intersects(shellObj.getRec())){
				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);

				shellObj.setX(-100);
				shellObj.setY(-100);
				this.setX(-100);
				this.setY(-100);
				GameUtils.removeList.add(shellObj);
				GameUtils.removeList.add(this);
			}
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
