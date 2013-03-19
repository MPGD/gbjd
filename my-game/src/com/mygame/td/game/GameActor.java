package com.mygame.td.game;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameActor extends Actor{
	public static int ACTOR_ORC = 0;
	public static int ACTOR_TOWER = 1;
	public static int ACTOR_BULLET = 2;
	
	private int type;
	
	public void setType(int type){
		this.type = type;
	}
	
	public int getType(){
		return type;
	}
}
