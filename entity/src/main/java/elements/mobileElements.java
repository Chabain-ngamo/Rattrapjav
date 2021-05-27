package elements;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import collisions.Collisions;
import entity.Entity;
import entity.Sound;
import entity.Sprite;

/**
 * The MobileElements abstract class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */

public abstract class mobileElements extends Entity{
	
	/** The diamond counter */
	private int diamondsTimer;
	
	/** The boolean to indicates if the mobile element is alive */
	public boolean live;
	
	/** The death sprite for mobile entities */
	protected static final Sprite spriteDeath = new Sprite('a', "Death.png");
	
	
	/**
	 * The MobileElements constructor
	 * @param sprite the default sprite of the entity
	 * @param x the initial entity's x on the game
	 * @param y the initial entity's y on the game
	 */
	
	public mobileElements(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	/**
	 * The entityMove method.
	 * Allows mobile entities to move on the game.
	 * @param sideX the side the entity wants to move a stone
	 * @param direction the char that indicates to load the entity's specific sprite 
	 */
	
	public void entityMove(int x, int y, int sideX, char direction) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		final int xpos = this.getPositionX();
		final int ypos = this.getPositionY();
		final Entity[][] loadArrayGame = this.getGame().getArrayGame();
		final Avatar avatar = this.getGame().getAvatar();
		final Collisions getCollision = this.getGame().getCollisions();
		boolean collision = false;
		boolean isDiamond = false;
		boolean moveStone = false;
		boolean isAvatar = false;
		
			if(this instanceof Avatar) {
				collision = getCollision.checkForCollisions(loadArrayGame,xpos + x, ypos + y);
				isDiamond = getCollision.checkForDiamonds(loadArrayGame, xpos + x,ypos + y);
				moveStone = getCollision.checkForStoneToMove(loadArrayGame, xpos + x, ypos + y, sideX);
			}else {
				collision = getCollision.checkForPath(loadArrayGame,xpos + x, ypos + y);
				isAvatar = getCollision.checkForAvatar(loadArrayGame, xpos + x, ypos + y);
			}
				

			this.loadImage(direction, this);
			
			if(moveStone) {
				loadArrayGame[xpos + x + sideX][ypos + y] = loadArrayGame[xpos + x][ypos + y];
				loadArrayGame[xpos + x][ypos + y] = loadArrayGame[xpos][ypos];
				loadArrayGame[xpos][ypos] = new Path(xpos, ypos);
				this.setPositionY(ypos + y);
				this.setPositionX(xpos + x);
				loadArrayGame[xpos + x + sideX][ypos + y].setPositionX(xpos + x + sideX);
				Sound sound = new Sound();
				sound.playSound1("sons/audio/sounds/touch.wav");
						
			}
			
			if (!collision) {

				if(isAvatar == true) {
					avatar.setlive(false);
				} else {
					loadArrayGame[xpos + x][ypos + y] = loadArrayGame[xpos][ypos];
					loadArrayGame[xpos][ypos] = new Path(xpos, ypos);
					this.setPositionY(ypos + y);
					this.setPositionX(xpos + x);
				}
				
			}

			if (isDiamond == true) {
				this.incrementDiamondsCounter();
				Sound sound = new Sound();
				sound.playSound1("sons/audio/sounds/coin.wav");
			}
			

			
	}

	/**
	 * The loadImage method.
	 * Allows the entity to change sprite on the map depending on its movements.
	 * @param direction the direction of the entity
	 * @param entity the entity
	 */
	
	public void loadImage(char direction, Entity entity) {

		switch (direction) {

		case 'Z':
			entity.setSprite(entity.getSpriteUp());
			entity.getSprite().loadImage();
			break;
		case 'S':
			entity.setSprite(entity.getSpriteDown());
			entity.getSprite().loadImage();
			break;
		case 'Q':
			entity.setSprite(entity.getSpriteTurnLeft());
			entity.getSprite().loadImage();
			break;
		case 'D':
			entity.setSprite(entity.getSpriteTurnRight());
			entity.getSprite().loadImage();
			break;
		case 'X':
			entity.setSprite(entity.getSpriteDeath());
			entity.getSprite().loadImage();
			break;
		}
	}

	/**
	 * The incrementDiamondsCounter method.
	 * Increase by 1 the diamond counter of the entity.
	 */
	public void incrementDiamondsCounter() {
		this.diamondsTimer++;
	}
	
	/**
	 * The increaseDiamondsCounter method.
	 * @param increase the amount of increase of the counter.
	 */
	
	public void plusadiamond(int increase) {
		this.diamondsTimer += increase;
	}

	/**
	 * The getDiamondsCounter methods.
	 * @return the number of diamonds the entity has
	 */
	
	public int getDiamondstimer() {
		return this.diamondsTimer;
	}

	/**
	 * The getIsAlive method.
	 * @return the status of live of the entity (true = is living).
	 */
	public boolean getlive() {
		return this.live;
	}

	/**
	 * The setIsAlive method.
	 * @param isAlive define if the entity is still alive or not
	 */
	public void setlive(boolean live) {
		this.live = live;
	}
	
	/**
	 * The getSpriteDeath method.
	 * @return the death sprite of mobile entities
	 */
	public Sprite getSpriteDeath() {
		return mobileElements.spriteDeath;
	}
	

}
