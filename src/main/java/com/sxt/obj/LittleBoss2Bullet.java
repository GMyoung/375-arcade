package com.sxt.obj;

import com.sxt.GameWin;
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
		this.x-=(this.x-GameUtils.gameObjList.get(GameWin.planeindex).getX())/30;

		for(ShellObj shellObj: GameUtils.shellObjList){
			if(this.getRec().intersects(shellObj.getRec())&&health>0){
				handleShellCollision(shellObj);
				health--;
			} else if (this.getRec().intersects(shellObj.getRec())&&health<=0) {
				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				handleShellCollision(shellObj);
				this.x=-200;
				this.y=-200;
				GameUtils.removeList.add(this);
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
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
