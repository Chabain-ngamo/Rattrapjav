package Actions;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import elements.Enemy;

/**
 * The EnnemyMoveA class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */


public class EnemyMoveA extends Actions<Enemy> {
	
private Enemy enemy = null;
	
	/**
	 * The EnemyMoveA actions constructor.
	 * @param me the enemy concerned
	 */
	public EnemyMoveA(Enemy enemy) {
		this.enemy = enemy;
	}
	
	@Override
	public void runActions() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		double randomDirection = Math.random();
		randomDirection = randomDirection * 2 +1;
		int randomDirInt = (int) randomDirection;
		
		switch(randomDirInt) {
		case 1:
			enemy.entityMove(1, 0, 0, 'S');
			break;
		case 2:
			enemy.entityMove(-1, 0, 0, 'S');
			break;
		}
		
	}

	@Override
	
	

	
	public String returnActions() {
		return "EnemyMoveA";
	}
	

}
