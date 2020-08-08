package game1;

public class Camera {
	
	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(GameObject object) {
		
		// Smoothly transition the camera, so that it is not directly on player
		// If you want less smooth, go with x = Object.getX() + 1000/2;
		
		x += ((object.getX() - x) - 1000/2) * 0.05f;
		y += ((object.getY() - y) - 563/2) * 0.05f;
		
		if (x <= 0) x = 0;
		if (x >= 1032) x = 1032;
		if (y <= 0) y = 0;
		if (y >= 536+48) y = 536+48;
		
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
}
