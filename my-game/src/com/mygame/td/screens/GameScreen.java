
package com.mygame.td.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.mygame.td.game.GameStage;
import com.mygame.td.orcs.WolfKnight;
import com.mygame.td.towers.ArrowTower;

public class GameScreen extends BaseScreen {
	GameStage gs;

	public GameScreen (Game game) {
		super(game);
	}

	@Override
	public void show () {
		gs = new GameStage(480, 320, true);
		WolfKnight wk = new WolfKnight();
		gs.addActor(wk);
		
		ArrowTower at = new ArrowTower();
		gs.addActor(at);
	}

	@Override
	public void render (float delta) {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);  
        gs.act(delta);  
        gs.update(delta);
		gs.draw();
	}

	@Override
	public void hide () {

	}
	
	@Override
	public void dispose () {
		gs.dispose();
	}
}
