package Actions;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import elements.Avatar;
import elements.Enemy;
import elements.Path;
import elements.mobileElements;
import entity.Entity;
import entity.Game;
import entity.Sound;

/**
 * The Failling class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */


public class Falling extends Actions<mobileElements>{
	
	public Falling(mobileElements me) {
		this.me = me;
	}
	
	
	//method runActions
	@Override
	public void runActions() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Entity getNextEntity = me.getGame().getArrayGame()[me.getPositionX()][me.getPositionY()+1];
		final int bonusEnemyKilled = 4;
		
		if (getNextEntity instanceof Path) {
			me.getGame().getArrayGame()[me.getPositionX()][me.getPositionY()+1] = me;
			me.getGame().getArrayGame()[me.getPositionX()][me.getPositionY()] = new Path(me.getPositionX(), me.getPositionY());
			me.setIsFallen(true);
			me.setPositionY(me.getPositionY()+1);
		} else if (getNextEntity instanceof Avatar && me.getIsFallen()){
			((Avatar)getNextEntity).setlive(false);
			Sound sound = new Sound();
			sound.playSound1("sons/audio/sounds/die.wav");
			
		} else if(getNextEntity instanceof Enemy && me.getIsFallen()) {
			
			((Enemy)getNextEntity).setlive(false);
			me.getGame().getArrayGame()[me.getPositionX()][me.getPositionY()+1] = new Path(me.getPositionX(), me.getPositionY());
			me.getGame().getAvatar().plusadiamond(bonusEnemyKilled);
		} else {
			me.setIsFallen(false);
		}
	}
	
	@Override
	public String returnActions() {
		return "Falling";
	}
	

}
