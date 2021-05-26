package controller;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The ControllerTest class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 */
public class ControllerTest {
	
	/** The controller for the test */
	private static Controller controller;

	/**
	 * Instantiates a new controller for all tests.
	 * @throws Exception in case of an exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		controller = new Controller();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test to verify the correct message is obtained.
	 */
	@Test
	public void testMessagePrinted() {
		
		final String expectedMessage = "enter 1, 2, 3, 4 or 5 to choose the level of your game.";
		
		assertEquals(expectedMessage, controller.getMessageToShow());
		
	}

}
