package elements;

import java.io.IOException;

import entity.Sprite;

public class Wall extends motionlessElements {
	
private static final Sprite sprite = new Sprite('q',"Wall.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
