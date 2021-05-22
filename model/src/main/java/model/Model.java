package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import contract.State;
import entity.Game;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	private Game game;
	/** The number of levels */
	private final static int numberOfLevels = 7;
	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.game = new Game();
	}

	/**
     * Gets the map.
     *
     * @return map
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Game getGame() {
		return this.game;
	}

	/**
     * Sets the map
     *
     * @param map
     *            the new map
     */
	private void setGame(final Game game) {
		this.game = game;
		this.modelNotify();
	}

	/**
     * Load the map
     *
     * @param id
     *            the id of the map
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadGame(final int id) throws IndexOutOfBoundsException {
		
		if(id <= numberOfLevels) {
			try {
				final DAOGame daoGame = new DAOGame(DBConnection.getInstance().getConnection());
				this.setGame(daoGame.find(id));
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		} else {
				throw new IndexOutOfBoundsException("Incorrect id !");
		}
	}

	
		
	

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	/**
	 * Notify observers.
	 */
	public void modelNotify() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * The loop method.
	 * Executes the map loop and notify observers.
	 */
	public void loop() {

		if(this.getGame().getNumberOfDiamondsNeeded() != 0) {
			this.getGame().loop();
			this.modelNotify();
		}
	}

	@Override
	public void setState(State state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public State getState() {
		// TODO Auto-generated method stub
		return null;
	}

}
