package elements;

import java.io.IOException;
import Actions.FallingMove;
import entity.Game;
import entity.Sprite;

/**
 * The Stone class.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */


public class stone extends mobileElements {
	
	private static final Sprite sprite = new Sprite('s',"Stone.png");
	static {
		sprite.loadImage();
	}
	
	
	/**
	 * The stone's constructor
	 * @param x the initial stone's x on the map
	 * @param y the initial stone's y on the map
	 */
	public stone(int x, int y) {
		
		super(sprite, x, y);
		this.setActions(new FallingMove(this));
	}


	


	

}
