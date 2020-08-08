package game1;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	private boolean up = false, down = false, left = false, right = false;
	
	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject temp = object.get(i);
			
			temp.tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject temp = object.get(i);
			
			temp.render(g);
		}
	}
	
	public void addObject(GameObject temp) {
		object.add(temp);
		
	}
	
	public void removeObject(GameObject temp) {
		object.remove(temp);
	}
	
}
