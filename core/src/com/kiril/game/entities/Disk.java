package com.kiril.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kiril.game.screens.GameScreen;
import com.kiril.game.tools.CollisionRect;


public class Disk {

	//coordinates
	float x, y;
	
	//size
	int WIDTH, HEIGHT;
	
	//type
	int diskIndex;
	
	//texture
	Texture disk;

	//objects
	GameScreen gameScreen;
	CollisionRect rect;
	
	public Disk(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		
		
		HEIGHT = 25;
		
		if(gameScreen.getDisks().isEmpty()){
			diskIndex = 1;
			WIDTH = 160;
			x = 420;
			y = 330;
		}
		if(gameScreen.getDisks().size() == 1){
			diskIndex = 2;
			WIDTH = 140;
			x = 430;
			y = 355;
		}
		if(gameScreen.getDisks().size() == 2){
			diskIndex = 3;
			WIDTH = 120;
			x = 440;
			y = 380;
		}
		if(gameScreen.getDisks().size() == 3){
			diskIndex = 4;
			WIDTH = 100;
			x = 450;
			y = 405;
		}
		if(gameScreen.getDisks().size() == 4){
			diskIndex = 5;
			WIDTH = 80;
			x = 460;
			y = 430;
		}
		if(gameScreen.getDisks().size() == 5){
			diskIndex = 6;
			WIDTH = 60;
			x = 470;
			y = 455;
		}
		if(gameScreen.getDisks().size() == 6){
			diskIndex = 7;
			WIDTH = 40;
			x = 480;
			y = 480;
		}
		if(gameScreen.getDisks().size() == 7){
			diskIndex = 8;
			WIDTH = 20;
			HEIGHT = 15;
			x = 490;
			y = 505;
		}
		
		this.rect = new CollisionRect(x, x, WIDTH, HEIGHT);
		
		disk = new Texture("disk.png");
	}
	
	public void update(float delta){
		
		//updating the collision rect
		rect.move(x, y);
	}
	
	public void render(SpriteBatch batch){
		batch.draw(disk, x, y, WIDTH, HEIGHT);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public float getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}


	
	public int getDiskIndex() {
		return diskIndex;
	}

	public void setDiskIndex(int diskIndex) {
		this.diskIndex = diskIndex;
	}

	public void dispose(){
		disk.dispose();
	}
	
	

}
