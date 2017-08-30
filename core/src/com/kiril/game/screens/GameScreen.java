package com.kiril.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.kiril.game.entities.Disk;
import com.kiril.game.stackit.MainGame;

public class GameScreen implements Screen, InputProcessor{

	//objects
	MainGame game;
	
	//textures
	Texture background;
	
	//disks lists
	ArrayList<Disk> disks;
	
	int currentDisk = 7;
	
	public GameScreen(MainGame game) {
		this.game = game;
		
		background = new Texture("gameBackground.png");
		
		//disks lists
		disks = new ArrayList<Disk>();
		
		//generate level
		levelGenerator();
	}

	public void update(float delta){
		//updating the disks
		for(Disk disk : disks){
			disk.update(delta);
		}
		
		//updating the buttons
		buttons();
	}

	@Override
	public void render(float delta) {
		
		//update
		update(delta);
		
		game.batch.begin();
		game.batch.setColor(Color.WHITE);
		
		game.batch.draw(background, 0, 0);
		
		for(Disk disk : disks){
			disk.render(game.batch);
		}
		
		game.batch.end();
	}
	
	private void levelGenerator(){
		for(int i = 0; i <= 6; i++){
			disks.add(new Disk(this));
		}
		
	}
	
	boolean isDiskTouched = false;
	
	private void buttons(){
		float touchX = game.cam.getInputInGameWorld().x;
		//reversing the getY 
		float touchY = MainGame.HEIGHT - game.cam.getInputInGameWorld().y;
		
		
		boolean changedCurrDisk = false;
		
		for(Disk disk : disks){
	
				if(touchX >= disk.getX() && touchX < disk.getX() + disk.getWIDTH() && touchY >= disk.getY() && touchY <= disk.getY() + disk.getHEIGHT() && !isDiskTouched){
					isDiskTouched = true;
				}
			if(Gdx.input.isTouched(0) && isDiskTouched && disk.getDiskIndex() == 7){
					if(touchDragged((int)disk.getX(), (int)disk.getY(), 0)){
						disk.setX(touchX);
						disk.setY(touchY);
						System.out.println("dragging");
						
					}else {isDiskTouched = false;
					System.out.println("Disk is waiting to be touched");
					}
					}
		}
			
		}
		
		//System.out.println("currenct disk on top: "+currentDisk);
	//}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Disk> getDisks() {
		return disks;
	}

	public void setDisks(ArrayList<Disk> disks) {
		this.disks = disks;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
