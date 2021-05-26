package Actions;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import elements.mobileElements;
import entity.Entity;

/**
 * The Actions class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */

public abstract class Actions <T extends Entity>{
	
	/** The mobile element concerned by the strategy */
	protected mobileElements enemy = null;
	/** The method that contains the strategy 
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException */
	public abstract void runActions() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	/** The method that gives the name of the strategy */
	public abstract String returnActions();

}
