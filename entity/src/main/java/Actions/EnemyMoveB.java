package Actions;

import elements.Enemy;

/**
 * The EnnemyMoveB class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */


public class EnemyMoveB extends Actions<Enemy>{
	
private Enemy enemy = null;
	
	/**
	 * The RandomEnemyMove strategy constructor.
	 * @param me the enemy concerned
	 */
	public EnemyMoveB(Enemy enemy) {
		this.enemy = enemy;
	}

	@Override
	public void runActions() {
		
		if(enemy.getIsAlive()) {
			double randomDirection = Math.random();
			randomDirection = randomDirection * 4 +1;
			int randomDirInt = (int) randomDirection;
			switch(randomDirInt) {
			case 1:
				enemy.entityMove(0, -1, 0, 'S');
				break;
			case 2:
				enemy.entityMove(-1, 0, 0, 'S');
				break;
			case 3:
				enemy.entityMove(0, 1, 0, 'S');
				break;
			case 4:
				enemy.entityMove(+1, 0, 0, 'S');
				break;
			}
		} else {
			enemy.loadImage('X', enemy);
		}
		
		
		
	}

	@Override
	public String returnActions() {
		return "EnemyMoveB";
	}

}
