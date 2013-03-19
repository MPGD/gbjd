package com.mygame.td.orcs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class WolfKnight extends Orc {

	public static float ORC_WOLFKNIGHT_HP = 100;
	public static String ORC_WOLFKNIGHT_IMG_SRC = "data/test.png";
	private float scaleXY = 0.8f;
	
	public WolfKnight() {
		super();
		// 加载纹理
		Texture temp = new Texture(ORC_WOLFKNIGHT_IMG_SRC);

		// 加载关键帧动画
		TextureRegion[] down = new TextureRegion(temp).split(64, 128)[0];
		TextureRegion[] left = new TextureRegion(temp).split(64, 128)[1];
		TextureRegion[] right = new TextureRegion(temp).split(64, 128)[2];
		TextureRegion[] up = new TextureRegion(temp).split(64, 128)[3];

		Sprite [] _up = new Sprite[4];
		Sprite [] _down = new Sprite[4];
		Sprite [] _left = new Sprite[4];
		Sprite [] _right = new Sprite[4];
		
		for(int i = 0; i < 4; i++) _up[i] = new Sprite(up[i]);
		for(int i = 0; i < 4; i++) _down[i] = new Sprite(down[i]);
		for(int i = 0; i < 4; i++) _left[i] = new Sprite(left[i]);
		for(int i = 0; i < 4; i++) _right[i] = new Sprite(right[i]);
		
		for(int i = 0; i < 4; i++) _up[i].setScale(scaleXY);
		for(int i = 0; i < 4; i++) _down[i].setScale(scaleXY);
		for(int i = 0; i < 4; i++) _left[i].setScale(scaleXY);
		for(int i = 0; i < 4; i++) _right[i].setScale(scaleXY);
		
		Animation aniUp = new Animation(0.1f, _up[0], _up[1], _up[2], _up[3]);
		Animation aniDown = new Animation(0.1f, _down[0], _down[1], _down[2],
				_down[3]);
		Animation aniLeft = new Animation(0.1f, _left[0], _left[1], _left[2],
				_left[3]);
		Animation aniRight = new Animation(0.1f, _right[0], _right[1], _right[2],
				_right[3]);

		setAnimation(aniUp, aniDown, aniLeft, aniRight);

		MoveWithSpeedAction moveAction1 = OrcActions.moveWithSpeed(this, 300, 200);
		MoveWithSpeedAction moveAction2 = OrcActions.moveWithSpeed(this, 300, 0);
		MoveWithSpeedAction moveAction3 = OrcActions.moveWithSpeed(this, 0, 0);
		MoveWithSpeedAction moveAction4 = OrcActions.moveWithSpeed(this, 0, 200);

		ChangeDirectionAction cda1 = OrcActions.changeDir(Orc.Direction_DOWN);
		ChangeDirectionAction cda2 = OrcActions.changeDir(Orc.Direction_LEFT);
		ChangeDirectionAction cda3 = OrcActions.changeDir(Orc.Direction_UP);
		ChangeDirectionAction cda4 = OrcActions.changeDir(Orc.Direction_RIGHT);

		addAction(Actions.forever(Actions.sequence(moveAction1, cda1,
				moveAction2, cda2, moveAction3, cda3, moveAction4, cda4)));

		setHp(ORC_WOLFKNIGHT_HP);
		setPosition(0, 200);
		setSize(64 * scaleXY, 128 * scaleXY);

		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				Gdx.app.debug("xujihao", String.format("x = %f y = %f", x, y));
				moveSpeed += 10;
				super.clicked(event, x, y);
			}

		});
	}

}
