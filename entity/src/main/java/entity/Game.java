package entity;

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
	/** The id of the map */
	private int id;
	/** The bidimensional array containing the entities of the map */
	private Entity[][] gameToChars;
	/** The collisions handler of the map */
	private Collisions collisions;
	/** The number of diamonds needed to win the level */
	private int numberOfDiamondsNeeded = 0;


	/**
	 * The Map's constructor.
	 * @param id the id of the map
	 * @param content the content of the map
	 * @param numberOfDiamondsNeeded the number of diamonds need to win the level
	 */
	public Game(final int id, final String content, int numberOfDiamondsNeeded) {
		this.setId(id);
		this.setContentOfGame(content);
		collisions = new Collisions();
		this.createGameToChars();
		this.numberOfDiamondsNeeded = numberOfDiamondsNeeded;
	}

	/**
	 * The getCollisionsHandler method.
	 * @return CollisionsHandler the collisions handler of the map
	 */
	public Collisions getCollisions() {
		return collisions;
	}

	/**
	 * The setCollisionsHandler method.
	 * @param collisionsHandler the new collisions handler for the map
	 */
	public void setCollisionsHandler(Collisions collisions) {
		this.collisions = collisions;
	}

	/**
	 * Instantiates a new basic map.
	 */
	public Game() {
		this(1, "", 0);
	}

	/**
	 * Gets the id of the map.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id of the map.
	 *
	 * @param id the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the content of the map
	 *
	 * @return the content as a String.
	 */
	public String getContentOfGame() {
		return this.contentOfGame;
	}

	/**
	 * Sets the content of the map.
	 *
	 * @param content the new content
	 */
	public void setContentOfGame(final String content) {
		this.contentOfGame = content;
	}

	/**
	 * The getHeightMap method.
	 * @return the height of the map
	 */
	public int getHeightGame() {
		String[] mapFirstLength = getContentOfGame().split("\n");
		return mapFirstLength.length;
	}

	/**
	 * The getWidthMap method.
	 * @return the width of the map
	 */
	public int getWidthGame() {
		String[] mapFirstLength = getContentOfGame().split("\n");
		return mapFirstLength[0].length() - 1;
	}

	/**
	 * The getNumberOfDiamondsNeeded method.
	 * @return the number of diamonds need to win the level
	 */
	public int getNumberOfDiamondsNeeded() {
		return numberOfDiamondsNeeded;
	}

	/**
	 * The setNumberOfDiamondsNeeded method.
	 * @param numberOfDiamondsNeeded the new number of diamonds need to win the level
	 */
	public void setNumberOfDiamondsNeeded(int numberOfDiamondsNeeded) {
		this.numberOfDiamondsNeeded = numberOfDiamondsNeeded;
	}

	/**
	 * The createMapToChars method.
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
	 * The getArrayMap method.
	 * @return the bidimensional array of the map with all the entities.
	 */
	public Entity[][] getArrayGame() {

		return this.gameToChars;
	}

	/**
	 * The getPlayer method.
	 * @return the player of the map.
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
	public void loop() {
		Avatar p = this.getAvatar();
		if(p != null) {
				p.playerDeathLinkToEnemy();
				p.didPlayerWin(numberOfDiamondsNeeded);
				this.runStrategies();
		}
	}
	
	/**
	 * The runStrategies method.
	 * Launch the map's entities strategies.
	 */
	public void runStrategies() {
		Entity[][] entity = this.getArrayGame();
		for (int y = getHeightGame() -1; y >= 0; y--) {
			for (int x = 0; x < getWidthGame(); x++) {
				if(entity[x][y].getActions() != null) {
					entity[x][y].getActions().runStrategy();
				}
			}
		}
	}

	

}
