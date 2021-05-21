package elements;

import java.io.IOException;

import Actions.EnemyMoveB;
import entity.Game;
import entity.Sprite;

public class Enemy extends mobileElements {
	
	
	private static final Sprite spriteDown = new Sprite('i',"Enemy.png");
	static {
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The enemy's constructor
	 * Use of DP strategy to set a specific one.
	 * @param x the initial enemy's x
	 * @param y the initial enemy's y
	 */
	public Enemy(int x, int y) {
		super(spriteDown, x, y);
		this.setStrategy(new EnemyMoveB(this));
		this.isAlive = true;
	}
	
	/**
	 * The getSpriteDown method.
	 * @return Sprite the down sprite of the enemy
	 */
	public Sprite getSpriteDown() {
		return Enemy.spriteDown;
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
