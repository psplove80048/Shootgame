import java.awt.image.BufferedImage;

public class BigAirplane extends FlyingObject  {
	private int step;
	
	
	public BigAirplane(){
		width = 66;
		height = 89;
		x = (int)(Math.random()*(World.WIDTH-this.width));
		y = -this.height;
		step = 2;
	}
	
	
	public void step(){
		y+=step;
	}
	
	int deadIndex = 1;
	public BufferedImage getImage(){
		if(isLife()){
			return Images.bigairplanes[0];
		}else if(isDead()){
			BufferedImage img = Images.bigairplanes[deadIndex++];
			if(deadIndex==Images.bigairplanes.length){
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
	

	public int getScore(){
		return 3;
	}
	
	public boolean outOfBounds(){
		return this.y>=World.HEIGHT;
	}
}

