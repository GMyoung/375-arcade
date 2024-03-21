package com.sxt.obj;

import java.awt.*;

public class ExplodeObj extends GameObj{
	// Define a static array of type Image to store a series of explosion images
	static Image[] explodePic = new Image[16];
	// Define a variable to record the count of explosion images
	int explodeCount = 0;
	// Define a static block to load the explosion images into the array
	static {
		for (int i = 0; i < explodePic.length; i++) {
			explodePic[i] = Toolkit.getDefaultToolkit().getImage("imgs/explode/e" + (i + 1) + ".gif");
		}
	}


	@Override
	public void paintSelf(Graphics g) {
		if(explodeCount<16){
			super.img=explodePic[explodeCount];
			super.paintSelf(g);
			explodeCount++;
		}

	}

	public ExplodeObj(int x, int y) {
		super(x, y);
	}
}
