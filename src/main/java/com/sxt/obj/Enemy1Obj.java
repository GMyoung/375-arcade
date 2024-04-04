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
				explode(shellObj);
			}
		}
		for(DoubleShellObj doubleshellObj: GameUtils.doubleShellObjList){
			if(this.getRec().intersects(doubleshellObj.getRec())){
				explode(doubleshellObj);
			}
		}
		for(TripleShellObj tripleshellObj: GameUtils.tripleShellObjList){
			if(this.getRec().intersects(tripleshellObj.getRec())){
				explode(tripleshellObj);
			}
		}
		if(this.y>800){
			GameUtils.removeList.add(this);
		}

	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
