import java.awt.image.BufferedImage;


public class Airplane extends FlyingObject  {
	private int step;

	public Airplane() {
		width = 48;
		height = 50;
		x = (int) (Math.random() * (World.WIDTH - this.width));
		y = -this.height;
		step = 2; 
	}

	
	public void step() {
		y += step;
	}

	int deadIndex = 1;

	public BufferedImage getImage() {
		if (isLife()) {
			return Images.airplanes[0];
		} else if (isDead()) {
			BufferedImage img = Images.airplanes[deadIndex++];
			if (deadIndex == Images.airplanes.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}

	public int getScore() {
		return 1;
	}

	public boolean outOfBounds() {
		return this.y >= World.HEIGHT;
	}

}