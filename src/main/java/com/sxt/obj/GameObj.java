package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

// Parent class for all game elements
public abstract class GameObj {
	// Image of the element
	Image img;
	// Size of the game element
	int width;
	int height;
	// Position of the game element
	int x;
	int y;
	// Speed of the element's movement
	double speed;
	// Window class
	GameWin frame;

	// Getter and setter methods
	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public GameWin getFrame() {
		return frame;
	}

	public void setFrame(GameWin frame) {
		this.frame = frame;
	}
	// Constructor method
	public GameObj() {
	}

	public GameObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		this.img = img;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.frame = frame;
	}

	public GameObj(Image img, int x, int y, double speed) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	public GameObj(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Method to draw the element itself
	public void paintSelf(Graphics g){
		g.drawImage(img,x,y,null);
	}
	// Method to get its own rectangle, used for collision detection
	public Rectangle getRec(){
		return new Rectangle(x, y, width, height);
	}

	//Removal of duplication
	public void explode(GameObj intersectingObject) {
		// Explosion animation appears after collision
		ExplodeObj explodeObj = new ExplodeObj(x, y);
		GameUtils.explodeObjList.add(explodeObj);
		GameUtils.removeList.add(explodeObj);
		intersectingObject.setX(-100);
		intersectingObject.setY(-100);
		this.x = -200;
		this.y = -200;
		GameUtils.removeList.add(intersectingObject);
		GameUtils.removeList.add(this);
		GameWin.score+=1;
	}

	public void handleShellCollision(ShellObj obj) {
		obj.setX(-100);
		obj.setX(-100);
		GameUtils.removeList.add(obj);
	}

}
