package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {

	private Handler handler;
	
	public Bullet(int x, int y, ID id, Handler handler, int mx, int my, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		
		// Set the direction of the bullets based on where the user clicked
		velX = (mx - x) / 10;
		velY = (my - y) / 10;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		// Check for collisions
		// If hits block, remove it from the objects on screen
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if (temp.getId() == ID.Block) {
				if (getBounds().intersects(temp.getBounds())) {
					handler.removeObject(this);
				}
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x,  y,  8,  8);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

}
