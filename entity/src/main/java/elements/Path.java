package elements;

import java.io.IOException;

import entity.Sprite;

public class Path extends motionlessElements {
	
	private static final Sprite sprite = new Sprite('u',"Background.png");
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
