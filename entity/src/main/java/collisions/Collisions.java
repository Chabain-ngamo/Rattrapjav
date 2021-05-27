package collisions;

import elements.Avatar;
import elements.Diamond;
import elements.Enemy;
import elements.Path;
import elements.Wall;
import elements.Win;
import elements.stone;
import entity.Entity;

/**
 * The Collisions class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */

public class Collisions {
	

	/**
	 * The checkForCollisions method.
	 * @param entity the bidimensional array that contains the entity
	 * @param x the entity's x 
	 * @param y the entity's y
	 * @return a boolean that indicates if there is a collision or not.
	 */
	
	public boolean checkForCollisions(Entity[][] entity, int x, int y) {
		
	
		if (entity[x][y] instanceof stone) {
			return true;
		} else if (entity[x][y] instanceof Wall) {
			return true;
		} else if (entity[x][y] instanceof Win) {
			return true;
		} else if (entity[x][y] instanceof Enemy) {
			return true;
		} else {
			return false; 
		}
		
			
	}

	/**
	 * The checkForDiamonds method.
	 * @param playerPosition the player
	 * @param x the avatar's x
	 * @param y the avatar's y
	 */
	
	public boolean checkForDiamonds(Entity[][] playerPosition, int x, int y) {

		if (playerPosition[x][y] instanceof Diamond) {
			return true;
		}
		return false;
	}
	
	/**
	 * The checkForPlayer method.
	 * @param entity the entity that is gonna kill or no the avatar
	 * @param x the entity's x
	 * @param y the entity's y
	 */
	
	public boolean checkForAvatar(Entity[][] entity, int x, int y) {

		if (entity[x][y] instanceof Avatar) {
			return true;
		}
		return false;
	}
	
	/**
	 * The checkForPath method.
	 * @param entity the entity
	 * @param x the entity's x
	 * @param y the entity's y
	 * @return a boolean that indicates if there is a path near the entity. If true, it can moves.
	 */
	
	public boolean checkForPath(Entity[][] entity, int x, int y) {

		if (entity[x][y] instanceof Path) {
			return false;
		}
		return true;
	}
	
	/**
	 * The checkForStoneToMove method.
	 * @param entity the avatar
	 * @param x the avatar's x
	 * @param y the avatar's y
	 * @param sideX the side on which the player wants to move the stone (left/right)
	 * @return a boolean that indicates if the player can move a stone on the side he wants.
	 */
	
	public boolean checkForStoneToMove(Entity[][] entity, int x, int y, int sideX) { 

		if (entity[x][y] instanceof stone && entity[x+sideX][y] instanceof Path) {
			return true;
		}
		return false;
	}
	
	


}
