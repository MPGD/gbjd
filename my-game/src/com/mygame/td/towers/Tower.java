package com.mygame.td.towers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygame.td.game.GameStage;

public abstract class Tower extends Actor{
	
	protected TextureRegion tower = null;
	protected float attachTime;
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		float delta = ((GameStage) getStage()).getTime();
		batch.draw(tower, getX(), getY());
	}
}
