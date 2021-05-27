package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elements.Path;



/**
 * The PathTest class.
 *  * @author Maiva
 * @author Chabain
 *  @author Vladimir

 */
public class PathTest extends entityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new Path(6,6);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new path.
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testPath method.
	 * Checks the basic sprite name, character and strategy of the path.
	 */
	@Test
	public void testPath() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Background.png";
		final char expectedCharName = 'p';

	}

}
