package com.mygame.td.orcs;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class OrcActions {
	/** Returns a new or pooled action of the specified type. */
	static public <T extends Action> T action (Class<T> type) {
		Pool<T> pool = Pools.get(type);
		T action = pool.obtain();
		action.setPool(pool);
		return action;
	}
	
	static public ChangeDirectionAction changeDir (int dir) {
		ChangeDirectionAction action = action(ChangeDirectionAction.class);
		action.setDirection(dir); 
		return action;
	}
	
	static public MoveWithSpeedAction moveWithSpeed (Orc orc, float desX, float desY) {
		MoveWithSpeedAction action = action(MoveWithSpeedAction.class);
		action.setOrc(orc);
		action.setDest(desX, desY);
		return action;
	}
}
