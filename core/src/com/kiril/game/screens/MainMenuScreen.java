package com.kiril.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.Align;
import com.kiril.game.stackit.MainGame;

public class MainMenuScreen implements Screen{

	//objects
	MainGame game;
	
	//textures
	Texture background;

	//font
	BitmapFont font;
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter;
	
	//layouts
	GlyphLayout playLayout;
	GlyphLayout helpLayout;
	GlyphLayout exitLayout;
	
	//buttons coordinates
	float playX, playY, helpX, helpY, exitX, exitY;
	
	//color for the font
	Color color;
	
	//color chaning variables
	float alpha_color = 1;
	float maxRed, maxGreen, maxBlue;
	float minRed, minGreen, minBlue;
	float r, g, b;
	float speedColorR, speedColorG, speedColorB, speedColorA;
	
	public MainMenuScreen(MainGame game) {
		this.game = game;
		
		//textures
		background = new Texture("mainMenuBackground.jpg");
		
		//initialize font
		generator = new FreeTypeFontGenerator(Gdx.files.internal("font/WOODENNI.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 84;
		font = generator.generateFont(parameter);
		
		//color
		color = new Color(0.85f, 0.64f, 0.59f, 1);
	
		
		//buttons coordinates initialize
		playX = MainGame.WIDTH / 3 + 30;
		playY = MainGame.HEIGHT / 1.4f;
		helpX = MainGame.WIDTH / 3 + 80;
		helpY = playY - 120;
		exitX = MainGame.WIDTH / 3 + 120;
		exitY = helpY - 120;
		
		
		//max and min rgb colors
		r = minRed = 0.85f;
		g = minGreen = 0.63f;
		minBlue = 0.60f;
		maxRed = 1;
		maxGreen = 0.90f;
		maxBlue = minBlue;
		speedColorR = 0.3f;
		speedColorG = 0.3f;
		speedColorB = 0.3f;
		speedColorA = 0.2f;
		
	}

	public void update(float delta){
		
		//updating the rgb colors
		colorChanger(delta);
	}

	@Override
	public void render(float delta) {
		//updating everything
		update(delta);
		
		game.batch.begin();
		game.batch.setColor(Color.WHITE);
		
		game.batch.draw(background, 0, 0);
		
		game.batch.setColor(color);
		
		//layouts initialize
		playLayout = new GlyphLayout(font, "PLAY", color, 0, Align.left, false);
		helpLayout = new GlyphLayout(font, "HELP", color, 0, Align.left, false);
		exitLayout = new GlyphLayout(font, "EXIT", color, 0, Align.left, false);
		
		font.draw(game.batch, playLayout, playX, playY);
		font.draw(game.batch, helpLayout, helpX, helpY);
		font.draw(game.batch, exitLayout, exitX, exitY);
		
		buttons();
		
		game.batch.end();
		
	}
	
	private void colorChanger(float delta){
		r += delta * speedColorR;
		g += delta * speedColorG;
		
		alpha_color -= delta * speedColorA;
		
			if(r >= maxRed){
				r = maxRed;
				speedColorR *= -1;
			}
			if(r <= minRed){
				r = minRed;
				speedColorR *= -1;
			}
			if(g >= maxGreen){
				g = maxGreen;
				speedColorG *= -1;
			}
			if(g <= minGreen){
				g = minGreen;
				speedColorG *= -1;
			}
			if(alpha_color >= 1){
				alpha_color = 1;
				speedColorA *= -1;
			}
			if(alpha_color <= 0.5){
				alpha_color = 0.5f;
				speedColorA *= -1;
			}
				
			
			color = new Color(r, g, minBlue, alpha_color);
	}
	
	private void buttons(){
		float touchX = game.cam.getInputInGameWorld().x;
		//reversing the getY 
		float touchY = MainGame.HEIGHT - game.cam.getInputInGameWorld().y;
		
		//System.out.println("Y: " + touchY);
		
		
		//buttons
		if(Gdx.input.justTouched()){
		//play
		if(touchX >= playX && touchX < playX + playLayout.width && touchY > playY - playLayout.height && touchY < playY){
			game.setScreen(new GameScreen(game));
			this.dispose();
			}
		//help
		if(touchX >= helpX && touchX < helpX + helpLayout.width && touchY > helpY - helpLayout.height && touchY < helpY){
			System.out.println("Help");
			}
		//exit
		if(touchX >= exitX && touchX < exitX + exitLayout.width && touchY > exitY - exitLayout.height && touchY < exitY){
			System.out.println("Exit");
			this.dispose();
			Gdx.app.exit();
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void show() {
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
		background.dispose();
		
	}

}
