package entity;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elements.stone;



/**
 * The StoneTest class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 */
public class stoneTest extends entityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new stone(7,7);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new stone.
	 *
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testStone method.
	 * Checks the basic sprite name, character and strategy of the stone.
	 */
	@Test
	public void testStone() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Stone.png";
		final char expectedCharName = 's';
		final String expectedStrategy = "FallingMove";

	}
}
