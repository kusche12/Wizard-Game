package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject {
	
	private Handler handler;
	Random r = new Random();
	int choose = 0;
	int hp = 100;

	public Enemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		// Choose a random direction every time random hits 10
		choose = r.nextInt(10);
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if (temp.getId() == ID.Block) {
				if (getBoundsBig().intersects(temp.getBounds())) {
					x += (velX*5) * -1;
					y += (velY*5) * -1;
					velX *= -1;
					velY *= -1;
				} else if (choose == 0) {
					velX =  (r.nextInt(4 - -4) + -4);
					velY =  (r.nextInt(4 - -4) + -4);
				}
			}
			
			// If a bullet it hitting an enemy, update its health and remove the bullet
			if (temp.getId() == ID.Bullet) {
				if (getBounds().intersects(temp.getBounds())) {
					hp -= 50;
					handler.removeObject(temp);	
				}
				
			}
		}
		
		if (hp <= 0) handler.removeObject(this);
		
		
		
	}
	

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x,  y,  32, 32);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public Rectangle getBoundsBig() {
		return new Rectangle(x-16, y-16, 64, 64);
	}

}
