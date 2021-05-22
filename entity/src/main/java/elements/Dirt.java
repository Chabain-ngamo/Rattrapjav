package elements;

import entity.Sprite;
/**
 * The Dirt abstract class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */

public class Dirt extends motionlessElements{
	
	/**
	 *  Sprite of a dirt.
	 */
	private static final Sprite sprite = new Sprite('t',"/sprites/settings/","Dirt.png");
	static {
		sprite.loadImage();
	}
	
	
	
	/**
	 * The Dirt's constructor
	 * @param x the x of the dirt
	 * @param y the y of the dirt
	 */
	public Dirt(int x, int y) {
		super(sprite, x, y);
	}

}
