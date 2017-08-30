package com.kiril.game.stackit;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kiril.game.screens.MainMenuScreen;
import com.kiril.game.tools.GameCamera;

public class MainGame extends Game {
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static boolean IS_MOBILE = false;
	
	public SpriteBatch batch;
	public GameCamera cam;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		cam = new GameCamera(WIDTH, HEIGHT);
		
		this.setScreen(new MainMenuScreen(this));
		
		//checks if the game is opened on mobile
		if(Gdx.app.getType() == ApplicationType.Android || Gdx.app.getType() == ApplicationType.iOS){
			IS_MOBILE = true;
		}
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(cam.combined());
		
		super.render();
	}
	
	@Override
	public void resize(int width, int height) {
		cam.update(width, height);
		super.resize(width, height);
	}
	
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
