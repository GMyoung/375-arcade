package com.sxt.obj;

import com.sxt.GameWin;
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
		for (ShellObj shellObj: GameUtils.shellObjList) {
			if(this.getRec().intersects(shellObj.getRec())&&health>0){
				handleShellCollision(shellObj);
				health--;
			}else if(this.getRec().intersects(shellObj.getRec())&&health<=0){
				explode(shellObj);
			}
		}
		for(DoubleShellObj doubleshellObj: GameUtils.doubleShellObjList){
			if(this.getRec().intersects(doubleshellObj.getRec())&&health>0){
				doubleshellObj.setX(-100);
				doubleshellObj.setY(-100);
				GameUtils.removeList.add(doubleshellObj);
				health-=3;
			} else if (this.getRec().intersects(doubleshellObj.getRec())&&health<=0) {

				explode(doubleshellObj);
				GameWin.score+=1;
			}
		}
		for(TripleShellObj tripleshellObj: GameUtils.tripleShellObjList){
			if(this.getRec().intersects(tripleshellObj.getRec())&&health>0){
				tripleshellObj.setX(-100);
				tripleshellObj.setY(-100);
				GameUtils.removeList.add(tripleshellObj);
				health-=5;
			} else if (this.getRec().intersects(tripleshellObj.getRec())&&health<=0) {

				explode(tripleshellObj);
				GameWin.score+=3;
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
