package com.mygame.td.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Logger;
import com.mygame.td.orcs.Orc;

/** 相当于游戏世界，可以方便的添加actor,而actor可以方便的实现一些动画 */
public class GameStage extends Stage {
	private GamePath mGamePath = null;
	private float mTime = 0;

	public GameStage(float width, float height, boolean keepAspectRatio) {
		super(width, height, keepAspectRatio);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}

	public void update(float delta) {
		mTime += delta;
	}
	
	public float getTime(){
//		Gdx.app.debug("xujihao", "getDeltaTime " + mDeltaTime);
		return mTime;
	}

}
