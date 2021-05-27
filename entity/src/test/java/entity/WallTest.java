package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elements.Wall;



/**
 * The WallTest class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 */
public class WallTest extends entityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new Wall(7,7);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new wall.
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testWalls method.
	 * Checks the basic sprite name, character and strategy of walls.
	 */
	@Test
	public void testWalls() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Wall.png";
		final char expectedCharName = 'w';

	}

}
