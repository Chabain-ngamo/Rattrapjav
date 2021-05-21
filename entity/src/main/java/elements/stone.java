package elements;

import java.io.IOException;

import Actions.FallingMove;
import entity.Game;
import entity.Sprite;

public class stone extends mobileElements {
	
	private static final Sprite sprite = new Sprite('o',"Stone.png");
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
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


	private void setActions(FallingMove fallingMove) {
		// TODO Auto-generated method stub
		
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
