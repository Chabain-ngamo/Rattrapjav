package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elements.Avatar;
import entity.Game;
import entity.Sprite;

/**
 * The AvatarTest class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 */
public class AvatarTest extends entityTest {
	
	/** The player of the test */
	private static Avatar aTest;
	/** The key pressed by the player */
    private static char keyPressed;
    /** The game of the player */
    private Game game;
    /** The basic sprite of the player */
	/** The down sprite for the player */
	private static final Sprite spriteDown = new Sprite('a', "Avatar.png");
	/** The left sprite for the player */
	private static final Sprite spriteTurnLeft = new Sprite('a', "AvatarLeft.png");
	/** The right sprite for the player */
	private static final Sprite spriteTurnRight = new Sprite('a', "AvatarRight.png");
	/** The up sprite for the player */
	private static final Sprite spriteUp = new Sprite('a', "AvatarUp.png");

	/**
	 * Load the player's sprites.
	 * @throws Exception in case of an exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		entity = new Avatar(6,6);
		aTest  = new Avatar(0,0);
		keyPressed = 'Z';
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}



	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * The testPlayer method.
	 * Checks the basic sprite name, character and strategy of the player.
	 */
	@Test
	public void testPlayer() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Avatar.png";
		final char expectedCharName = 'a';

	}
	
	
	/**
	 * Test the different directions of the player.
	 */
	@Test
    public void testMovePlayer() {
            switch (keyPressed) {
            case 'Z':
                aTest.setSprite(spriteDown);
                break;
            case 'Q':
                aTest.setSprite(spriteTurnLeft);
                break;
            case 'S':
                aTest.setSprite(spriteUp);
                break;
            case 'D':
                aTest.setSprite(spriteTurnRight);
                break;
            }
            assertEquals(spriteDown, aTest.getSprite());
    }
	

	
	/**
	 * Increases the player's diamond counter through all manners.
	 * Verify the amount of diamonds the player has.
	 */
	@Test
	public void testDiamondCounterPlayer() {	
		final int expectedInitialDiamondCounter = 0;
		
		assertEquals(expectedInitialDiamondCounter, aTest.getDiamondsCounter());
		
		aTest.incrementDiamondsCounter();
		
		final int expectedIncrementedDiamondCounter = 1;
		
		assertEquals(expectedIncrementedDiamondCounter, aTest.getDiamondsCounter());
		
		aTest.increaseDiamondsCounter(4);
		
		final int expectedIncreasedDiamondCounter = 5;
		
		assertEquals(expectedIncreasedDiamondCounter, aTest.getDiamondsCounter());
	}
	
	/**
	 * Verify the player can move foward the next level with the correct amount of diamonds.
	 */


}