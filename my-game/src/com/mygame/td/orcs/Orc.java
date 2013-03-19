package com.mygame.td.orcs;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygame.td.game.GameStage;

public abstract class Orc extends Actor {
	
	public static int Direction_LEFT = 0;
	public static int Direction_RIGHT = 1;
	public static int Direction_UP = 2;
	public static int Direction_DOWN = 3;
	
	public Animation animationUp = null;
	public Animation animationDown = null;
	public Animation animationLeft = null;
	public Animation animationRight = null;
	
	private Animation animation = null;
	
	private float hp;
	//移动速度要么是X轴，要么是Y轴，暂时没有考虑同时移动
	public float moveSpeed = 1f;

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		float delta = ((GameStage) getStage()).getTime();
		Sprite sprite = (Sprite)animation.getKeyFrame(delta, true);
		sprite.setPosition(getX(), getY());
		sprite.draw(batch, parentAlpha);
	}

	public void setAnimation(Animation animationUp, Animation animationDown, Animation animationLeft, Animation animationRight) {
		this.animationUp = animationUp;
		this.animationDown = animationDown;
		this.animationLeft = animationLeft;
		this.animationRight = animationRight;
		
		//默认朝右
		animation = animationRight;
	}

	public void setAnimation(Animation ani){
		animation = ani;
	}
	
	public void setHp(float hp) {
		this.hp = hp;
	}

}
