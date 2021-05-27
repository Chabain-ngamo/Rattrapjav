package contract;

import java.io.IOException;
import java.util.Observable;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import entity.Game;

/**
 * The Interface IModel.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
public interface IModel {

	Game getGame();

	/**
	 * Load the game.
	 *
	 * @param id
	 *          the id of the game from the database
	 */
	void loadGame(int id);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	

	/**
	 * Notify observers.
	 */
	void modelNotify();
	
	/**
	 * Execute methods in the model to load the game.
	 * @throws LineUnavailableException 
     * A LineUnavailableException is an exception indicating that aline cannot be opened because it is unavailable. This situationarises most commonly when a requested line is already in useby another 
     * @throws IOException 
     * Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed orinterrupted I/O operations
     * @throws UnsupportedAudioFileException 
     * means An UnsupportedAudioFileException is an exception indicating that an operation failed because a file did not contain valid data of a recognized filetype and format.
     
	 */
	void loop() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	
	/**
	 * Sets the  state.
	 *
	 * 
	 *  @param  state.
	 */
	public void setState(State state);
	
	/**
	 * gets the state.
	 * @return the  state
	 */
	public State getState();
}
