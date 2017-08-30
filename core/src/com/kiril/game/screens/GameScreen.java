package com.kiril.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.kiril.game.entities.Disk;
import com.kiril.game.stackit.MainGame;

public class GameScreen implements Screen{

	//objects
	MainGame game;
	
	//textures
	Texture background;
	
	//disks lists
	ArrayList<Disk> disks;
	
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
	
	private void buttons(){
		float touchX = game.cam.getInputInGameWorld().x;
		//reversing the getY 
		float touchY = MainGame.HEIGHT - game.cam.getInputInGameWorld().y;
		
		for(Disk disk : disks){
			
				
				if(touchX >= disk.getX() && touchX < disk.getX() + disk.getWIDTH() && touchY >= disk.getY() && touchY <= disk.getY() + disk.getHEIGHT()){
					if(Gdx.input.isTouched()){
					disk.setX(touchX - disk.getWIDTH() / 2);
					disk.setY(touchY - disk.getHEIGHT() / 2);
					System.out.println("is Touching");
				}
			
				
			}
		}
	}

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
	
	

}
