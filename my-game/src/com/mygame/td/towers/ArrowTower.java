package com.mygame.td.towers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class ArrowTower extends Tower {
	public static String ARROW_TOWER_IMG_SRC = "data/test2.png";
	
	public ArrowTower() {
		super();
		attackArea = 100.0f;
		attackTime = 2.0f;
		// 加载纹理
		Texture temp = new Texture(ARROW_TOWER_IMG_SRC);
		// 加载关键帧动画
		tower = new TextureRegion(temp).split(64, 128)[0][0];
		setPosition(200, 100);
		
		setSize(64, 128);
		addAction(Actions.forever(TowerActions.detect(attackArea)));
	}
}
