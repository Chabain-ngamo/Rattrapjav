package Actions;

import elements.Avatar;
import elements.Enemy;
import elements.Path;
import elements.mobileElements;
import entity.Entity;
import entity.Game;

public class Falling extends Actions<mobileElements>{
	
	public Falling(mobileElements me) {
		this.me = me;
	}
	
	
	@Override
	public void runStrategy() {
		
		Entity getNextEntity = me.getGame().getArrayMap()[me.getPositionX()][me.getPositionY()+1];
		final int bonusEnemyKilled = 4;
		
		if (getNextEntity instanceof Path) {
			me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()+1] = me;
			me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()] = new Path(me.getPositionX(), me.getPositionY());
			me.setIsFallen(true);
			me.setPositionY(me.getPositionY()+1);
		} else if (getNextEntity instanceof Avatar && me.getIsFallen()){
			((Avatar)getNextEntity).setIsAlive(false);
			
		} else if(getNextEntity instanceof Enemy && me.getIsFallen()) {
			
			((Enemy)getNextEntity).setIsAlive(false);
			me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()+1] = new Path(me.getPositionX(), me.getPositionY());
			me.getMap().getAvatar().increaseDiamondsCounter(bonusEnemyKilled);
		} else {
			me.setIsFallen(false);
		}
	}
	
	@Override
	public String returnStrategy() {
		return "BasicFalling";
	}
	

}
