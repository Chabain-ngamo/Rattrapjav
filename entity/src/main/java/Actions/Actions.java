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
	
	/** The mobile element concerned by the actions */
	protected mobileElements me = null;
	/** The method that contains the actions 
	 * @throws LineUnavailableException 
     * A LineUnavailableException is an exception indicating that aline cannot be opened because it is unavailable. This situationarises most commonly when a requested line is already in useby another 
     * @throws IOException 
     * Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed orinterrupted I/O operations
     * @throws UnsupportedAudioFileException 
     * means An UnsupportedAudioFileException is an exception indicating that an operation failed because a file did not contain valid data of a recognized filetype and format.
     * @return that indicates that the actions must be done  
     */
	
	public abstract void runActions() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	/** The method that gives the name of the actions */
	public abstract String returnActions();

}
