package elements;

import java.io.IOException;

import entity.Sprite;

public class Win extends motionlessElements {
	
	private static final Sprite sprite = new Sprite('e',"Door.png");
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
