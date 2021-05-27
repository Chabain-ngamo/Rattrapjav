package entity;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import collisions.Collisions;
import elements.Avatar;
import elements.Diamond;
import elements.Dirt;
import elements.Enemy;
import elements.Path;
import elements.Wall;
import elements.Win;
import elements.stone;

/**
 * The Game class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */

public class Game extends Entity{
	private String contentOfGame;
	/** The id of the game */
	private int id;
	/** The bidimensional array containing the entities of the game */
	private Entity[][] gameToChars;
	/** The collisions of the game */
	private Collisions collisions;
	/** The number of diamonds  for win the level */
	private int nbrDiamonds = 0;
	private boolean gamePaused;


	/**
	 * The Game's constructor.
	 * @param id the id of the Game
	 * @param content the content of the Game
	 * @param nbrDiamonds the number of diamonds to win the level
	 */
	public Game(final int id, final String content, int nbrDiamonds) {
		this.setId(id);
		this.setContentOfGame(content);
		collisions = new Collisions();
		this.createGameToChars();
		this.nbrDiamonds = nbrDiamonds;
	}

	/**
	 * The getCollisions method.
	 * @return Collisions the collisions  of the map
	 */
	public Collisions getCollisions() {
		return collisions;
	}

	/**
	 * The setCollisions method.
	 * @param collisions the new collisions for the map
	 */
	public void setCollisions(Collisions collisions) {
		this.collisions = collisions;
	}

	/**
	 * Instantiates a new basic Game.
	 */
	public Game() {
		this(1, "", 0);
	}

	/**
	 * Gets the id of the game.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id of the .game
	 *
	 * @param id the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the content of the game
	 *
	 * @return the content as a String.
	 */
	public String getContentOfGame() {
		return this.contentOfGame;
	}

	/**
	 * Sets the content of the game.
	 *
	 * @param content the new content
	 */
	public void setContentOfGame(final String content) {
		this.contentOfGame = content;
	}

	/**
	 * The getHeightMap method.
	 * @return the height of the game
	 */
	public int getHeightGame() {
		String[] mapFirstLength = getContentOfGame().split("\n");
		return mapFirstLength.length;
	}

	/**
	 * The getWidthMap method.
	 * @return the width of the game
	 */
	public int getWidthGame() {
		String[] mapFirstLength = getContentOfGame().split("\n");
		return mapFirstLength[0].length() - 1;
	}

	/**
	 * The getNbrDiamondsmethod.
	 * @return the number of diamonds to win the level
	 */
	public int getNbrDiamonds() {
		return nbrDiamonds;
	}

	/**
	 * The setNbrDiamonds method.
	 * @param nbrDiamonds the new number of diamonds to win the level
	 */
	public void setNumberOfDiamondsNeeded(int nbrDiamonds) {
		this.nbrDiamonds = nbrDiamonds;
	}

	/**
	 * The createGameToChars method.
	 * Transform the String content of the map into entities.
	 */
	public void createGameToChars() {
		String game = this.getContentOfGame();
		if (getHeightGame() >= 1 && getWidthGame() >= 1) {
			this.gameToChars = new Entity[this.getWidthGame()][this.getHeightGame()];
			for (int y = 0; y < getHeightGame(); y++) {
				String[] finalGame = game.split("\n");
				for (int x = 0; x < getWidthGame(); x++) {
					switch (finalGame[y].toCharArray()[x]) {
					case 'w':
						gameToChars[x][y] = new Wall(x, y);
						break;
					case 'd':
						gameToChars[x][y] = new Dirt(x, y);
						break;
					case 'a':
						gameToChars[x][y] = new Avatar(x, y);
						break;
					case 's':
						gameToChars[x][y] = new stone(x, y);
						break;
					case 'e':
						gameToChars[x][y] = new Enemy(x, y);
						break;
					case 'p':
						gameToChars[x][y] = new Path(x, y);
						break;
					case 'D':
						gameToChars[x][y] = new Diamond(x, y);
						break;
					case 'W':
						gameToChars[x][y] = new Win(x, y);
						break;
					default:
						break;
					}

					gameToChars[x][y].setGame(this);

				}
			}
		}
	}

	/**
	 * The getArrayGame method.
	 * @return the bidimensional array of the game with all the entities.
	 */
	public Entity[][] getArrayGame() {

		return this.gameToChars;
	}

	/**
	 * The getAvatar method.
	 * @return the avatar of the game.
	 */
	public Avatar getAvatar() {
		Entity[][] entity = this.getArrayGame();
		for (int y = 0; y < getHeightGame(); y++) {
			for (int x = 0; x < getWidthGame(); x++) {
				if (entity[x][y] instanceof Avatar) {
					return (Avatar) entity[x][y];
				}
			}
		}
		return null;
	}

	/**
	 * The loop method.
	 * Executes methods of the map and its entities.
	 */
	public void loop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Avatar p = this.getAvatar();
		if(p != null) {
				p.playerDeathLinkToEnemy();
				p.didPlayerWin(nbrDiamonds);
				this.runActions();
		}
	}
	
	/**
	 * The runStrategies method.
	 * Launch the game's entities actions.
	 */
	public void runActions() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Entity[][] entity = this.getArrayGame();
		for (int y = getHeightGame() -1; y >= 0; y--) {
			for (int x = 0; x < getWidthGame(); x++) {
				if(entity[x][y].getActions() != null) {
					entity[x][y].getActions().runActions();
				}
			}
		}
	}
	public void setGamePaused(boolean gamePaused) {
		this.gamePaused = gamePaused;
	}

	/**
	 * Get the gamePaused variable
	 * 
	 * @return  gamePaused
	 */
	public boolean getGamePaused() {
		return this.gamePaused;
	}

	

}
