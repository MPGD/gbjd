package com.mygame.td.towers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygame.td.game.GameActor;
import com.mygame.td.game.GameStage;
import com.mygame.td.orcs.Orc;

public abstract class Bullet extends GameActor{
	protected Actor target = null;
	protected Sprite bullet = null;
	
	public Bullet(){
		setType(ACTOR_BULLET);
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		bullet.setPosition(getX(), getY());
		bullet.draw(batch, parentAlpha);
	}
}
