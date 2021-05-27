package Actions;

import elements.Avatar;
import elements.Enemy;
import elements.Path;
import elements.mobileElements;
import entity.Entity;
import entity.Game;

/**
 * The Failling class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */


public class Falling extends Actions<mobileElements>{
	
	public Falling(mobileElements enemy) {
		this.enemy = enemy;
	}
	
	
	//method runActions
	@Override
	public void runActions() {
		
		Entity getNextEntity = enemy.getGame().getArrayGame()[enemy.getPositionX()][enemy.getPositionY()+1];
		final int bonusEnemyKilled = 4;
		
		if (getNextEntity instanceof Path) {
			enemy.getGame().getArrayGame()[enemy.getPositionX()][enemy.getPositionY()+1] = enemy;
			enemy.getGame().getArrayGame()[enemy.getPositionX()][enemy.getPositionY()] = new Path(enemy.getPositionX(), enemy.getPositionY());
			enemy.setIsFallen(true);
			enemy.setPositionY(enemy.getPositionY()+1);
		} else if (getNextEntity instanceof Avatar && enemy.getIsFallen()){
			((Avatar)getNextEntity).setlive(false);
			
		} else if(getNextEntity instanceof Enemy && enemy.getIsFallen()) {
			
			((Enemy)getNextEntity).setlive(false);
			enemy.getGame().getArrayGame()[enemy.getPositionX()][enemy.getPositionY()+1] = new Path(enemy.getPositionX(), enemy.getPositionY());
			enemy.getGame().getAvatar().plusadiamond(bonusEnemyKilled);
		} else {
			enemy.setIsFallen(false);
		}
	}
	
	@Override
	public String returnActions() {
		return "Falling";
	}
	

}
