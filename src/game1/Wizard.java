package game1;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Wizard extends GameObject {
	
	Handler handler;
	Game game;
	private BufferedImage wizard_image;

	public Wizard(int x, int y, ID id, Handler handler, Game game, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		this.game = game;
		wizard_image = ss.grabImage(1, 1, 32, 48);
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
			if (temp.getId() == ID.Crate) {
				if (getBounds().intersects(temp.getBounds())) {
					game.ammo += 10;
					handler.removeObject(temp);
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(wizard_image, x,y,null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 48);
	}

}
