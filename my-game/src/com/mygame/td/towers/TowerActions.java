package com.mygame.td.towers;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.mygame.td.orcs.ChangeDirectionAction;

public class TowerActions {
	/** Returns a new or pooled action of the specified type. */
	static public <T extends Action> T action (Class<T> type) {
		Pool<T> pool = Pools.get(type);
		T action = pool.obtain();
		action.setPool(pool);
		return action;
	}
	
	static public DetectAction detect(float attackArea){
		DetectAction action = action(DetectAction.class);
		action.setAttackArea(attackArea);
		return action;
	}
}
