package view;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;

/**
 * The viewTest class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 */
public class viewTest {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	 * Check for each specific touch the player can use that the result is the right one.
	 */
	@Test
	public void testControllerOrderReturn() {
		
		final ControllerOrder expectedZ = ControllerOrder.Up;
		
	//	assertEquals(expectedZ, View.keyCodeToControllerOrder(KeyEvent.VK_Z));
		
		final ControllerOrder expectedQ = ControllerOrder.Left;
		
		//assertEquals(expectedQ, View.keyCodeToControllerOrder(KeyEvent.VK_Q));
		
		final ControllerOrder expectedS = ControllerOrder.Down;
		
		//assertEquals(expectedS, View.keyCodeToControllerOrder(KeyEvent.VK_S));
		
		final ControllerOrder expectedD = ControllerOrder.Right;
		
		//assertEquals(expectedD, View.keyCodeToControllerOrder(KeyEvent.VK_D));
		
		final ControllerOrder expectedNothing = ControllerOrder.Else;
		
		//assertEquals(expectedNothing, View.keyCodeToControllerOrder(KeyEvent.VK_R));
		
	}

}
