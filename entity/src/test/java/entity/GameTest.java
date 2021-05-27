package entity;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
	 * @throws LineUnavailableException 
     * A LineUnavailableException is an exception indicating that aline cannot be opened because it is unavailable. This situationarises most commonly when a requested line is already in useby another 
     * @throws IOException 
     * Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed orinterrupted I/O operations
     * @throws UnsupportedAudioFileException 
     * means An UnsupportedAudioFileException is an exception indicating that an operation failed because a file did not contain valid data of a recognized filetype and format. 
	 
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
		
		
		
	}
	
	

}
