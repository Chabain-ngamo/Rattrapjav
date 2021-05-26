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
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	public void orderPerform(ControllerOrder controllerOrder) throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	
	public void performMenuRequest(Menu menu);
}
