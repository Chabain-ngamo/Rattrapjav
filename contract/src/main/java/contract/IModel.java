package contract;

import java.util.Observable;

import entity.Game;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	Game getHelloWorld();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	void loadHelloWorld(String code);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
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
