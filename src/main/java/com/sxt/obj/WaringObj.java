package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

public class WaringObj extends GameObj{
	public WaringObj() {
		super();
	}

	public WaringObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public WaringObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public WaringObj(int x, int y) {
		super(x, y);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
	}
}
