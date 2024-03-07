package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

public class ShellObj extends GameObj{
	public ShellObj() {
		super();
	}

	public ShellObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public ShellObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		//move bullets
		y -= speed;
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
