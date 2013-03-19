package com.mygame.td.towers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygame.td.game.GameActor;
import com.mygame.td.game.GameStage;

public abstract class Tower extends GameActor{
	
	protected TextureRegion tower = null;
	
	protected float attackTime;//攻击间隔
	protected float attackArea;//攻击范围
	private float lastAttackTime = 0;//距离上次攻击的间隔
	
	public Tower(){
		setType(ACTOR_TOWER);
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		float delta = ((GameStage) getStage()).getTime();
		batch.draw(tower, getX(), getY());
	}
	
	public void setLastAttackTime(float time){
		lastAttackTime = time;
	}
	
	public float getLastAttackTime(){
		return lastAttackTime;
	}
	
	
}
