/**
 * 
 */
package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The test class for the Sprite class.
 * @author media
 *
 */
public class SpriteTest {
	Sprite sprite;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/** 
	 * This will set up once all of the test methods in the class are done.
	 * It is used to release the allocathon that the BeforeClass method allocates. It runs even if the BeforeClass method throws an exception.
	 * 
	 * @throws Exception Every Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 *  Sets up the method before each Test method.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sprite = new Sprite('O', "/sprites/settings/", "diamonds.png");
	}

	/**
	 * Sets up after each Test method.
	 * It is used to release the allocathon that the Before method allocates. It runs even if the Before method throws an exception.
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	

	

	/**
	 * Test method for {@link entity.element.Sprite#loadImage()}.
	 */
	@Test
	public void testLoadImage() {
		this.sprite.loadImage();
		Assert.assertNotNull(this.sprite.getImage());
	}

	

	/**
	 * Test method for {@link entity.element.Sprite#setImageName(java.lang.String)}.
	 */
	@Test
	public void testSetImageName() {
		String expected ="Diamond.png";
		this.sprite.setImageName(expected);
		Assert.assertEquals(expected, this.sprite.getImageName());
	}

	/**
	 * Test method for {@link entity.element.Sprite#setSpritePath()}.
	 */
	
	@Test
	public void testSetSpritePath() {
		String expected = "/sprites/settings/";
		this.sprite.setSpritePath(expected);
		Assert.assertEquals(expected, this.sprite.getSpritePath());
		
	}

	
	/**
	 * Test method for {@link entity.element.Sprite#setSprite_ref(char)}.
	 */
	@Test
	public void testSetSprite_ref() {
		char expected = 'O';
		this.sprite.setSprite_ref(expected);
		Assert.assertEquals(expected, this.sprite.getSprite_ref());
	}

}

