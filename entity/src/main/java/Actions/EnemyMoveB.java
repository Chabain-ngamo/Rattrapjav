package Actions;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
	public void runActions() throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
		
		if(enemy.getlive()) {
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
