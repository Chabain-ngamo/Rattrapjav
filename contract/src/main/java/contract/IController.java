package contract;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The Interface IController.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 *@throws LineUnavailableException 
     * A LineUnavailableException is an exception indicating that aline cannot be opened because it is unavailable. This situationarises most commonly when a requested line is already in useby another 
     * @throws IOException 
     * Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed orinterrupted I/O operations
     * @throws UnsupportedAudioFileException 
     * means An UnsupportedAudioFileException is an exception indicating that an operation failed because a file did not contain valid data of a recognized filetype and format.
	 */
	public void orderPerform(ControllerOrder controllerOrder) throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	
	public void performMenuRequest(Menu menu);
}
