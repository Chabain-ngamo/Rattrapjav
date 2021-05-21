package elements;

import java.io.IOException;

import entity.Sprite;

public class Dirt extends motionlessElements{
	
	private static final Sprite sprite = new Sprite('t',"Dirt.png");
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
