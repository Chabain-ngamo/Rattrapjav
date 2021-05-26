package Actions;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import elements.Avatar;
import elements.Enemy;
import elements.Path;
import elements.mobileElements;
import elements.stone;
import entity.Entity;
import entity.Sound;

/**
 * The FaillingMove class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */


public class FallingMove extends Actions<mobileElements>{
	
	public FallingMove(mobileElements enemy) {
		this.enemy = enemy;
	}

	@Override
	public void runActions() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Entity getNextEntity = enemy.getGame().getArrayGame()[enemy.getPositionX()][enemy.getPositionY()+1];
		Entity getLeftEntity = enemy.getGame().getArrayGame()[enemy.getPositionX() - 1][enemy.getPositionY()];
		Entity getLeftBottomEntity = enemy.getGame().getArrayGame()[enemy.getPositionX() - 1][enemy.getPositionY() +1];
		Entity getRightEntity = enemy.getGame().getArrayGame()[enemy.getPositionX() + 1][enemy.getPositionY()];
		Entity getRightBottomEntity = enemy.getGame().getArrayGame()[enemy.getPositionX() + 1][enemy.getPositionY() +1];
		final int bonusEnemyKilled = 4;
		
		if (getNextEntity instanceof Path) {
			this.FallingMove(0, 1);
		} else if (getNextEntity instanceof Avatar && enemy.getIsFallen()){
			((Avatar)getNextEntity).setIsAlive(false);
			Sound sound = new Sound();
			sound.playSound1("sons/audio/sounds/die.wav");
			
		} else if(getNextEntity instanceof Enemy && enemy.getIsFallen()) {
			((Enemy)getNextEntity).setIsAlive(false);
			enemy.getGame().getArrayGame()[enemy.getPositionX()][enemy.getPositionY()+1] = new Path(enemy.getPositionX(), enemy.getPositionY());
			enemy.getGame().getAvatar().increaseDiamondsCounter(bonusEnemyKilled);
		} else if(getNextEntity instanceof stone && getLeftEntity instanceof Path && getLeftBottomEntity instanceof Path) {	
			this.FallingMove(-1, 1);
		 
		} else if(getNextEntity instanceof stone && getRightEntity instanceof Path && getRightBottomEntity instanceof Path) {	
			this.FallingMove(1, 1);
		} else {
			enemy.setIsFallen(false);
		}
	}
	
	
	
	/**
	 * The cascadeFalling method.
	 * Defines the falling of the mobile element.
	 * @param sideX the x side on which the entity is going to fell
	 * @param sideY the y side on which the entity is going to fell
	 */
	public void FallingMove(int sideX, int sideY) {
		
		enemy.getGame().getArrayGame()[enemy.getPositionX() + sideX][enemy.getPositionY() + sideY] = enemy;
		enemy.getGame().getArrayGame()[enemy.getPositionX()][enemy.getPositionY()] = new Path(enemy.getPositionX(), enemy.getPositionY());
		enemy.setIsFallen(true);
		enemy.setPositionX(enemy.getPositionX()+ sideX);
		enemy.setPositionY(enemy.getPositionY()+ sideY);
		
	}

	@Override
	public String returnActions() {
		return "FallingMove";
	}

}
