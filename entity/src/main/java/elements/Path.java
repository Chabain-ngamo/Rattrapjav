package elements;

import entity.Sprite;

/**
 * The Path class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */

public class Path extends motionlessElements {
	
	private static final Sprite sprite = new Sprite('p',"/sprites/settings/","Background.png");
	static {
		sprite.loadImage();
	}
	
	
	/**
	 * The Path's constructor.
	 * @param x the x of the path
	 * @param y the y of the path
	 */
	public Path(int x, int y) {
		super(sprite, x, y);
	}

}
