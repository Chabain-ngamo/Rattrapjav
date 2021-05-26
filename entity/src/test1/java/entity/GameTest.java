package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The MapTest class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 */
public class GameTest {
	
	/** The map for the test */
	static Game game;


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new map and its entities.
	 */
	@Before
	public void setUp() throws Exception {

	}

	
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Verifiy that there is a player entity on the map and therefore the transformation of the String into entities worked well.
	 */
	@Test
	public void testGameFulfilled() {
		assertNotNull(game.getAvatar());
		
		
	}
	
	

}
