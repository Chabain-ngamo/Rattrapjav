package elements;

import java.io.IOException;

public class Diamond extends mobileElements {
	
private static final Sprite sprite = new Sprite('x',"Diamond.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Diamond(int x, int y) {
		super(sprite, x, y);
		this.setStrategy(new BasicFalling(this));
	}

}
