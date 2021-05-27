package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import contract.IModel;
import contract.State;
import entity.Game;

/**
 * The Class Model.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
public final class Model extends Observable implements IModel {

	private Game game;
	/** The number of levels */
	private final static int numberOfLevels = 5;
	private State state;
	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.game = new Game();
	}

	/**
     * Gets the game.
     *
     * @return game
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
     * Sets the game
     *
     * @param game
     *            the new game
     */
	private void setGame(final Game game) {
		this.game = game;
		this.modelNotify();
	}

	/**
     * Load the game
     *
     * @param id
     *            the id of the game
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
	 * Executes the game loop and notify observers.
	 * @throws LineUnavailableException 
     * A LineUnavailableException is an exception indicating that aline cannot be opened because it is unavailable. This situationarises most commonly when a requested line is already in useby another 
     * @throws IOException 
     * Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed orinterrupted I/O operations
     * @throws UnsupportedAudioFileException 
     * means An UnsupportedAudioFileException is an exception indicating that an operation failed because a file did not contain valid data of a recognized filetype and format.
     
	 */
	public void loop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		if(this.getGame().getNbrDiamonds() != 0) {
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
		
		return this.state;
	}

}
