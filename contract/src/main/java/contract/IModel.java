package contract;

import java.util.Observable;

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
	 * Load the map.
	 *
	 * @param id
	 *          the id of the map from the database
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
	 */
	void loop();
	
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
