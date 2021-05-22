package Actions;

import elements.Avatar;
import elements.Enemy;
import elements.Path;
import elements.mobileElements;
import elements.stone;
import entity.Entity;

/**
 * The FaillingMove class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */


public class FallingMove extends Actions<mobileElements>{
	
	public FallingMove(mobileElements me) {
		this.me = me;
	}

	@Override
	public void runStrategy() {
		
		Entity getNextEntity = me.getGame().getArrayGame()[me.getPositionX()][me.getPositionY()+1];
		Entity getLeftEntity = me.getGame().getArrayGame()[me.getPositionX() - 1][me.getPositionY()];
		Entity getLeftBottomEntity = me.getGame().getArrayGame()[me.getPositionX() - 1][me.getPositionY() +1];
		Entity getRightEntity = me.getGame().getArrayGame()[me.getPositionX() + 1][me.getPositionY()];
		Entity getRightBottomEntity = me.getGame().getArrayGame()[me.getPositionX() + 1][me.getPositionY() +1];
		final int bonusEnemyKilled = 4;
		
		if (getNextEntity instanceof Path) {
			this.FallingMove(0, 1);
		} else if (getNextEntity instanceof Avatar && me.getIsFallen()){
			((Avatar)getNextEntity).setIsAlive(false);
			
		} else if(getNextEntity instanceof Enemy && me.getIsFallen()) {
			((Enemy)getNextEntity).setIsAlive(false);
			me.getGame().getArrayGame()[me.getPositionX()][me.getPositionY()+1] = new Path(me.getPositionX(), me.getPositionY());
			me.getGame().getAvatar().increaseDiamondsCounter(bonusEnemyKilled);
		} else if(getNextEntity instanceof stone && getLeftEntity instanceof Path && getLeftBottomEntity instanceof Path) {	
			this.FallingMove(-1, 1);
		 
		} else if(getNextEntity instanceof stone && getRightEntity instanceof Path && getRightBottomEntity instanceof Path) {	
			this.FallingMove(1, 1);
		} else {
			me.setIsFallen(false);
		}
	}
	
	
	
	/**
	 * The cascadeFalling method.
	 * Defines the falling of the mobile element.
	 * @param sideX the x side on which the entity is going to fell
	 * @param sideY the y side on which the entity is going to fell
	 */
	public void FallingMove(int sideX, int sideY) {
		
		me.getGame().getArrayGame()[me.getPositionX() + sideX][me.getPositionY() + sideY] = me;
		me.getGame().getArrayGame()[me.getPositionX()][me.getPositionY()] = new Path(me.getPositionX(), me.getPositionY());
		me.setIsFallen(true);
		me.setPositionX(me.getPositionX()+ sideX);
		me.setPositionY(me.getPositionY()+ sideY);
		
	}

	@Override
	public String returnStrategy() {
		return "FallingMove";
	}

}
