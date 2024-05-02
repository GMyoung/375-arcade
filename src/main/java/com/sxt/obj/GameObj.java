package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameObjType;
import com.sxt.utils.GameUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
		GameUtils.masterList.get(GameObjType.EXPLODEOBJ).add(explodeObj);
		if (intersectingObject != null) {
			intersectingObject.setX(-100);
			intersectingObject.setY(-100);
		}
		this.x = -200;
		this.y = -200;
		GameWin.score+=1;
	}

//	public void handleShellCollision(GameObj playerShellObj) { //This should be Our playerShellObj
//		playerShellObj.setX(-100);
//		playerShellObj.setX(-100);
//		GameUtils.masterList.get(GameObjType.Ga).add(playerShellObj);
//	}

	 	void checkBulletHitByType() {
		//Find shells for removal
		ArrayList<GameObj> shellsToRemove = new ArrayList<>();
		for(GameObj shellObj: GameUtils.masterList.get(GameObjType.SHELLOBJ)){
			if (shellObj.getRec().intersects(this.getRec())) {
				damage(1, shellObj);
				shellsToRemove.add(shellObj);
			}
		}

		ArrayList<GameObj> doubleToRemove = new ArrayList<>();
		for(GameObj doubleshellObj: GameUtils.masterList.get(GameObjType.DOUBLESHELLOBJ)){
			if (doubleshellObj.getRec().intersects(this.getRec())) {
				damage(5, doubleshellObj);
				doubleToRemove.add(doubleshellObj);
			}
		}

		ArrayList<GameObj> tripleToRemove = new ArrayList<>();
		for(GameObj tripleshellObj: GameUtils.masterList.get(GameObjType.TRIPLESHELLOBJ)){
			if (tripleshellObj.getRec().intersects(this.getRec())) {
				damage(10, tripleshellObj);
				tripleToRemove.add(tripleshellObj);
			}
		}

		//Avoids concurrent modification
		GameUtils.masterList.get(GameObjType.SHELLOBJ).removeAll(shellsToRemove);
		GameUtils.masterList.get(GameObjType.DOUBLESHELLOBJ).removeAll(doubleToRemove);
		GameUtils.masterList.get(GameObjType.TRIPLESHELLOBJ).removeAll(tripleToRemove);

	}

	public void damage(Integer dmg, GameObj bullet) {
		//FIXME Has overrides I promise. -K
	}

}
