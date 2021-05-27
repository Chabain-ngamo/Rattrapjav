package entity;

import java.util.Map;

import Actions.Actions;

/**
 * The Entity class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */

public abstract class Entity {
	
	/** The sprite of the entity */
	private Sprite sprite;
	/** The x position of the entity */
	private int positionX;
	/** The y position of the entity */
	private int positionY;
	/** The map on which the entity is */
	private Game game;
	/** The boolean that indicates if the entity if falling or not */
	private boolean isFallen;
	/** The strategy of the entity */
	private Actions<?> actions;
	
	/**
	 * The Entity's constructor 
	 * @param sprite the default sprite of the entity
	 * @param x the initial x of the entity
	 * @param y the initial y of the entity
	 */
	public Entity(final Sprite sprite, int x, int y) {
		this.setSprite(sprite);
		this.positionX = x;
		this.positionY = y;
	}
	
	public Entity() {
		
	}
	
	/**
	 * The setGame method.
	 * Defines the game on which the entity evolves.
	 * @param map the new map
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	/**
	 * The getGame method.
	 * @return the game on which the entity evolves
	 */
	public Game getGame() {
		return this.game;
	}
	
	
	/**
	 * The setSprite method.
	 * @param sprite the sprite of the entity
	 */
	public final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }
	
	/**
	 * The getSprite method.
	 * @return Sprite the sprite of the entity
	 */
	public final Sprite getSprite() {
        return this.sprite;
    }
	
	/**
	 * The setPositionX method.
	 * @param x the new x position of the entity
	 */
	public void setPositionX(int x) {
		this.positionX = x;
	}
	
	/**
	 * The getPositionX method.
	 * @return the x position of the entity
	 */
	public int getPositionX() {
		return this.positionX;
	}
	
	/**
	 * The getPositionY method.
	 * @return the y position of the entity
	 */
	public int getPositionY() {
		return this.positionY;
	}
	
	/**
	 * The setPositionY method.
	 * @param y the new y position of the entity
	 */
	public void setPositionY(int y) {
		this.positionY = y;
	}

	/**
	 * The getSpriteUp method.
	 * @return Sprite the up sprite of the entity
	 */
	public Sprite getSpriteUp() {
		return null;
	}
	
	/**
	 * The getSpriteDown method.
	 * @return Sprite the down sprite of the entity
	 */
	public Sprite getSpriteDown() {
		return null;
	}
	
	/**
	 * The getSpriteTurnLeft method.
	 * @return Sprite the left sprite of the entity
	 */
	public Sprite getSpriteTurnLeft() {
		return null;
	}
	
	/**
	 * The getSpriteTurnRight method.
	 * @return Sprite the right sprite of the entity
	 */
	public Sprite getSpriteTurnRight() {
		return null;
	}
	
	/**
	 * The getSpriteDeath method.
	 * @return Sprite the death sprite of the entity
	 */
	public Sprite getSpriteDeath() {
		return null;
	}

	/**
	 * The getIsFallen method.
	 * @return a boolean that indicates if the entity if falling
	 */
	public boolean getIsFallen() {
		return isFallen;
	}

	/**
	 * The setIsFallen method.
	 * @param isFallen the indication of falling
	 */
	public void setIsFallen(boolean isFallen) {
		this.isFallen = isFallen;
	}

	/**
	 * The getStrategy method.
	 * @return the strategy of the entity
	 */
	public Actions<?> getActions() {
		return actions;
	}

	/**
	 * The setStrategy method.
	 * @param strategy the new strategy of the entity
	 */
	public void setActions(Actions<?> actions) {
		this.actions = actions;
	}

	
}
