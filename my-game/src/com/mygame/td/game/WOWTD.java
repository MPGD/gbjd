package com.mygame.td.game;

import com.badlogic.gdx.Game;
import com.mygame.td.screens.GameScreen;

public class WOWTD extends Game {
	@Override
	public void create () {
		setScreen(new GameScreen(this));
	}
}
