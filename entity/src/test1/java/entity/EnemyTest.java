package entity;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Actions.EnemyMoveB;
import elements.Enemy;
import entity.Game;

/**
 * The Enemy test class.
* @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */
public class EnemyTest extends entityTest {
	
	/** The map of the enemy */
	Game game;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new Enemy(5,5);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates the map and the enemy.
	 */


	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testEnemy method.
	 * Checks the basic sprite name, character and strategy of the enemy.
	 */
	@Test
	public void testEnemy() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Enemy.png";
		final char expectedCharName = 'e';
		entity.setActions(new EnemyMoveB((Enemy)entity));
		final String expectedStrategy = "EnemyMoveB";
 
	}
	


}
