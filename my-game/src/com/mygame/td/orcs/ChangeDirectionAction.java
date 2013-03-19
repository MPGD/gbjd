package com.mygame.td.orcs;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.mygame.td.orcs.Orc;

public class ChangeDirectionAction extends Action {
	private int direction;
	
	public ChangeDirectionAction(){
	}
	
	public ChangeDirectionAction(int direction){
		this.direction = direction;
	}
	
	public void setDirection(int dir){
		direction = dir;
	}
	
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		if(direction == Orc.Direction_UP) ((Orc) actor).setAnimation(((Orc) getActor()).animationUp);
		else if(direction == Orc.Direction_DOWN) ((Orc) actor).setAnimation(((Orc) getActor()).animationDown);
		else if(direction == Orc.Direction_LEFT) ((Orc) actor).setAnimation(((Orc) getActor()).animationLeft);
		else if(direction == Orc.Direction_RIGHT) ((Orc) actor).setAnimation(((Orc) getActor()).animationRight);
		
		return true;
	}

}
