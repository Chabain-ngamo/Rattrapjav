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
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	void loop() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
	
	/**
	 * Sets the  state.
	 *
	 * @param State
	 *          the State
	 */
	public void setState(State state);
	
	/**
	 * gets the state.
	 * @return the  state
	 */
	public State getState();
}
