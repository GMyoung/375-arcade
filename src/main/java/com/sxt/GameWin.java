package com.sxt;

import com.sxt.obj.*;
import com.sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
	// Variable to record game state
	// 0 not started, 1 in game, 2 paused, 3 failed, 4 cleared
	public static int state = 0;
	// Background image object
	BgObj bgObj = new BgObj(GameUtils.bdImg, 0, -1800, 2);
	// Define an image variable
	Image offScreenImage = null;
	// Object of our plane
	PlaneObj planeObj = new PlaneObj(GameUtils.planeImg, 37, 41, 290, 550, 0, this);
	// Object for our bullets
	// ShellObj shellObj=new ShellObj(GameUtils.shellImg,14,29,planeObj.getX(), planeObj.getY(), 5,this);
	// Variable to record the number of game draws
	int count=1;

	LittleBoss1 littleBoss1=new LittleBoss1(GameUtils.littleboss1Img,172,112,-200,350,3,this);

	LittleBoss2 littleBoss2=new LittleBoss2(GameUtils.littleboss2Img,172,112,300,-150,2,this);

	BossObj bossObj=new BossObj(GameUtils.bossImg,240,174,180,-180,3,this);

	WaringObj waringObj=new WaringObj(GameUtils.warningImg,599,90,0,350,0,this);

	public static int planeindex=0;

	public static int score=0;

	public void launch() {
		// Window visibility
		this.setVisible(true);
		// Window size
		this.setSize(600, 800);
		// Window position
		this.setLocationRelativeTo(null);
		// Window title
		this.setTitle("Air Combat");
		// Closing window ends process
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add all objects to be drawn to the collection for drawing
		GameUtils.gameObjList.add(bgObj);
		GameUtils.gameObjList.add(planeObj);
		planeindex=GameUtils.gameObjList.indexOf(planeObj);

		// Mouse click event
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1 && state == 0) { // React only when the game is not started and left click is pressed
					state = 1; // Start game state
				}
			}
		});

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==32){
					if(state==1){
						state=2;
					} else if (state==2) {
						state=1;
					}
				}
			}
		});
		while (true) {
			createObj();
			repaint();
			try {
				Thread.sleep(25); // 25 milliseconds
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void paint(Graphics g) {
		// Initialize off-screen image object
		if (offScreenImage == null) {
			offScreenImage = createImage(600, 800); // Size must be the same as the game window
		}
		// Get the graphics of the off-screen image
		Graphics gImage = offScreenImage.getGraphics();
		gImage.fillRect(0, 0, 600, 800);

		if (state == 0) {
			gImage.drawImage(GameUtils.bdImg, 0, 0, null);
			gImage.drawImage(GameUtils.explodeImg, 270, 350, null);
			gImage.drawImage(GameUtils.planeImg, 280, 470, null);
			gImage.drawImage(GameUtils.bossImg, 190, 70, null);
			// Draw the game start screen text
			gImage.setColor(Color.BLUE);
			gImage.drawString("Left-click to start game", 180, 300);
		}
		if (state == 1) {

			// Add explosion collection to the general elements collection
			GameUtils.gameObjList.addAll(GameUtils.explodeObjList);

			// No longer drawing a single game element, all elements are in the collection, just iterate through and draw
			for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
				GameUtils.gameObjList.get(i).paintSelf(gImage);
			}
			// Remove elements from the general collection
			GameUtils.gameObjList.removeAll(GameUtils.removeList);
			count++;
		}
		if(state==2){
			gImage.drawImage(GameUtils.bdImg,0,0,null);
			GameUtils.drawWord(gImage,"game pause",Color.YELLOW,30,220,300);
		}
		if(state==3){
			gImage.drawImage(GameUtils.bdImg,0,0,null);
			GameUtils.drawWord(gImage,"mission failed",Color.RED,30,220,300);
		}
		if(state==4){
			gImage.drawImage(GameUtils.bdImg,0,0,null);
			GameUtils.drawWord(gImage,"mission success",Color.GREEN,30,220,300);
		}

		GameUtils.drawWord(gImage,score+"score",Color.green,40,30,100);
		// Draw the off-screen image onto the game window
		g.drawImage(offScreenImage, 0, 0, null);

		System.out.println(GameUtils.gameObjList.size());

	}

	// This method is used to create objects in batches
	void createObj() {
		if (count % 15 == 0) { // Controls the speed of bullet generation
			if (planeObj.times == 0) {
				GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, 14, 29, planeObj.getX() + 12, planeObj.getY() - 20, 5, this));
				GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));//添加到所有元素集合中的对象，是新new出来的子弹对象，并不是整个子弹集合
			}
			if(planeObj.times==1){
				GameUtils.doubleShellObjList.add(new DoubleShellObj(GameUtils.doubleShellImg,32,64,planeObj.getX()+5,planeObj.getY()-20,8,this));
				GameUtils.gameObjList.add(GameUtils.doubleShellObjList.get(GameUtils.doubleShellObjList.size()-1));
			}
			if(planeObj.times==2){
				GameUtils.tripleShellObjList.add(new TripleShellObj(GameUtils.tripleShellImg,64,182,planeObj.getX()-5,planeObj.getY()-100,15,this));
				GameUtils.gameObjList.add(GameUtils.tripleShellObjList.get(GameUtils.tripleShellObjList.size()-1));
			}
		}
		// Two types of enemy planes
		if (count % 15 == 0) { // Control the generation speed of small enemy planes
			GameUtils.enemy1ObjList.add(new Enemy1Obj(GameUtils.enemy1Img, 32, 24, (int) ((Math.random() * 10) * 60), 0, 5, this));
			GameUtils.gameObjList.add(GameUtils.enemy1ObjList.get(GameUtils.enemy1ObjList.size() - 1));
		}
		if(count % 20 == 0) { // Control the rate of big enemy plane bullets
			if (count % 100 == 0) {
				GameUtils.enemy2ObjList.add(new Enemy2Obj(GameUtils.enemy2Img, 44, 67, (int) ((Math.random() * 10) * 60), 0, 3, this));
				GameUtils.gameObjList.add(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size() - 1));
			}
			if(GameUtils.enemy2ObjList.size() > 0){
				// The x and y here are the positions of the latest big enemy plane object created; we need to use this position to generate bullets for the big enemy plane
				int x = (GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size()-1)).getX();
				int y = (GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size()-1)).getY();
				GameUtils.enemy2BulletObjList.add(new Enemy2BulletObj(GameUtils.enemy2BulletImg, 14, 25, x+17, y+55, 5, this));
				GameUtils.gameObjList.add(GameUtils.enemy2BulletObjList.get(GameUtils.enemy2BulletObjList.size()-1));
			}
		}
		if(count==600&&(!GameUtils.gameObjList.contains(littleBoss2))){
			GameUtils.gameObjList.add(littleBoss2);
		}
		if(count==700&&(!GameUtils.gameObjList.contains(littleBoss1))){
			GameUtils.gameObjList.add(littleBoss1);
		}
		if(count%15==0) {
			if (GameUtils.gameObjList.contains(littleBoss1)) {
				GameUtils.littleBoss1BulletList.add(new LittleBoss1Bullet(GameUtils.littleBoss1BulletImg, 42, 42, littleBoss1.getX() + 75, littleBoss1.getY() + 100, 4, this));
				GameUtils.gameObjList.add(GameUtils.littleBoss1BulletList.get(GameUtils.littleBoss1BulletList.size() - 1));
			}
		}
		if(count%40==0){
			if(GameUtils.gameObjList.contains(littleBoss2)){
				GameUtils.littleBoss2BulletList.add(new LittleBoss2Bullet(GameUtils.littleBoss2BulletImg,21,59,littleBoss2.getX()+78,littleBoss2.getY()+100,8,this));
				GameUtils.gameObjList.add(GameUtils.littleBoss2BulletList.get(GameUtils.littleBoss2BulletList.size()-1));
			}
		}
		if(count==1300&&(!GameUtils.gameObjList.contains(bossObj))){
			GameUtils.gameObjList.add(bossObj);
		}

		if(count%20==0) {
			if (GameUtils.gameObjList.contains(bossObj)) {
				GameUtils.littleBoss1BulletList.add(new LittleBoss1Bullet(GameUtils.littleBoss1BulletImg, 42, 42, bossObj.getX() + 10, bossObj.getY() + 130, 6, this));
				GameUtils.gameObjList.add(GameUtils.littleBoss1BulletList.get(GameUtils.littleBoss1BulletList.size() - 1));
				if (count % 40 == 0) {
					GameUtils.littleBoss2BulletList.add(new LittleBoss2Bullet(GameUtils.littleBoss2BulletImg, 21, 59, bossObj.getX() + 220, bossObj.getY() + 130, 10, this));
					GameUtils.gameObjList.add(GameUtils.littleBoss2BulletList.get(GameUtils.littleBoss2BulletList.size() - 1));
				}
				GameUtils.bossBulletList.add(new BossBullet(GameUtils.bossBulletImg, 51, 72, bossObj.getX() + 70, bossObj.getY() + 100, 9, this));
				GameUtils.gameObjList.add(GameUtils.bossBulletList.get(GameUtils.bossBulletList.size() - 1));
			}
		}
		if(count==1250&&(!GameUtils.gameObjList.contains(waringObj))){
			GameUtils.gameObjList.add(waringObj);
		}
		if(count==1290){
			GameUtils.removeList.add(waringObj);
		}
	}

	public static void main(String[] args) {
		GameWin gameWin = new GameWin();
		gameWin.launch();
	}
}
