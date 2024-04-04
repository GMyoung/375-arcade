package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class GiftObj extends GameObj{
	public GiftObj() {
		super();
	}

	public GiftObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public GiftObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public GiftObj(int x, int y) {
		super(x, y);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.img= GameUtils.giftImg;
		super.width=64;
		super.height=62;
		super.paintSelf(g);
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
