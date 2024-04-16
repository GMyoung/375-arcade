package com.sxt.obj;


import com.sxt.GameWin;
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

		for(ShellObj shellObj: GameUtils.shellObjList){
			if(this.getRec().intersects(shellObj.getRec())&&health>0){
				handleShellCollision(shellObj);
				health--;
			} else if (this.getRec().intersects(shellObj.getRec())&&health<=0) {

				explode(shellObj);
				GameWin.state=4;
				GameWin.score+=10;
			}
		}

		for(DoubleShellObj doubleshellObj: GameUtils.doubleShellObjList){
			if(this.getRec().intersects(doubleshellObj.getRec())&&health>0){
				doubleshellObj.setX(-100);
				doubleshellObj.setY(-100);
				GameUtils.removeList.add(doubleshellObj);
				health--;
			} else if (this.getRec().intersects(doubleshellObj.getRec())&&health<=0) {

				explode(doubleshellObj);
				GameWin.state=4;
				GameWin.score+=10;
			}
		}

		for(TripleShellObj tripleshellObj: GameUtils.tripleShellObjList){
			if(this.getRec().intersects(tripleshellObj.getRec())&&health>0){
				tripleshellObj.setX(-100);
				tripleshellObj.setY(-100);
				GameUtils.removeList.add(tripleshellObj);
				health--;
			} else if (this.getRec().intersects(tripleshellObj.getRec())&&health<=0) {

				explode(tripleshellObj);
				GameWin.state=4;
				GameWin.score+=10;
			}
		}

		g.setColor(Color.WHITE);
		g.fillRect(200,40,200,10);

		g.setColor(Color.RED);
		g.fillRect(200,40,health*200/30,10);
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
