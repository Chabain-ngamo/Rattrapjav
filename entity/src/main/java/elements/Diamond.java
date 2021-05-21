package elements;

import java.io.IOException;

import Actions.Falling;
import entity.Game;
import entity.Sprite;

public class Diamond extends mobileElements {
	
private static final Sprite sprite = new Sprite('x',"Diamond.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	@Override
	protected void setGame(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object getGame() {
		// TODO Auto-generated method stub
		return null;
	}

}
