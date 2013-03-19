package com.mygame.td.towers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygame.td.game.GameActor;

/**
 * 	侦查周围的兽人，如果攻击范围内有兽人，在生成一个bullet去攻击
 *  类似碰撞测试
 * */
public class DetectAction extends Action{

	private float attackArea;
	private float centerX;
	private float centerY;
	Array<Actor> enemies = new Array<Actor>();
	
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		Tower tower = (Tower)actor;
		if(tower.getLastAttackTime() + delta > tower.attackTime){
			
		}else{
			tower.setLastAttackTime(tower.getLastAttackTime() + delta);
			return true;
		}
		
		Stage stage = actor.getStage();
		
		Array<Actor> children = stage.getRoot().getChildren();
		
		boolean find = false;
		for(int i = 0; i < children.size; i++){
			if(((GameActor)children.get(i)).getType() == GameActor.ACTOR_ORC){
				if(distance(children.get(i)) < attackArea){
					enemies.add(children.get(i));
					find = true;
				}
			}
		}
		
		if(find){
			tower.setLastAttackTime(0);
			ArrowBullet ab = new ArrowBullet(enemies.get(0));
			ab.setPosition(actor.getX(), actor.getY());
			stage.addActor(ab);
			
			Gdx.app.debug("xujihao", "find!!!");
		} 
		return true;
	}
	
	public void setAttackArea(float attArea){
		attackArea = attArea;
	}

	/** 分别判断四个点与*/
	private float distance(Actor actor){
		centerX = this.actor.getX() + this.actor.getWidth() / 2;
		centerY = this.actor.getY() + this.actor.getHeight() / 2;
		
		float dist1 = distance(actor.getX(), actor.getY());
		float dist2 = distance(actor.getX() + actor.getWidth(), actor.getY());
		float dist3 = distance(actor.getX(), actor.getY() + actor.getHeight());
		float dist4 = distance(actor.getX() + actor.getWidth(), actor.getY() + actor.getHeight());
		
		float dist = Math.min(Math.min(dist1, dist2), Math.min(dist3, dist4));
		
		return dist;
	}
	
	private float distance(float x, float y){
		float dist = (float)Math.sqrt((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY));
		return dist;
	}
}
