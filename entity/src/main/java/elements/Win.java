package elements;

import java.io.IOException;

import entity.Sprite;

/**
 * The Win class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */

public class Win extends motionlessElements {
	
	private static final Sprite sprite = new Sprite('W',"Door.png");
	static {
		sprite.loadImage();
	}
	
	
	/**
	 * The ExitDoor's constructor
	 * @param x the x of the exit door
	 * @param y the y of the exit door
	 */
	public Win(int x, int y) {
		super(sprite, x, y);
	}

}
