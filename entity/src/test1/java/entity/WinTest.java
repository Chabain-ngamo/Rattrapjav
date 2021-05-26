package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elements.Win;



/**
 * The WinTest class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 */
public class WinTest extends entityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new Win(3,3);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new exit door.
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testExitDoor method.
	 * Checks the basic sprite name, character and strategy of the exit door.
	 */
	@Test
	public void testExitDoor() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Door.png";
		final char expectedCharName = 'W';

	}

}
