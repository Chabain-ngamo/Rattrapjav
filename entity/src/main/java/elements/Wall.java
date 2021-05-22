package elements;

import java.io.IOException;

import entity.Sprite;
/**
 * The Wall class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */


public class Wall extends motionlessElements {
	
private static final Sprite sprite = new Sprite('q',"/sprites/settings/","Wall.png");
	
	static {
		sprite.loadImage();
	}

	/**
	 * The Wall's constructor.
	 * @param x the x of the wall
	 * @param y the y of the wall
	 */
	public Wall(int x, int y) {
		super(sprite, x, y);
	}

}
