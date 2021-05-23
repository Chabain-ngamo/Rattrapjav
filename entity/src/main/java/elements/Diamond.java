package elements;

import Actions.Falling;
import entity.Game;
import entity.Sprite;
/**
 * The Diamond class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */

public class Diamond extends mobileElements {
	
	/**
	 * Sprite of a diamond.
	 */
private static final Sprite sprite = new Sprite('D',"/sprites/settings/","Diamond.png");
	
	static {
		sprite.loadImage();
	}
	
	/**
	 * The diamond's constructor.
	 * @param x the diamond's x
	 * @param y the diamond's y
	 */
	public Diamond(int x, int y) {
		super(sprite, x, y);
		this.setStrategy(new Falling(this));
	}

	

}
