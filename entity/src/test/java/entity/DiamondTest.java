package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elements.Diamond;



/**
 * The diamond test class.
 *  * @author Maiva
 * @author Chabain
 *  @author Vladimir
 */
public class DiamondTest extends entityTest  {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new Diamond(4,4);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new diamond.
	 *
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testDiamond method.
	 * Checks the basic sprite name, character and strategy of the diamond.
	 */
	@Test
	public void testDiamond() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Diamond.png";
		final char expectedCharName = 'D';
		final String expectedStrategy = "Falling";
	}
}
