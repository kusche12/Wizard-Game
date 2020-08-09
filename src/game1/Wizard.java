package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wizard extends GameObject {
	
	Handler handler;

	public Wizard(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		
		// Movement
		if (handler.isUp()) velY = -5;
		else if (!handler.isDown()) velY = 0;
		
		if (handler.isDown()) velY = 5;
		else if (!handler.isUp()) velY = 0;
		
		if (handler.isRight()) velX = 5;
		else if (!handler.isLeft()) velX = 0;
		
		if (handler.isLeft()) velX = -5;
		else if (!handler.isRight()) velX = 0;
	}
	
	// If object is a block and it is intersecting the wizard, 
	// then repel the wizard away
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {			
			GameObject temp = handler.object.get(i);
			if (temp.getId() == ID.Block) {
				if (getBounds().intersects(temp.getBounds())) {
					x += velX * -1;
					y += velY * -1;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 48);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 48);
	}

}
