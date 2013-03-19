package com.mygame.td.towers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygame.td.orcs.Orc;

public class ArrowBullet extends Bullet{
	public static String ARROW_BULLET_IMG_SRC = "data/test2.png";
	
	public ArrowBullet(Actor target){
		super();
		// 加载纹理
		Texture temp = new Texture(ARROW_BULLET_IMG_SRC);
		// 加载关键帧动画
		TextureRegion b = new TextureRegion(temp).split(64, 128)[0][0];
		bullet = new Sprite(b);
		this.target = target;
		
		Gdx.app.debug("xujihao", String.format("x = %f, y = %f", target.getX(), target.getY()));
		addAction(Actions.moveTo(target.getX(), target.getY(), 0.5f));
	}
}
