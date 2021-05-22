package Actions;

import elements.Enemy;

/**
 * The EnnemyMoveA class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */


public class EnemyMoveA extends Actions<Enemy> {
	
private Enemy me = null;
	
	/**
	 * The LoopEnemyMove strategy constructor.
	 * @param me the enemy concerned
	 */
	public EnemyMoveA(Enemy me) {
		this.me = me;
	}
	
	@Override
	public void runStrategy() {
		
		double randomDirection = Math.random();
		randomDirection = randomDirection * 2 +1;
		int randomDirInt = (int) randomDirection;
		
		switch(randomDirInt) {
		case 1:
			me.entityMove(1, 0, 0, 'S');
			break;
		case 2:
			me.entityMove(-1, 0, 0, 'S');
			break;
		}
		
	}

	@Override
	public String returnStrategy() {
		return "LoopEnemyMove";
	}
		
	

	
	public String returnActions() {
		return "EnemyMoveA";
	}
	

}
