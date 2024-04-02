package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class LittleBoss1 extends GameObj{
	int health=10;
	public LittleBoss1() {
		super();
	}

	public LittleBoss1(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public LittleBoss1(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public LittleBoss1(int x, int y) {
		super(x, y);
	}
// there is some nasty code here, they are the same structure as other duplicated codes.
	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		x+=speed;
		if(x>400){
			speed=-1;
		}
		for(ShellObj shellObj: GameUtils.shellObjList){
			if(this.getRec().intersects(shellObj.getRec())&&health>0){
				handleShellCollision(shellObj);
				health--;
			} else if (this.getRec().intersects(shellObj.getRec())&&health<=0) {
				GiftObj giftObj=new GiftObj(this.x,this.y);
				GameUtils.giftObjList.add(giftObj);
				GameUtils.gameObjList.addAll(GameUtils.giftObjList);
				explode(shellObj);
			}
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
