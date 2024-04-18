package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameObjType;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class TripleShellObj extends GameObj{
	public TripleShellObj() {
		super();
	}

	public TripleShellObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public TripleShellObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public TripleShellObj(int x, int y) {
		super(x, y);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y-=speed;
		if(y<0){
			GameUtils.masterList.get(GameObjType.TRIPLESHELLOBJ).remove(this);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
