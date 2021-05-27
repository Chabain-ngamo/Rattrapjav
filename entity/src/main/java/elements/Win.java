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
	 * The Win's constructor
	 * @param x the x of the win
	 * @param y the y of the win
	 */
	public Win(int x, int y) {
		super(sprite, x, y);
	}

}
