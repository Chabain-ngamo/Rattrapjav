package elements;

import java.io.IOException;

import Actions.EnemyMoveB;
import entity.Game;
import entity.Sprite;

/**
 * Enemy abstract.
 * @author Maiva
 * @author Chabain
 *  @author Vladimir
 *
 */


public class Enemy extends mobileElements {
	
	
	private static final Sprite spriteDown = new Sprite('e',"/sprites/settings/","Enemy.png");
	static {
		spriteDown.loadImage();
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

	

}
