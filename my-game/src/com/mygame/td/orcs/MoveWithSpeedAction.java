package com.mygame.td.orcs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class MoveWithSpeedAction extends Action{
	private Orc mOrc = null;
	private float mStartX = -1;
	private float mStartY = -1;
	private float mDesX;
	private float mDesY;
	private boolean isXAxisMove;
	//正向为1， 如向右，向上，逆向为-1
	private float dir = 1;
	
	public MoveWithSpeedAction(){
	}
	
	public MoveWithSpeedAction(Orc orc, float desX, float desY){
		mOrc = orc;
		mDesX = desX;
		mDesY = desY;	

	}
	
	public void begin(){
		mStartX = actor.getX();
		mStartY = actor.getY();
		
		if(mDesX != mStartX && mDesY != mStartY){
			throw new GdxRuntimeException("MoveWithSpeedAction does not support both X and Y axis movement");
		}else if(mDesX != mStartX){//X轴位移
			if(mStartX > mDesX) dir = -1;
			isXAxisMove = true;
		}else if(mDesY != mStartY){//Y轴位移
			if(mStartY > mDesY) dir = -1;
			isXAxisMove = false;
		}
		
	}
	
	public void setOrc(Orc orc){
		mOrc = orc;
	}
	
	public void setDest(float desX, float desY){
		mDesX = desX;
		mDesY = desY;

	}
	
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		float moved = mOrc.moveSpeed * delta * dir;
		
		//Gdx.app.debug("xujihao", "speed is " + mOrc.moveSpeed + " moved is " + moved);
		float start, end;
		boolean ret = false;
		if(mStartX == -1 && mStartY == -1) begin();
		if(isXAxisMove){ 
			start = actor.getX();
			if((actor.getX() + moved > mDesX && dir == 1) || (actor.getX() + moved < mDesX && dir == -1)){
				actor.setX(mDesX);
			}else{
				actor.setX(actor.getX() + moved);
			}
			if(actor.getX() == mDesX) ret = true;
			end = actor.getX();
		}else{
			start = actor.getY();
			if((actor.getY() + moved > mDesY && dir == 1) || (actor.getY() + moved < mDesY && dir == -1)){
				actor.setY(mDesY);
			}else{
				actor.setY(actor.getY() + moved);
			}
			if(actor.getY() == mDesY) ret = true;
			end = actor.getY();
		}

		mOrc.setTotalDistance(mOrc.getTotalDistance() + Math.abs(end-start));
//		if(ret){
//			mStartX = -1;
//			mStartY = -1;
//			Gdx.app.debug("xujihao", "aaaaaa");
//		}
		return ret;
	}

}
