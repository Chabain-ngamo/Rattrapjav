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
	 * @param enemy the enemy concerned
	 * @throws LineUnavailableException 
     * A LineUnavailableException is an exception indicating that aline cannot be opened because it is unavailable. This situationarises most commonly when a requested line is already in useby another 
     * @throws IOException 
     * Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed orinterrupted I/O operations
     * @throws UnsupportedAudioFileException 
     * means An UnsupportedAudioFileException is an exception indicating that an operation failed because a file did not contain valid data of a recognized filetype and format.
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
