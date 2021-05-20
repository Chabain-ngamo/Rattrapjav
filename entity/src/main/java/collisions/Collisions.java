package collisions;

import entity.Entity;

public class Collisions {
	
	public Collisions() {

	}
	
	public boolean gameCollisions(Entity[][] entity, int x, int y) {
		if (entity[x][y] instanceof Stone) {
			return true;
		} else if (entity[x][y] instanceof Walls) {
			return true;
		} else if (entity[x][y] instanceof ExitDoor) {
			return true;
		} else if (entity[x][y] instanceof Enemy) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean gameDiamonds(Entity[][] playerPosition, int x, int y) {

		if (playerPosition[x][y] instanceof Diamond) {
			return true;
		}
		return false;
	}
	
	
	public boolean gameAvatar(Entity[][] entity, int x, int y) {

		if (entity[x][y] instanceof Avatar) {
			return true;
		}
		return false;
	}
	
	
	public boolean gamePath(Entity[][] entity, int x, int y) {

		if (entity[x][y] instanceof Path) {
			return false;
		}
		return true;
	}
	
	public boolean moveStone(Entity[][] entity, int x, int y, int sideX) { 

		if (entity[x][y] instanceof Stone && entity[x+sideX][y] instanceof Path) {
			return true;
		}
		return false;
	}
	
	


}
